package com.nackademin.foureverhh.toolbarnackademin180228;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("welcome");
        toolbar.setSubtitle("all");

        //To adjust layout to both old and new operation system
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
        {
            //Material design API
            toolbar.setElevation(10f);
        }else{
            //without material design API below 21

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_custmize,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        String msg = "";

        switch(item.getItemId())
        {
            case R.id.discard:
                msg= "Deleting";
                break;
            case R.id.search:
                msg= "Searching";
                break;
        }
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }
}
