package com.example.unitconverterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize elements
        EditText editText = findViewById(R.id.editTextNumber);
        Spinner sourceUnitSpinner = findViewById(R.id.spinner1);
        Spinner destinationUnitSpinner = findViewById(R.id.spinner2);
        Button convertButton = findViewById(R.id.button);
        TextView result = findViewById(R.id.textView4);
        TextView resultHeading = findViewById(R.id.textView5);
        Button weightButton = findViewById(R.id.button3);
        Button tempButton = findViewById(R.id.button4);

        // Initialize spinners
        String[] lengthNames = {"inches", "feet", "yards", "miles", "millimetres", "centimetres", "metres", "kilometres"};
        String[] lengths = {"in", "ft", "yd", "mi", "mm", "cm", "m", "km"};
        ArrayAdapter<String> sourceUnitAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, lengths);
        sourceUnitSpinner.setAdapter(sourceUnitAdapter);
        sourceUnitSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), lengthNames[i], Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                //stuff
            }
        });
        ArrayAdapter<String> destinationUnitAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, lengths);
        destinationUnitSpinner.setAdapter(destinationUnitAdapter);
        destinationUnitSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), lengthNames[i], Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                //stuff
            }
        });

        //Change Activity
        weightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(i);
            }
        });
        tempButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ThirdActivity.class);
                startActivity(i);
            }
        });

        // Convert
        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get user input
                String inputValue = editText.getText().toString();
                String source = sourceUnitSpinner.getSelectedItem().toString();
                String dest = destinationUnitSpinner.getSelectedItem().toString();

                // Calculate Conversion
                double resultValue = Double.parseDouble(inputValue);
                switch (source) {
                    case "in":
                        switch (dest) {
                            case "in":
                                resultValue /= 1;
                                break;
                            case "ft":
                                resultValue /= 12;
                                break;
                            case "yd":
                                resultValue /= 36;
                                break;
                            case "mi":
                                resultValue /= 63360;
                                break;
                            case "mm":
                                resultValue *= 25.4;
                                break;
                            case "cm":
                                resultValue *= 2.54;
                                break;
                            case "m":
                                resultValue *= 0.0254;
                                break;
                            case "km":
                                resultValue *= 0.0000254;
                                break;
                        }
                        break;
                    case "ft":
                        switch (dest) {
                            case "in":
                                resultValue *= 12;
                                break;
                            case "ft":
                                resultValue /= 1;
                                break;
                            case "yd":
                                resultValue /= 3;
                                break;
                            case "mi":
                                resultValue /= 5280;
                                break;
                            case "mm":
                                resultValue *= 304.8;
                                break;
                            case "cm":
                                resultValue *= 30.48;
                                break;
                            case "m":
                                resultValue *= 0.3048;
                                break;
                            case "km":
                                resultValue *= 0.0003048;
                                break;
                        }
                        break;
                    case "yd":
                        switch (dest) {
                            case "in":
                                resultValue *= 36;
                                break;
                            case "ft":
                                resultValue *= 3;
                                break;
                            case "yd":
                                resultValue /= 1;
                                break;
                            case "mi":
                                resultValue /= 1760;
                                break;
                            case "mm":
                                resultValue *= 914.4;
                                break;
                            case "cm":
                                resultValue *= 91.44;
                                break;
                            case "m":
                                resultValue *= 0.9144;
                                break;
                            case "km":
                                resultValue *= 0.0009144;
                                break;
                        }
                        break;
                    case "mi":
                        switch (dest) {
                            case "in":
                                resultValue *= 63360;
                                break;
                            case "ft":
                                resultValue *= 5280;
                                break;
                            case "yd":
                                resultValue *= 1760;
                                break;
                            case "mi":
                                resultValue /= 1;
                                break;
                            case "mm":
                                resultValue *= 1609340;
                                break;
                            case "cm":
                                resultValue *= 160934;
                                break;
                            case "m":
                                resultValue *= 1609.34;
                                break;
                            case "km":
                                resultValue *= 1.60934;
                                break;
                        }
                        break;
                    case "mm":
                        switch (dest) {
                            case "in":
                                resultValue /= 25.4;
                                break;
                            case "ft":
                                resultValue /= 304.8;
                                break;
                            case "yd":
                                resultValue /= 914.4;
                                break;
                            case "mi":
                                resultValue /= 1609340;
                                break;
                            case "mm":
                                resultValue /= 1;
                                break;
                            case "cm":
                                resultValue /= 10;
                                break;
                            case "m":
                                resultValue /= 1000;
                                break;
                            case "km":
                                resultValue /= 1000000;
                                break;
                        }
                        break;
                    case "cm":
                        switch (dest) {
                            case "in":
                                resultValue /= 2.54;
                                break;
                            case "ft":
                                resultValue /= 30.48;
                                break;
                            case "yd":
                                resultValue /= 91.44;
                                break;
                            case "mi":
                                resultValue /= 160934;
                                break;
                            case "mm":
                                resultValue *= 10;
                                break;
                            case "cm":
                                resultValue /= 1;
                                break;
                            case "m":
                                resultValue /= 100;
                                break;
                            case "km":
                                resultValue /= 100000;
                                break;
                        }
                        break;
                    case "m":
                        switch (dest) {
                            case "in":
                                resultValue /= 0.0254;
                                break;
                            case "ft":
                                resultValue /= 0.3048;
                                break;
                            case "yd":
                                resultValue /= 0.9144;
                                break;
                            case "mi":
                                resultValue /= 1609.34;
                                break;
                            case "mm":
                                resultValue *= 1000;
                                break;
                            case "cm":
                                resultValue *= 100;
                                break;
                            case "m":
                                resultValue /= 1;
                                break;
                            case "km":
                                resultValue /= 1000;
                                break;
                        }
                        break;
                    case "km":
                        switch (dest) {
                            case "in":
                                resultValue /= 0.0000254;
                                break;
                            case "ft":
                                resultValue /= 0.0003048;
                                break;
                            case "yd":
                                resultValue /= 0.0009144;
                                break;
                            case "mi":
                                resultValue /= 1.60934;
                                break;
                            case "mm":
                                resultValue *= 1000000;
                                break;
                            case "cm":
                                resultValue *= 100000;
                                break;
                            case "m":
                                resultValue *= 1000;
                                break;
                            case "km":
                                resultValue /= 1;
                                break;
                        }
                        break;
                }

                // Round decimal places
                String resultText;
                if ((int) resultValue == resultValue) {
                    resultText = String.format(inputValue + " " + source + " = %.0f " + dest, resultValue);
                } else if ((int) (10 * resultValue) == 10 * resultValue) {
                    resultText = String.format(inputValue + " " + source + " = %.1f " + dest, resultValue);
                } else if ((int) (100 * resultValue) == 100 * resultValue) {
                    resultText = String.format(inputValue + " " + source + " = %.2f " + dest, resultValue);
                } else if ((int) (1000 * resultValue) == 1000 * resultValue) {
                    resultText = String.format(inputValue + " " + source + " = %.3f " + dest, resultValue);
                } else if ((int) (10000 * resultValue) == 10000 * resultValue) {
                    resultText = String.format(inputValue + " " + source + " = %.4f " + dest, resultValue);
                } else {
                    resultText = String.format(inputValue + " " + source + " = %.5f " + dest, resultValue);
                }

                // Output results
                result.setText(resultText);
                resultHeading.setVisibility(View.VISIBLE);
                result.setVisibility(View.VISIBLE);
            }
        });
    }
}