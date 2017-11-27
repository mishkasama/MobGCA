package com.example.asus.sinistermanagment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {
Button btn,valide,invalide,addvehicle,addmatricule,sendMail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button)findViewById(R.id.btnlist);
        valide = (Button)findViewById(R.id.btnvalide);
        invalide = (Button)findViewById(R.id.btninvalide);
        addvehicle = (Button)findViewById(R.id.addvehicle);
        addmatricule = (Button)findViewById(R.id.addmatricule);
        sendMail = (Button)findViewById(R.id.SendEmail);



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent mIntent = new Intent(MainActivity.this, DemandeActivity.class);
                startActivity(mIntent);

            }
        });

        valide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent mIntent = new Intent(MainActivity.this, ValidDemandesActivity.class);
                startActivity(mIntent);

            }
        });

        invalide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent mIntent = new Intent(MainActivity.this, InvalideDemandeActivity.class);
                startActivity(mIntent);

            }
        });

        addvehicle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent mIntent = new Intent(MainActivity.this, AddVehicle.class);
                startActivity(mIntent);

            }
        });


        addmatricule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(MainActivity.this, AddatriculeActivity.class);
                startActivity(mIntent);
            }
        });

        sendMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(MainActivity.this, SendMailActivity.class);
                startActivity(mIntent);
            }
        });


    }



}
