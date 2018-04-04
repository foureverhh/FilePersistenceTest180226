package com.nackademin.foureverhh.fragmentnackademin180404;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager= getFragmentManager();

    }
    public void addMyFragment(View view){
        MyFragment myFragment = new MyFragment();
        //leads to crash because of fragment is not build yet
        //myFragment.setTextInTextView("Set text to MyFragment object");
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container,myFragment,"myFragment");
        fragmentTransaction.commit();

    }
    public void addSecondFragment(View view){

        MySecondFragment mySecondFragment = new MySecondFragment();


        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.add(R.id.container,mySecondFragment,"mySecondFragment");

        fragmentTransaction.commit();

    }

    public void removeMyFragment(View view){

       MyFragment myFragment = (MyFragment)fragmentManager.findFragmentByTag("myFragment") ;
       if(myFragment != null){
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.remove(myFragment);
            fragmentTransaction.commit();
       }else{
           Toast.makeText(this,"MyFragment not found",Toast.LENGTH_SHORT).show();
       }
    }

    public void removeSecondFragment(View view){
        MySecondFragment mySecondFragment = (MySecondFragment) fragmentManager.findFragmentByTag("mySecondFragment") ;

        if(mySecondFragment != null) {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.remove(mySecondFragment);
            fragmentTransaction.commit();
        }else{
            Toast.makeText(this,"MySecondFragment not found",Toast.LENGTH_SHORT).show();
        }
    }

    public void replaceMyFragment(View view){
        MySecondFragment fragment = new MySecondFragment();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container,fragment,"mySecondFragment");
        fragmentTransaction.commit();
    }

    public void replaceSecondFragment(View view){


    }

    public void changeTextInFragment(View view){
        MyFragment fragment = (MyFragment) fragmentManager.findFragmentByTag("myFragment");
        if(fragment != null){
            fragment.setTextInTextView("Text changed in MyFragment");
        }
    }

}
