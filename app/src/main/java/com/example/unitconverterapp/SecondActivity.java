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

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Initialize elements
        EditText sEditText = findViewById(R.id.editTextNumber2);
        Spinner sSourceUnitSpinner = findViewById(R.id.spinner);
        Spinner sDestinationUnitSpinner = findViewById(R.id.spinner3);
        Button sConvertButton = findViewById(R.id.button5);
        TextView sResult = findViewById(R.id.textView6);
        TextView sResultHeading = findViewById(R.id.textView7);
        Button lengthButton = findViewById(R.id.button6);
        Button tempButton = findViewById(R.id.button8);

        // Initialize spinners
        String[] weightNames = {"ounces", "pounds", "stones", "US tons", "milligrams", "grams", "kilograms", "tonnes"};
        String[] weights = {"oz", "lb", "st", "ton", "mg", "g", "kg", "tonne"};
        ArrayAdapter<String> sSourceUnitAdapter = new ArrayAdapter<>(SecondActivity.this, android.R.layout.simple_spinner_dropdown_item, weights);
        sSourceUnitSpinner.setAdapter(sSourceUnitAdapter);
        sSourceUnitSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), weightNames[i], Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                //stuff
            }
        });
        ArrayAdapter<String> sDestinationUnitAdapter = new ArrayAdapter<>(SecondActivity.this, android.R.layout.simple_spinner_dropdown_item, weights);
        sDestinationUnitSpinner.setAdapter(sDestinationUnitAdapter);
        sDestinationUnitSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), weightNames[i], Toast.LENGTH_LONG).show();
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
                Intent i = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
        tempButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SecondActivity.this, ThirdActivity.class);
                startActivity(i);
            }
        });

        // Convert
        sConvertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get user input
                String inputValue = sEditText.getText().toString();
                String sSource = sSourceUnitSpinner.getSelectedItem().toString();
                String sDest = sDestinationUnitSpinner.getSelectedItem().toString();

                // Calculate Conversion
                double sResultValue = Double.parseDouble(inputValue);
                switch (sSource) {
                    case "oz":
                        switch (sDest) {
                            case "oz":
                                sResultValue /= 1;
                                break;
                            case "lb":
                                sResultValue /= 16;
                                break;
                            case "st":
                                sResultValue /= 224;
                                break;
                            case "ton":
                                sResultValue /= 32000;
                                break;
                            case "mg":
                                sResultValue *= 28349.5;
                                break;
                            case "g":
                                sResultValue *= 28.3495;
                                break;
                            case "kg":
                                sResultValue *= 0.0283495;
                                break;
                            case "tonne":
                                sResultValue *= 0.0000283495;
                                break;
                        }
                        break;
                    case "lb":
                        switch (sDest) {
                            case "oz":
                                sResultValue *= 16;
                                break;
                            case "lb":
                                sResultValue /= 1;
                                break;
                            case "st":
                                sResultValue /= 14;
                                break;
                            case "ton":
                                sResultValue /= 2000;
                                break;
                            case "mg":
                                sResultValue *= 453592;
                                break;
                            case "g":
                                sResultValue *= 453.592;
                                break;
                            case "kg":
                                sResultValue *= 0.453592;
                                break;
                            case "tonne":
                                sResultValue *= 0.000453592;
                                break;
                        }
                        break;
                    case "st":
                        switch (sDest) {
                            case "oz":
                                sResultValue *= 224;
                                break;
                            case "lb":
                                sResultValue *= 14;
                                break;
                            case "st":
                                sResultValue /= 1;
                                break;
                            case "ton":
                                sResultValue /= (1000.0 / 7);
                                break;
                            case "mg":
                                sResultValue *= 6350290;
                                break;
                            case "g":
                                sResultValue *= 6350.29;
                                break;
                            case "kg":
                                sResultValue *= 6.35029;
                                break;
                            case "tonne":
                                sResultValue *= 0.00635029;
                                break;
                        }
                        break;
                    case "ton":
                        switch (sDest) {
                            case "oz":
                                sResultValue *= 32000;
                                break;
                            case "lb":
                                sResultValue *= 2000;
                                break;
                            case "st":
                                sResultValue *= (1000.0 / 7);
                                break;
                            case "ton":
                                sResultValue /= 1;
                                break;
                            case "mg":
                                sResultValue *= 907185000;
                                break;
                            case "g":
                                sResultValue *= 907185;
                                break;
                            case "kg":
                                sResultValue *= 907.185;
                                break;
                            case "tonne":
                                sResultValue *= 0.907185;
                                break;
                        }
                        break;
                    case "mg":
                        switch (sDest) {
                            case "oz":
                                sResultValue /= 28349.5;
                                break;
                            case "lb":
                                sResultValue /= 453592;
                                break;
                            case "st":
                                sResultValue /= 6350290;
                                break;
                            case "ton":
                                sResultValue /= 907185000;
                                break;
                            case "mg":
                                sResultValue /= 1;
                                break;
                            case "g":
                                sResultValue /= 1000;
                                break;
                            case "kg":
                                sResultValue /= 1000000;
                                break;
                            case "tonne":
                                sResultValue /= 1000000000;
                                break;
                        }
                        break;
                    case "g":
                        switch (sDest) {
                            case "oz":
                                sResultValue /= 28.3495;
                                break;
                            case "lb":
                                sResultValue /= 453.592;
                                break;
                            case "st":
                                sResultValue /= 6350.29;
                                break;
                            case "ton":
                                sResultValue /= 907185;
                                break;
                            case "mg":
                                sResultValue *= 1000;
                                break;
                            case "g":
                                sResultValue /= 1;
                                break;
                            case "kg":
                                sResultValue /= 1000;
                                break;
                            case "tonne":
                                sResultValue /= 1000000;
                                break;
                        }
                        break;
                    case "kg":
                        switch (sDest) {
                            case "oz":
                                sResultValue /= 0.0283495;
                                break;
                            case "lb":
                                sResultValue /= 0.453592;
                                break;
                            case "st":
                                sResultValue /= 6.35029;
                                break;
                            case "ton":
                                sResultValue /= 907.185;
                                break;
                            case "mg":
                                sResultValue *= 1000000;
                                break;
                            case "g":
                                sResultValue *= 1000;
                                break;
                            case "kg":
                                sResultValue /= 1;
                                break;
                            case "tonne":
                                sResultValue /= 1000;
                                break;
                        }
                        break;
                    case "tonne":
                        switch (sDest) {
                            case "oz":
                                sResultValue /= 0.0000283495;
                                break;
                            case "lb":
                                sResultValue /= 0.000453592;
                                break;
                            case "st":
                                sResultValue /= 0.00635029;
                                break;
                            case "ton":
                                sResultValue /= 0.907185;
                                break;
                            case "mg":
                                sResultValue *= 1000000000;
                                break;
                            case "g":
                                sResultValue *= 1000000;
                                break;
                            case "kg":
                                sResultValue *= 1000;
                                break;
                            case "tonne":
                                sResultValue /= 1;
                                break;
                        }
                        break;
                }

                // Round decimal places
                String sResultText;
                if ((int) sResultValue == sResultValue) {
                    sResultText = String.format(inputValue + " " + sSource + " = %.0f " + sDest, sResultValue);
                } else if ((int) (10 * sResultValue) == 10 * sResultValue) {
                    sResultText = String.format(inputValue + " " + sSource + " = %.1f " + sDest, sResultValue);
                } else if ((int) (100 * sResultValue) == 100 * sResultValue) {
                    sResultText = String.format(inputValue + " " + sSource + " = %.2f " + sDest, sResultValue);
                } else if ((int) (1000 * sResultValue) == 1000 * sResultValue) {
                    sResultText = String.format(inputValue + " " + sSource + " = %.3f " + sDest, sResultValue);
                } else if ((int) (10000 * sResultValue) == 10000 * sResultValue) {
                    sResultText = String.format(inputValue + " " + sSource + " = %.4f " + sDest, sResultValue);
                } else {
                    sResultText = String.format(inputValue + " " + sSource + " = %.5f " + sDest, sResultValue);
                }

                // Output results
                sResult.setText(sResultText);
                sResultHeading.setVisibility(View.VISIBLE);
                sResult.setVisibility(View.VISIBLE);
            }
        });
    }
}