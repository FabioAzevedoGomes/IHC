package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SecondActivityReceiver extends AppCompatActivity {

    TextView received_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_receiver);
        setTitle("Receive");

        received_text = findViewById(R.id.received_text);

        String message = getIntent().getStringExtra("data");

        received_text.setText(message);
    }
}
