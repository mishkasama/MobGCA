package com.example.asus.sinistermanagment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.asus.sinistermanagment.Adapter.invalideAdapter;
import com.example.asus.sinistermanagment.Adapter.validAdapter;
import com.example.asus.sinistermanagment.Entites.Demande;
import com.example.asus.sinistermanagment.Utils.MySingleton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public class InvalideDemandeActivity extends AppCompatActivity {

    public  static List<Demande> lst_demande=new CopyOnWriteArrayList<Demande>();

    private ListView listView;
    Button delete;
    invalideAdapter adapter;
    static String id;


    String json_url="http://10.0.2.2:18080/JEEPI-web/pi/demandes/invalidedemandes/2";
    String deleteurl="http://10.0.2.2:18080/JEEPI-web/pi/demandes/DeleteDemande/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invalide_demande);
        viewDemande();

    }

    public void viewDemande()
    {


        listView = (ListView) findViewById(R.id.list_invalid);


        JsonArrayRequest jar = new JsonArrayRequest(json_url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        for (int i = 0; i < response.length(); i++) {
                            try {

                                JSONObject jsonObject=response.getJSONObject(i);
                                System.out.println("----------------------"+ jsonObject);
                                Demande c =new Demande();
                                 id = jsonObject.getString("id");
                                // c.setType(jsonObject.getString("type"));
                                c.setColor(jsonObject.getString("color"));
                                c.setNewMark(jsonObject.getString("newMark"));
                                c.setOldMark(jsonObject.getString("oldMark"));
                                c.setHorsePower(jsonObject.getString("horsePower"));
                                c.setOldMatriculation(jsonObject.getString("oldMatriculation"));
                                c.setNewMatriculation(jsonObject.getString("newMatriculation"));
                                lst_demande.add(c);



                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }


                        adapter.notifyDataSetChanged();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(MainActivity.class.getSimpleName() , "Error: " + error.getMessage());
                //  hidePDialog();
            }
        });


        MySingleton.getIns(this).addToRequ(jar);
        adapter = new invalideAdapter(this, lst_demande);
        listView.setAdapter(adapter);
        listView.setLongClickable(true);

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            public boolean onItemLongClick(AdapterView<?> arg0, View v,
                                           int index, long arg3) {

               // Toast.makeText(InvalideDemandeActivity.this,listView.getItemAtPosition(index).toString(), Toast.LENGTH_LONG).show();
                Volleydeletefunc();
                Toast.makeText(InvalideDemandeActivity.this,"Demande  deleted successfully ", Toast.LENGTH_LONG).show();
                Intent i = new Intent(InvalideDemandeActivity.this,MainActivity.class);
                startActivity(i);

                return false;
            }
        });



    }


    public void Volleydeletefunc(){

        JSONObject j=new JSONObject();
        try {
            j.put("name","anything");
        } catch (JSONException e) {

            e.printStackTrace();
        }
        StringRequest js=new StringRequest(Request.Method.DELETE, deleteurl+id, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                /*Toast.makeText(DetailActivity.this, response, Toast.LENGTH_SHORT).show();
                Intent i=new Intent(DetailActivity.this,GetTask.class);
                startActivity(i);*/

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> map=new HashMap<String,String>();
                map.put("Content-type","application/json; charset=utf-8");
                return map;
            }
        };
        RequestQueue requestQueue= Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(js);

    }


}
