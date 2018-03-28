package com.nackademin.foureverhh.fragmentslearningudemy180328;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements Communicator {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Add fragments by java
       /* AddFragmentPractice fragmentPractice = new AddFragmentPractice();
        MyFrament frament =new MyFrament();
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.my_layout,fragmentPractice,"AddFragment");
        transaction.add(R.id.my_layout,frament,"Hello from MyFrament");
        transaction.commit();*/

    }

    @Override
    public void respond(String data) {
        FragmentManager manager = getFragmentManager();
        //Define fragmentB
        FragmentInteractionB fragmentB = (FragmentInteractionB) manager.findFragmentById(R.id.fragmentB);
        fragmentB.textChange(data);

    }
}
