package com.example.tema8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;


import org.json.JSONArray;
import org.json.JSONException;

public class MainActivity extends AppCompatActivity {

    public EditText txtDigiName;
    public TextView txtDigiLevel;
    public ImageView digi_icon;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtDigiName = (EditText) findViewById(R.id.digiName);
        txtDigiLevel = (TextView) findViewById(R.id.digi_level);
        digi_icon = (ImageView) findViewById(R.id.digi_image);

        digi_icon.setVisibility(View.INVISIBLE);

        Button save_bt = findViewById(R.id.send_bt);
        save_bt.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                String name = txtDigiName.getText().toString();
                LeerApi(name);
            }
        });

        Button god_mode_bt = findViewById(R.id.create_bt);
        god_mode_bt.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DigiGodActivity.class);
                startActivity(intent);
            }
        });
    }


    private void LeerApi(String name){
        String url = "https://digimon-api.vercel.app/api/digimon/name/"+name;
        
        StringRequest getRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray jsonObject = new JSONArray(response);

                    txtDigiLevel.setText(jsonObject.getJSONObject(0).getString("level")   );
                    String img_url = jsonObject.getJSONObject(0).getString("img");

                    Picasso.with(MainActivity.this).load(img_url).into(digi_icon);
                    digi_icon.setVisibility(View.VISIBLE);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, error -> Toast.makeText(MainActivity.this, "Digimon no encontrado, compruebe los datos",
                Toast.LENGTH_SHORT).show());

        Volley.newRequestQueue(this).add(getRequest);
    }
}
