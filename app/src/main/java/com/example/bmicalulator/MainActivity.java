package com.example.bmicalulator;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void calculateBmi(View v){
        EditText input1 = findViewById(R.id.input1);
        EditText input2 = findViewById(R.id.input2);
        EditText result = findViewById(R.id.input3);
        TextView output = findViewById(R.id.output);

        float weight = Float.parseFloat(input1.getText().toString());
        float height = Float.parseFloat(input2.getText().toString());
        if (weight <= 0 || height <= 0){
            Toast toast = Toast.makeText(getApplicationContext(), "Enter weight and height", Toast.LENGTH_LONG);
            toast.show();
        } else {

            float bmi = weight / (height * height);

            result.setText(Float.toString(bmi));

            if (bmi < 18.5)
                output.setText("Underweight");
            else if (bmi >= 18.5 && bmi < 24.9)
                output.setText("Healthy weight");
            else if (bmi >= 24.9 && bmi < 29.9)
                output.setText("Overweight");
            else if (bmi >= 29.9 && bmi < 39.9)
                output.setText("Obesity");
            else if (bmi >= 39.9)
                output.setText("Severly Obese");
        }

    }
}