package com.example.tema8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class DigiGodActivity extends AppCompatActivity {

    public EditText txtDigiId;
    public EditText txtDigiName;
    public EditText txtDigiLevel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_digi_god);

        txtDigiId = findViewById(R.id.digi_id_new);
        txtDigiName = findViewById(R.id.digi_name_new);
        txtDigiLevel = findViewById(R.id.digi_level_new);

        Button send_bt = findViewById(R.id.save_digimon_bt);
        Button search_bt = findViewById(R.id.search_activity_bt);

        send_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveDigimon(txtDigiId, txtDigiName, txtDigiLevel);
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

    private void saveDigimon(EditText id, EditText title, EditText body) {
        String url = "https://jsonplaceholder.typicode.com/posts";

        Map<String, String> params = new HashMap<>();
        params.put("id", id.getText().toString());
        params.put("title", title.getText().toString());
        params.put("body", body.getText().toString());

        JsonObjectRequest jsonRequest = new JsonObjectRequest(Request.Method.POST, url, new JSONObject(params), new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Toast.makeText(DigiGodActivity.this, "Digimon Guardado", Toast.LENGTH_SHORT).show();
                Toast.makeText(DigiGodActivity.this, response.toString(), Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(DigiGodActivity.this, "No se ha registrado el Digimon", Toast.LENGTH_SHORT).show();
            }
        }
        );

        Volley.newRequestQueue(this).add(jsonRequest);
    }
}