package com.nackademin.foureverhh.fragmentslearningudemy180328;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentInteractionB extends Fragment {



    String data;
    TextView text;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        //return inflater.inflate(R.layout.fragment_interaction_b,container,false);
        View view = inflater.inflate(R.layout.fragment_interaction_b,container,false);
        if(savedInstanceState == null){

        }else{
            data = savedInstanceState.getString("textView");
            TextView myText = (TextView) view.findViewById(R.id.textView);
            myText.setText(data);
        }
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        text = getActivity().findViewById(R.id.textView);
    }
    public void textChange(String newText){
        this.data = newText;
        text.setText(newText);

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //Before onDestroy pass the text of textView to outState
        outState.putString("textView",data);
    }
}
