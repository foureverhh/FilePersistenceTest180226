package com.nackademin.foureverhh.toolbarlearningyoutube180228;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialise the Toolbar object
        toolbar = findViewById(R.id.app_bar);
        //Set the toolbar as app bar
        setSupportActionBar(toolbar);

        ActionBar actionbar = getSupportActionBar();
        actionbar.setTitle("Welcome");
        actionbar.setSubtitle("all");

        /*works
        getSupportActionBar().setTitle("Welcome");
        toolbar.setSubtitle("all");

        getSupportActionBar().setTitle("Welcome");
        getSupportActionBar().setSubtitle("all");
        */

        /* Does not work
        getSupportActionBar().setTitle("Welcome");
        toolbar.setSubtitle("all");

        toolbar.setTitle("Welcome");
        getSupportActionBar().setSubtitle("all");
        */

     /*   //Make the ActionBar, which is toolbar in this case , can redirect back to the home page
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);*/

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
}
