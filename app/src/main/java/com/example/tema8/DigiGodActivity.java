package com.example.tema8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class DigiGodActivity extends AppCompatActivity {

    TextView txtDigiName = findViewById(R.id.digi_txt);
    TextView txtDigiLevel = findViewById(R.id.digi_txt);
    TextView txtDigiStory = findViewById(R.id.digi_txt);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_digi_god);
    }

    private void EscribeApi(){
        String url = "https://jsonplaceholder.typicode.com/posts/1";

        StringRequest getRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject();
                    txtDigiName.setText(jsonObject.getString("digimon"));
                    txtDigiLevel.setText(jsonObject.getString("level"));
                    txtDigiStory.setText(jsonObject.getString("story"));

                    Toast.makeText(DigiGodActivity.this, "El id insertado "+
                            jsonObject.getString("id"), Toast.LENGTH_SHORT).show();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Error", error.getMessage());
            }
        })
        {
            protected Map<String, String> getParams(){
                Map<String, String> params = new HashMap<>();
                params.put("digimon", txtDigiName);
                params.put("level", txtDigiLevel);
                params.put("story", txtDigiStory);
                return params;
            }
        };
    }
}