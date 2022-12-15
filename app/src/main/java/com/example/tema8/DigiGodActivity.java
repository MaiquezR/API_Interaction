package com.example.tema8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

public class DigiGodActivity extends AppCompatActivity {
/*
    TextView txtDigiName = findViewById(R.id.digi_name_search);
    TextView txtDigiLevel = findViewById(R.id.digi_name_search);
    TextView txtDigiStory = findViewById(R.id.digi_name_search);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_digi_god);
    }

    private void EscribeApi(){
        String url = "https://jsonplaceholder.typicode.com/posts/1";

        StringRequest getRequest = new StringRequest(Request.Method.GET, url, response -> {
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
        }, error -> Log.e("Error", error.getMessage()))
        {
            protected Map<String, String> getParams(){
                Map<String, String> params = new HashMap<>();
                params.put("digimon", txtDigiName);
                params.put("level", txtDigiLevel);
                params.put("story", txtDigiStory);
                return params;
            }
        };
    }*/
}