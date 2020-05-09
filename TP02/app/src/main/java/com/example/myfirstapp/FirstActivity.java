package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class FirstActivity extends AppCompatActivity {

    EditText input_1,input_2;
    Button sum_button;
    TextView result_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        setTitle("Calculator");

        input_1 = findViewById(R.id.input_1);
        input_2 = findViewById(R.id.input_2);
        sum_button = findViewById(R.id.sum_button);
        result_text = findViewById(R.id.result_text);

        sum_button.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v) {
                Sum(v);
            }
        });
    }

    private void Sum(View view)
    {
        int num_1,num_2;
        String result;
        try {
            num_1 = Integer.parseInt(input_1.getText().toString());
            num_2 = Integer.parseInt(input_2.getText().toString());
            result = "Result: " +  Integer.toString(num_1 + num_2);
        } catch (NumberFormatException e) {
            result = "Fill both fields!";
        }

        result_text.setText(result);
    }


}
