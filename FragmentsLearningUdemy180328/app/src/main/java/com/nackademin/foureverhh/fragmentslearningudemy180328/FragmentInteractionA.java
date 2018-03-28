package com.nackademin.foureverhh.fragmentslearningudemy180328;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class FragmentInteractionA extends Fragment implements View.OnClickListener{

    Button button;
    int counter = 0;
    Communicator communicator;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //null means  just begin to use the app,otherwise it means there are old values
        if(savedInstanceState == null){
            counter = 0;
        }else{
            //To get the value passed by outState in onSaveInstanceState
            counter = savedInstanceState.getInt("counter",0);
            //The default value works when key could not be found.
        }
    }

    @Nullable/**/
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_interaction_a,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        button = getActivity().findViewById(R.id.btn_click_me);
        button.setOnClickListener(this);
        communicator = (Communicator)getActivity(); //The instance of interface Communicator
    }


    //outState will pass value to onCreate()
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("counter",counter);
    }

    @Override
    public void onClick(View v) {
        counter++;
        communicator.respond("The button was clicked "+counter+" times.");
    }
}
