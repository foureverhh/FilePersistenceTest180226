package com.nackademin.foureverhh.fragmentmodularlearning180329;

import android.app.Activity;
import android.app.Fragment;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ResourceCursorAdapter;
import android.widget.TextView;

public class FragmentB extends Fragment{

    TextView text;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
         return inflater.inflate(R.layout.fragment_b,container,false);

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        text = getActivity().findViewById(R.id.textView);
    }

    public void changeData(int i){
        Resources res = getResources();
        String[] descriptions= res.getStringArray(R.array.descriptions);
        Log.d("Index is ",String.valueOf(i));
        text.setText(descriptions[i]);
    }
}

