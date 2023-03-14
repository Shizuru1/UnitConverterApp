package com.example.unitconverterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editText = findViewById(R.id.editTextNumber);
        Spinner sourceUnitSpinner = findViewById(R.id.spinner1);
        Spinner destinationUnitSpinner = findViewById(R.id.spinner2);
        Button convertButton = findViewById(R.id.button);
        TextView result = findViewById(R.id.textView4);
        TextView resultHeading = findViewById(R.id.textView5);

        String[] Units = {"in", "ft", "yd", "mi", "mm", "cm", "m", "km", "oz", "lb", "ton", "mg", "g", "kg", "°C", "°F", "°K"};
        ArrayAdapter<String> sourceUnitAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, Units);
        sourceUnitSpinner.setAdapter(sourceUnitAdapter);
        sourceUnitSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //stuff
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                //stuff
            }
        });
        ArrayAdapter<String> destinationUnitAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, Units);
        destinationUnitSpinner.setAdapter(destinationUnitAdapter);
        destinationUnitSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //stuff
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                //stuff
            }
        });

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputValue = editText.getText().toString();
                Toast.makeText(MainActivity.this, inputValue.toString(), Toast.LENGTH_LONG).show();
                result.setText(inputValue);
                resultHeading.setVisibility(View.VISIBLE);
                result.setVisibility(View.VISIBLE);
            }
        });
    }
}