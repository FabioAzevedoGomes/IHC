package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    Button button_1,button_2,button_3, button_4, button_5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Identifica os botões

        button_1 = findViewById(R.id.activity_1);
        button_2 = findViewById(R.id.activity_2);
        button_3 = findViewById(R.id.activity_3);
        button_4 = findViewById(R.id.activity_4_5);
        button_5 = findViewById(R.id.activity_6);

        // Listeners para os botões
        button_1.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v) {
                start_act1(v);
            }
        });

        button_2.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v) {
                start_act2(v);
            }
        });

        button_3.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v) {
                start_act3(v);
            }
        });

        button_4.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v) {
                start_act4_5(v);
            }
        });

        ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 123);

        button_5.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                GPSTracker g = new GPSTracker(getApplicationContext());
                Location l = g.getLocation();
                if (l != null) {
                    double lat = l.getLatitude();
                    double longi = l.getLongitude();
                    Toast.makeText(getApplicationContext(), "LAT: " + lat + "LONG: " + longi, Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Unable to get location", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    protected void onPause(){
        super.onPause();
    }

    @Override
    protected void onResume(){
        super.onResume();
    }

    public void start_act1(View view)
    {
        Intent i_1 = new Intent(this, FirstActivity.class);
        startActivity(i_1);
    }

    public void start_act2(View view)
    {
        Intent i_2 = new Intent(this, SecondActivitySender.class);
        startActivity(i_2);
    }

    public void start_act3(View view)
    {
        Intent i_3 = new Intent(this, ThirdActivityRead.class);
        startActivity(i_3);
    }

    public void start_act4_5(View view)
    {
        Intent i_4_5 = new Intent(this, FourthFifthActivity.class);
        startActivity(i_4_5);
    }

}
