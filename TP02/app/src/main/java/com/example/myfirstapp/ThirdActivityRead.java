package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.EditText;

public class ThirdActivityRead extends AppCompatActivity implements SensorEventListener {


    private SensorManager mSensorManager;
    private Sensor mAccelerometer;

    private float[] lastReadings = {0,0,0};

    EditText component_x,component_y,component_z;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        mSensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_read);
        setTitle("Accelerometer");


        component_x = findViewById(R.id.coordinate_x);
        component_y = findViewById(R.id.coordinate_y);
        component_z = findViewById(R.id.coordinate_z);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if(event.sensor.getType()== Sensor.TYPE_ACCELEROMETER) {
            float sensorX = event.values[0];
            float sensorY = event.values[1];
            float sensorZ = event.values[2];

            component_x.setText(String.valueOf(sensorX));
            component_y.setText(String.valueOf(sensorY));
            component_z.setText(String.valueOf(sensorZ));

            float t = 7f;

            float[] diffs = {0,0,0};
            diffs[0] = Math.abs(lastReadings[0] - event.values[0]);
            lastReadings[0] = event.values[0];
            diffs[1] = Math.abs(lastReadings[1] - event.values[1]);
            lastReadings[1] = event.values[1];
            diffs[2] = Math.abs(lastReadings[2] - event.values[2]);
            lastReadings[2] = event.values[2];

            if ((diffs[0] > t && diffs[1] > t) || (diffs[0] >t && diffs[2] > t) || (diffs[1] > t && diffs[2] > t))
            {
                Intent i_m = new Intent(this, ThirdActivityMessage.class);
                startActivity(i_m);
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy)
    {
    }
}
