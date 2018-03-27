package com.nackademin.foureverhh.locationpractiseyoutube180326;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

public class MainActivity extends AppCompatActivity {

    TextView latitudeText, longitudeText, altitudeText, speedText, accuracyText, sensorType, updatesOnOff;
    ToggleButton switchGpsBalanced, locationOnOff;
    private static final int MY_PERMISSION_REQUEST_FINE_LOCATION = 101;
    FusedLocationProviderClient fusedLocationProviderClient;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        altitudeText = findViewById(R.id.altitude);
        latitudeText = findViewById(R.id.latitude);
        longitudeText = findViewById(R.id.longitude);
        speedText = findViewById(R.id.speed);
        accuracyText = findViewById(R.id.accuracy);
        sensorType = findViewById(R.id.sensor);
        updatesOnOff = findViewById(R.id.updates);
        switchGpsBalanced = findViewById(R.id.tbGps_Balanced);
        locationOnOff = findViewById(R.id.tvLocationOnOff);


        switchGpsBalanced.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switchGpsBalanced.isChecked()) {
                    //Using GPS
                    sensorType.setText("GPS");
                } else {
                    //Using balanced power accuracy
                    sensorType.setText("Cell Tower and WiFi");
                }
            }
        });

        locationOnOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (locationOnOff.isChecked()) {
                    //Location updates on
                    updatesOnOff.setText("On");
                } else {
                    //Location updates off
                    updatesOnOff.setText("Off");
                }

            }
        });

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            fusedLocationProviderClient.getLastLocation().addOnSuccessListener(this, new OnSuccessListener<Location>() {
                @Override
                public void onSuccess(Location location) {
                    if (location != null) {
                        latitudeText.setText(String.valueOf(location.getLatitude()));
                        longitudeText.setText(String.valueOf(location.getLongitude()));
                        accuracyText.setText(String.valueOf(location.getAccuracy()));
                        if (location.hasAltitude()) {
                            altitudeText.setText(String.valueOf(location.getAltitude()));
                        } else {
                            latitudeText.setText("No altitude available");
                        }
                        if (location.hasSpeed()) {
                            speedText.setText(String.valueOf(location.getSpeed()) + "/Sec");
                        } else {
                            speedText.setText("No speed available");
                        }

                    }
                }
            });
        }else{
            //Request permissions
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},MY_PERMISSION_REQUEST_FINE_LOCATION);
        }

    }
}
