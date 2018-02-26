package com.nackademin.foureverhh.filepersistencetest180226;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.edit);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        String inputText = editText.getText().toString();
        save(inputText);
    }

    private void save(String inputText) {

        FileOutputStream out = null;
        BufferedWriter writer = null; //Use ButteredWriter to write something in a file

        try{
            //openFileOutput() will convey the FileOutputStream type object which named as out
            out = openFileOutput("data", Context.MODE_PRIVATE); //Name a file as data to keep the stream
            writer = new BufferedWriter(new OutputStreamWriter(out));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally{
            try{
                if(writer != null)
                    writer.close(); //close() to flush the stream
            }catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
