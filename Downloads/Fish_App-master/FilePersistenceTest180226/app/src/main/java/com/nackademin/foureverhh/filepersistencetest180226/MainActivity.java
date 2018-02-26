package com.nackademin.foureverhh.filepersistencetest180226;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.edit);

        String inputText = load();
        if(!TextUtils.isEmpty(inputText)){ //TextUtils ?????
            editText.setText(inputText);
            editText.setSelection(inputText.length());
            Toast.makeText(this,"Restore succeeded",Toast.LENGTH_SHORT).show();
        }

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

    private String load(){

        FileInputStream in = null;
        BufferedReader reader = null;
        StringBuilder content = new StringBuilder(); // ??

        try{
            in = openFileInput("data");
            reader = new BufferedReader(new InputStreamReader(in));
            String line = "";
            while ((line = reader.readLine())!=null)
            {
                content.append(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(reader!=null){
                try {
                    reader.close();  //Flushing
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return content.toString();
    }

}
