package com.nackademin.foureverhh.clintapptogpsyoutube180315;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    String value = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Location");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                value = dataSnapshot.getValue(String.class);
                TextView textView = findViewById(R.id.locText);
                textView.setText(value);
                String[] separated = value.split(",");
                String latPos = separated[0].trim();
                String logPos = separated[1].trim();

                double dLat = Double.parseDouble(latPos);
                double dLon = Double.parseDouble(logPos);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}
