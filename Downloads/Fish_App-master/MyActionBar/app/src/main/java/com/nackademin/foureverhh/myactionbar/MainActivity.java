package com.nackademin.foureverhh.myactionbar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Make Toolbar become action bar
        toolbar = findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
    }

    //Inflate the Menu customised to the action bar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);

        return super.onCreateOptionsMenu(menu);
    }

    //Decide which item on the meny is chosen
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId())
        {
            //The help item
            case R.id.help:
                Intent help = new Intent(this,Help.class);
                startActivity(help);
                Toast.makeText(getApplicationContext(),"Help",Toast.LENGTH_SHORT).show();
                break;
            //The setting item
            case R.id.settings:
                Intent intent = new Intent(this,SettingsActivity.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(),"Setting",Toast.LENGTH_SHORT).show();
                break;
            //The update item
            case R.id.update:
                Toast.makeText(getApplicationContext(),"Latest Version",Toast.LENGTH_LONG).show();
                break;
            //The comment item
            case R.id.comment:
                Intent comment = new Intent(this,CommentPage.class);
                startActivity(comment);
                break;
            //Unknown error
            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
