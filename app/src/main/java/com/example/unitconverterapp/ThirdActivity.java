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

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        // Initialize elements
        EditText tEditText = findViewById(R.id.editTextNumber3);
        Spinner tSourceUnitSpinner = findViewById(R.id.spinner4);
        Spinner tDestinationUnitSpinner = findViewById(R.id.spinner5);
        Button tConvertButton = findViewById(R.id.button9);
        TextView tResult = findViewById(R.id.textView11);
        TextView tResultHeading = findViewById(R.id.textView12);
        Button lengthButton = findViewById(R.id.button10);
        Button weightButton = findViewById(R.id.button11);

        // Initialize spinners
        String[] tempNames = {"degrees Celsius", "degrees Fahrenheit", "degrees Kelvin"};
        String[] temperatures = {"°C", "°F", "°K"};
        ArrayAdapter<String> tSourceUnitAdapter = new ArrayAdapter<>(ThirdActivity.this, android.R.layout.simple_spinner_dropdown_item, temperatures);
        tSourceUnitSpinner.setAdapter(tSourceUnitAdapter);
        tSourceUnitSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), tempNames[i], Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                //stuff
            }
        });
        ArrayAdapter<String> tDestinationUnitAdapter = new ArrayAdapter<>(ThirdActivity.this, android.R.layout.simple_spinner_dropdown_item, temperatures);
        tDestinationUnitSpinner.setAdapter(tDestinationUnitAdapter);
        tDestinationUnitSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), tempNames[i], Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                //stuff
            }
        });

        //Change Activity
        lengthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ThirdActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
        weightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ThirdActivity.this, SecondActivity.class);
                startActivity(i);
            }
        });

        // Convert
        tConvertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get user input
                String inputValue = tEditText.getText().toString();
                String tSource = tSourceUnitSpinner.getSelectedItem().toString();
                String tDest = tDestinationUnitSpinner.getSelectedItem().toString();

                // Calculate Conversion
                double tResultValue = Double.parseDouble(inputValue);
                switch (tSource) {
                    case "°C":
                        switch (tDest) {
                            case "°C":
                                tResultValue /= 1;
                                break;
                            case "°F":
                                tResultValue *= 1.8;
                                tResultValue += 32;
                                break;
                            case "°K":
                                tResultValue += 273.15;
                                break;
                        }
                        break;
                    case "°F":
                        switch (tDest) {
                            case "°C":
                                tResultValue -= 32;
                                tResultValue /= 1.8;
                                break;
                            case "°F":
                                tResultValue /= 1;
                                break;
                            case "°K":
                                tResultValue -= 32;
                                tResultValue /= 1.8;
                                tResultValue += 273.15;
                                break;
                        }
                        break;
                    case "°K":
                        switch (tDest) {
                            case "°C":
                                tResultValue -= 273.15;
                                break;
                            case "°F":
                                tResultValue -= 273.15;
                                tResultValue *= 1.8;
                                tResultValue += 32;
                                break;
                            case "°K":
                                tResultValue /= 1;
                                break;
                        }
                        break;
                }

                // Round decimal places
                String tResultText;
                if ((int) tResultValue == tResultValue) {
                    tResultText = String.format(inputValue + " " + tSource + " = %.0f " + tDest, tResultValue);
                } else if ((int) (10 * tResultValue) == 10 * tResultValue) {
                    tResultText = String.format(inputValue + " " + tSource + " = %.1f " + tDest, tResultValue);
                } else if ((int) (100 * tResultValue) == 100 * tResultValue) {
                    tResultText = String.format(inputValue + " " + tSource + " = %.2f " + tDest, tResultValue);
                } else if ((int) (1000 * tResultValue) == 1000 * tResultValue) {
                    tResultText = String.format(inputValue + " " + tSource + " = %.3f " + tDest, tResultValue);
                } else if ((int) (10000 * tResultValue) == 10000 * tResultValue) {
                    tResultText = String.format(inputValue + " " + tSource + " = %.4f " + tDest, tResultValue);
                } else {
                    tResultText = String.format(inputValue + " " + tSource + " = %.5f " + tDest, tResultValue);
                }

                // Output results
                tResult.setText(tResultText);
                tResultHeading.setVisibility(View.VISIBLE);
                tResult.setVisibility(View.VISIBLE);
            }
        });
    }
}