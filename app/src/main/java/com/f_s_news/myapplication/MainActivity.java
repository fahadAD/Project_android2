package com.f_s_news.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
ProgressBar progressBar;
TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar=findViewById(R.id.progressBar);
        textView=findViewById(R.id.textView);



       String urii="https://fahad71.000webhostapp.com/apps/complex.json";
        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.GET, urii, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
progressBar.setVisibility(View.GONE);

                Log.d("serverobject",response.toString());


                try {

                    String name=response.getString("name");
                    String age=response.getString("age");


                   textView.append(name);
                    textView.append("\n");
                    textView.append(age);

                } catch (JSONException e) {
                    e.printStackTrace();
                }




            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressBar.setVisibility(View.GONE);
            }
        });

RequestQueue requestQueue= Volley.newRequestQueue(MainActivity.this);
requestQueue.add(jsonObjectRequest);





    }
}