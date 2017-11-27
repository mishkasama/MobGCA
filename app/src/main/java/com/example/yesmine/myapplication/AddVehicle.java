package com.example.asus.sinistermanagment;


import android.app.DatePickerDialog;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.asus.sinistermanagment.Entites.Demande;

import org.json.JSONObject;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
public class AddVehicle extends AppCompatActivity {
    EditText omat,nmat,omark,color,hp,model,nmark;

    Button add;
    String url = "http://10.0.2.2:18080/JEEPI-web/pi/demandes/demandeVehicle";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout_vehicle);

        omat = (EditText) findViewById(R.id.etoldMAt);
        nmat = (EditText) findViewById(R.id.etNewMat);
        omark = (EditText) findViewById(R.id.etoldMark);
        nmark = (EditText) findViewById(R.id.aaetNewMark);

        color = (EditText) findViewById(R.id.etColor);
        hp = (EditText) findViewById(R.id.etHorsp);
        model = (EditText) findViewById(R.id.etModel);





        add = (Button) findViewById(R.id.btnVdemande);



        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Date datesys = new Date();
               long x =  datesys.getTime();
                String date = Long.toString(x);

                System.out.println( "**************"+date);
                Map<String, String> map = new HashMap<String, String>();
                map.put("oldMatriculation",  omat.getText().toString().trim());
                map.put("newMatriculation",  nmat.getText().toString().trim());
                map.put("oldMark", omark.getText().toString().trim());
                map.put("newMark", nmark.getText().toString().trim());
                map.put("color", color.getText().toString().trim());
                map.put("horsePower", hp.getText().toString().trim());
                map.put("type","update matriculation");
                map.put("etat","wating");
                map.put("date",date);
                map.put("user_id","2");

                JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, url,new JSONObject(map), new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();

                        Toast.makeText(AddVehicle.this,"Demande  added  successfully ", Toast.LENGTH_LONG).show();

                        Intent i = new Intent(AddVehicle.this, DemandeActivity.class);
                        startActivity(i);
                       // Context context = getApplicationContext();
                       // CharSequence text = error.getMessage();
                       // int duration = Toast.LENGTH_SHORT;

                       // Toast toast = Toast.makeText(context, text, duration);
                        //toast.show();
                    }
                }){
                    @Override
                    public Map<String, String> getHeaders() throws AuthFailureError {
                        HashMap<String, String> headers = new HashMap<String, String>();
                        headers.put("Content-Type", "application/json");

                        return headers;
                    }
                }

                        ;



                RequestQueue queue = Volley.newRequestQueue(AddVehicle.this);
                queue.add(request);


            }
        });


    }

}