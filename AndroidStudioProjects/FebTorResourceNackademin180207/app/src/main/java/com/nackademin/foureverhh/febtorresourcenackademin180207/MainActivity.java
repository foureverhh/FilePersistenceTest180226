package com.nackademin.foureverhh.febtorresourcenackademin180207;

import android.os.LocaleList;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

Button btn;
TextView txv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btn);
        txv = findViewById(R.id.text_view);

        //To show the current language
        //Locale current = getResources().getConfiguration().locale;
        //txv.setText(current.getDisplayLanguage());
    }

    public void click(View view)
    {
     txv.setText(getString(R.string.goodbye_world));

    }
}
