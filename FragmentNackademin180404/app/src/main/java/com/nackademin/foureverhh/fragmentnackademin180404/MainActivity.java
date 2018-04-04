package com.nackademin.foureverhh.fragmentnackademin180404;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyFragment myFragment = new MyFragment();
        MySecondFragment mySecondFragment = new MySecondFragment();
        FragmentManager fragmentManager = getFragmentManager();

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container,myFragment,"myFragment");
        fragmentTransaction.add(R.id.container,mySecondFragment,"myFragment");

        fragmentTransaction.commit();

    }
}
