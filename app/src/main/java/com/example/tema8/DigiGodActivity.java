package com.example.tema8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class DigiGodActivity extends AppCompatActivity {

    TextView txtDigiId = findViewById(R.id.digi_id_new);
    TextView txtDigiName= findViewById(R.id.digi_name_new);
    TextView txtDigiLevel = findViewById(R.id.digi_level_new);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_digi_god);

        Button send_bt = findViewById(R.id.save_digimon_bt);
        Button search_bt = findViewById(R.id.search_activity_bt);

        send_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EscribeApi();
            }
        });

        search_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DigiGodActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void EscribeApi(){
        String url = "https://jsonplaceholder.typicode.com/posts/1";

        StringRequest getRequest = new StringRequest(Request.Method.GET, url, response -> {
            try {
                JSONObject jsonObject = new JSONObject();
                txtDigiId.setText(jsonObject.getString("id"));
                txtDigiName.setText(jsonObject.getString("title"));
                txtDigiLevel.setText(jsonObject.getString("body"));

                Toast.makeText(DigiGodActivity.this, "Digimon "+jsonObject.getString("id")+" Guardado", Toast.LENGTH_SHORT).show();

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }, error -> Toast.makeText(DigiGodActivity.this, "Digimon no registrado",
                Toast.LENGTH_SHORT).show())
        {
            protected Map<String, String> getParams(){
                Map<String, String> params = new HashMap<>();
                params.put("id", txtDigiId.getText().toString());
                params.put("title", txtDigiName.getText().toString());
                params.put("body", txtDigiLevel.getText().toString());
                return params;
            }
        };

        Volley.newRequestQueue(this).add(getRequest);
    }
}
