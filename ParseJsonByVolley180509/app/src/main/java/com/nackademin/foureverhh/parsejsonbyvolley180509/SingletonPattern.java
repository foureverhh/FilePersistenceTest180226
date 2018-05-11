package com.nackademin.foureverhh.parsejsonbyvolley180509;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SingletonPattern extends AppCompatActivity {

    TextView textView;
    Button btn;
    String url = "https://api.myjson.com/bins/1bza3m";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singleton_pattern);

        textView = findViewById(R.id.text_view_result_singleton);
        btn = findViewById(R.id.btn_parse_singleton);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,url,null,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                try {
                                    JSONArray jsonArray = response.getJSONArray("employees");
                                    for(int i = 0; i<jsonArray.length();i++){
                                        JSONObject employee = (JSONObject) jsonArray.get(i);
                                        String firstName = employee.getString("first name");
                                        int age = employee.getInt("age");
                                        String mail = employee.getString("mail");
                                        textView.append(firstName + ", " +
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
                                textView.setText("Error happened....");
                                error.printStackTrace();
                            }
                        });

                //MySingleton mySingleton = new MySingleton.getInstance(getApplicationContext());
                //Add the request to the requestQueue singleton pattern
                MySingleton.getInstance(getApplicationContext()).addToRequestQueue(jsonObjectRequest);
            }
        });

    }
}
