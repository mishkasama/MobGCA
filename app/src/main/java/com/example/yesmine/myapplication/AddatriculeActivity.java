package com.example.asus.sinistermanagment;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class AddatriculeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        final EditText omat,nmat,omark;
        Button add;
        final String url = "http://10.0.2.2:18080/JEEPI-web/pi/demandes/demandeMatricule";
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addatricule);

        omat = (EditText) findViewById(R.id.metomat);
        nmat = (EditText) findViewById(R.id.metNewMat);
        omark = (EditText) findViewById(R.id.metoldMark);
        add = (Button) findViewById(R.id.btnMdemande);

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
                        Context context = getApplicationContext();
                        CharSequence text = error.getMessage();
                        int duration = Toast.LENGTH_SHORT;

                        Toast.makeText(AddatriculeActivity.this,"Demande  added  successfully ", Toast.LENGTH_LONG).show();

                        Intent i = new Intent(AddatriculeActivity.this, DemandeActivity.class);
                        startActivity(i);


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



                RequestQueue queue = Volley.newRequestQueue(AddatriculeActivity.this);
                queue.add(request);


            }
        });





    }
}
