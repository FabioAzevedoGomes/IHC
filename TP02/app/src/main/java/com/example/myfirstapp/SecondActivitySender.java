package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivitySender extends AppCompatActivity {

    TextView input_text;
    Button send_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_sender);
        setTitle("Send");

        input_text = findViewById(R.id.input_text);
        send_button = findViewById(R.id.send_button);

        send_button.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                Send(v);
            }
        });
    }

    private void Send(View view)
    {
        try {
            String message = input_text.getText().toString();
            Intent i = new Intent(this, SecondActivityReceiver.class); // TODO
            i.putExtra("data", message);
            startActivity(i);
        }
        catch(Exception e){

        }
    }

}
