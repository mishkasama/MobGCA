package com.example.fakhr.insurancee;

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
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

import static android.R.attr.password;
import static android.provider.ContactsContract.CommonDataKinds.Website.URL;

public class AddReclamationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_reclamation);
        final EditText titre=(EditText) findViewById(R.id.editText);
        final EditText description=(EditText) findViewById(R.id.editText2);
        Button ajouter=(Button)findViewById(R.id.btnadd);
        final String URL = "http://10.0.2.2:18080/insurance-web/rest/reclamation";

        ajouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringRequest request = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>(){
                    @Override
                    public void onResponse(String s) {
                        if(s.equals("true")){
                            Toast.makeText(AddReclamationActivity.this, "Add Reclamation Successful", Toast.LENGTH_LONG).show();
                        }
                        else{
                            Toast.makeText(AddReclamationActivity.this, "Can't Add Reclamation", Toast.LENGTH_LONG).show();
                        }
                    }
                },new Response.ErrorListener(){
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        Toast.makeText(AddReclamationActivity.this, "Some error occurred -> "+volleyError, Toast.LENGTH_LONG).show();;
                    }
                }) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> parameters = new HashMap<String, String>();
                        parameters.put("titre", titre.getText().toString());
                        parameters.put("description",description.getText().toString());

                        return parameters;
                    }
                };

                RequestQueue rQueue = Volley.newRequestQueue(AddReclamationActivity.this);
                rQueue.add(request);
            }
        });


    }
    }

