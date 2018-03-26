package com.nackademin.foureverhh.locationpractiseyoutube180326;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity {

    TextView latitudeText,longitudeText,altitudeText,speedText,accuracyText,sensorType,updatesOnOff;
    ToggleButton switchGpsBalanced,locationOnOff;

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
                if(switchGpsBalanced.isChecked()){
                    //Using GPS
                    sensorType.setText("GPS");
                }else{
                    //Using balanced power accuracy
                    sensorType.setText("Cell Tower and WiFi");
                }
            }
        });

        locationOnOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(locationOnOff.isChecked()){
                    //Location updates on
                    updatesOnOff.setText("On");
                }else {
                    //Location updates off
                    updatesOnOff.setText("Off");
                }

            }
        });



    }
}
