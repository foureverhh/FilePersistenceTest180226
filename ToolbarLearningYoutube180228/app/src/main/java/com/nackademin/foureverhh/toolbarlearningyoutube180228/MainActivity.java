package com.nackademin.foureverhh.toolbarlearningyoutube180228;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.app_bar); //Initialise the Toolbar object
        setSupportActionBar(toolbar);         //Set the toolbar as app bar

    }
}
