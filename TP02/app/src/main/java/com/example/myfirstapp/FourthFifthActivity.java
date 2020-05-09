package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class FourthFifthActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager sensorManager;
    private Sensor light, thermostat, gyroscope;

    TextView lightValue, temperatureValue;
    TextView gyroX, gyroY, gyroZ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth_fifth);
        setTitle("Sensors");

        // Text Views
        lightValue = findViewById(R.id.light_text);
        temperatureValue = findViewById(R.id.temperature_text);
        gyroX = findViewById(R.id.gyroscope_text_X);
        gyroY = findViewById(R.id.gyroscope_text_Y);
        gyroZ = findViewById(R.id.gyroscope_text_Z);

        //Sensors
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        // Light sensor
        light = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        if (light != null)
        {
            sensorManager.registerListener(this, light, SensorManager.SENSOR_DELAY_NORMAL);
        }
        else
        {
            lightValue.setText("Light sensor not supported!");
        }

        // Temperature sensor
        thermostat = sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
        if (thermostat != null)
        {
            sensorManager.registerListener(this, thermostat, SensorManager.SENSOR_DELAY_NORMAL);
        }
        else
        {
            temperatureValue.setText("Thermostat not supported!");
        }

        // Gryoscope
        gyroscope = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        if (gyroscope != null)
        {
            sensorManager.registerListener(this, gyroscope, SensorManager.SENSOR_DELAY_NORMAL);
        }
        else
        {
            gyroX.setText("Gyroscope not supported!");
            gyroY.setText("");
            gyroZ.setText("");
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy){

    }

    public void onSensorChanged(SensorEvent event)
    {
        Sensor sensor = event.sensor;

        switch(sensor.getType())
        {
            case Sensor.TYPE_LIGHT:
                lightValue.setText("Light Intensity: " + event.values[0]);
                break;
            case Sensor.TYPE_AMBIENT_TEMPERATURE:
                temperatureValue.setText("Temperature: " + event.values[0]);
                break;
            case Sensor.TYPE_GYROSCOPE:
                gyroX.setText("Gyroscope X: " + event.values[0]);
                gyroY.setText("Gyroscope Y: " + event.values[1]);
                gyroZ.setText("Gyroscope Z: " + event.values[2]);
                break;
            default:
                break;
        }
    }


}
