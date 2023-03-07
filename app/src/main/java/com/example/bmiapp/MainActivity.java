package com.example.bmiapp;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    public EditText weightText;
    public EditText heightText;
    public TextView resultText;
    public String result;
    public String recordBMI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weightText = findViewById(R.id.weight);
        heightText = findViewById(R.id.height);
        resultText = findViewById(R.id.result);
    }

    public void calculateBMI(View view) {
        String S1 = weightText.getText().toString();
        String S2 = heightText.getText().toString();

        float weightValue = Float.parseFloat(S1);
        float heightValue = Float.parseFloat(S2) / 100;
        float bmi = weightValue / (heightValue * heightValue);

        if (bmi < 16) {
            recordBMI = "Duża niedowaga";
        } else if (bmi < 18.5) {
            recordBMI = "Niedowaga";
        } else if (bmi >= 18.5 && bmi <= 24.9) {
            recordBMI = "Waga w normie";
        } else if (bmi >= 25 && bmi <= 29.9) {
            recordBMI = "Nadwaga";
        } else {
            recordBMI = "Otyłość";
        }
        result = "Wynik:\n" + bmi + "\n" + recordBMI;
        resultText.setText(result);
    }
}