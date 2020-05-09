package com.example.myfirstapp;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.Toast;

import androidx.core.content.ContextCompat;

public class GPSTracker implements LocationListener {

    private Context context;
    private Location l;

    public GPSTracker(Context context)
    {
        this.context = context;
        getLocation();
    }

    public Location getLocation()
    {
        if(ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED)
        {
            Toast.makeText(context, "Permission not granted", Toast.LENGTH_LONG).show();
            return null;
        }

        LocationManager lm   = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        boolean isGPSEnabled = lm.isProviderEnabled(LocationManager.GPS_PROVIDER);
        if (isGPSEnabled)
        {
            lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 10, GPSTracker.this);
            l = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            return l;
        }
        else
        {
            Toast.makeText(context, "GPS not enabled", Toast.LENGTH_LONG).show();
        }
        return null;
    }

    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
    }

    @Override
    public void onProviderEnabled(String provider) {
    }

    @Override
    public void onProviderDisabled(String provider) {
    }


}
