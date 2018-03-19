package com.nackademin.foureverhh.myjoggingapp180319;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    //Declare FirebaseDatabase and DatabaseReference
    FirebaseDatabase database;
    DatabaseReference myReference;

    Button btn;
    private static final int REQUEST_PERMISSION= 2;
    String mPermission = Manifest.permission.ACCESS_FINE_LOCATION;

    GPSTracker gps;
    TextView locationLatitude,locationLongitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try{
            if(ActivityCompat.checkSelfPermission(this,mPermission) != PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(this,new String[]{mPermission},REQUEST_PERMISSION);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gps = new GPSTracker(MainActivity.this); //Current context in MainActivity
                locationLatitude = findViewById(R.id.locationLatitude);
                locationLongitude = findViewById(R.id.locationLongitude);
                if(gps.canGetLocation()){
                    double latitude = gps.getLatitude();
                    double longitude = gps.getLongitude();
                    locationLatitude.setText("Latitude is "+latitude);
                    locationLongitude.setText("Longitude is "+longitude);

                    //Set reference of database
                    database = FirebaseDatabase.getInstance();
                    myReference = database.getReference("Location");
                    myReference.setValue(latitude+" , "+longitude);

                }else{
                    gps.settingsAlert();
                }

            }
        });
    }
}
