package com.nackademin.foureverhh.fragmenttransaction126_180330;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getFragmentManager();
    }

    public void addA(View view){
        FragmentA f1 = new FragmentA();
        FragmentTransaction transaction =fragmentManager.beginTransaction();
        transaction.add(R.id.group,f1,"A");
        transaction.commit();
    }

    public void addB(View view){
        FragmentB f2 = new FragmentB();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.group,f2,"B");
        transaction.commit();
    }

    public void removeA(View view){
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        FragmentA f1 = (FragmentA) fragmentManager.findFragmentByTag("A");
        if(f1 != null) {
            transaction.remove(f1);
            transaction.commit();
        }else{
            Toast.makeText(this,"Fragment A was not loaded before",Toast.LENGTH_SHORT).show();
        }

    }

    public void removeB(View view){
        FragmentManager fragmentManager = getFragmentManager();
        FragmentB f2 = (FragmentB)fragmentManager.findFragmentByTag("B");
        if(f2 != null){
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.remove(f2);
            transaction.commit();
        }else{
            Toast.makeText(this,"Fragment B is not added yet",Toast.LENGTH_SHORT).show();
        }

    }

    public void replaceAWithB(View view){
        FragmentB f2 = new FragmentB();
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.group,f2,"B");
        transaction.commit();
    }

    public void replaceBWithA(View view){
        FragmentA f1 = new FragmentA();
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.group,f1,"A");
        transaction.commit();
    }

    public void attachA(View view){
        FragmentManager manager =getFragmentManager();
        FragmentA f1 = (FragmentA)manager.findFragmentByTag("A");
        FragmentTransaction transaction = manager.beginTransaction();
        if(f1 != null){
            transaction.attach(f1);
            transaction.commit();
        }else{
            Toast.makeText(this,"Fragment A is not still there",Toast.LENGTH_SHORT).show();
        }

    }

    public void detachA(View view){
        FragmentManager manager =getFragmentManager();
        FragmentA f1 = (FragmentA)manager.findFragmentByTag("A");
        FragmentTransaction transaction = manager.beginTransaction();
        if(f1 != null){
            transaction.detach(f1);
            transaction.commit();
        }else{
            Toast.makeText(this,"Fragment A is not added",Toast.LENGTH_SHORT).show();
        }
    }
}
