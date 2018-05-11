package com.nackademin.foureverhh.parsejsonbyvolley180509;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private TextView mTextViewResult;
    private RequestQueue mQueue;
    Button parse,toSetup,toSingleton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextViewResult = findViewById(R.id.text_view_result);
        parse = findViewById(R.id.btn_parse);
        toSetup = findViewById(R.id.btn_toSetup);
        toSingleton = findViewById(R.id.btn_toSingleton);

        mQueue = Volley.newRequestQueue(this);
        parse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jsonParse();
            }
        });

        toSetup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toSetup = new Intent (MainActivity.this, SetUpARequestQueue.class);
                startActivity(toSetup);
            }
        });

        toSingleton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toSingleton = new Intent (MainActivity.this, SingletonPattern.class);
                startActivity(toSingleton);
            }
        });
    }

    private void jsonParse(){

        String url = "https://api.myjson.com/bins/1bza3m";
        final JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = response.getJSONArray("employees");
                    for(int i =0; i< jsonArray.length(); i++){
                        JSONObject employee = (JSONObject) jsonArray.get(i);
                        String firstName = employee.getString("first name");
                        int age = employee.getInt("age");
                        String mail = employee.getString("mail");
                        mTextViewResult.append(firstName + ", " +
                                String.valueOf(age) + ", " +
                                mail + "\n\n");
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        mQueue.add(request);
    }
}
