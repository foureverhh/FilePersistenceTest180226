package com.nackademin.foureverhh.parsejsonbyvolley180509;

import android.app.VoiceInteractor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SetUpARequestQueue extends AppCompatActivity {

    Button parse ;
    TextView textView;
    String url = "https://api.myjson.com/bins/1bza3m";
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_up_arequest_queue);

        parse = findViewById(R.id.btn_parse);
        textView = findViewById(R.id.text_view_result_setUp);

        //config and start a requestQueue
        Cache cache = new DiskBasedCache(getCacheDir(), 1024*1024);
        Network network = new BasicNetwork(new HurlStack());
        requestQueue = new RequestQueue(cache,network);
        requestQueue.start();

        parse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,url,
                        null,
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
                                    requestQueue.stop();
                                }
                                } catch (JSONException e) {

                                e.printStackTrace();
                                }
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                textView.setText("Error .....");
                                requestQueue.stop();
                            }

                });
                requestQueue.add(jsonObjectRequest);
            }
                /*StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                textView.setText(response);
                                requestQueue.stop();
                            }
                        },
                        new Response.ErrorListener() {
                             @Override
                             public void onErrorResponse(VolleyError error) {
                                textView.setText("Error....");
                                error.printStackTrace();
                             }
                        });
                requestQueue.add(stringRequest);
            }*/
        });
    }
}
