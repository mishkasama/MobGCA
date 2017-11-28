package com.example.fakhr.insurancee;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.fakhr.insurancee.Adapter.InssuranceAdapter;
import com.example.fakhr.insurancee.Entites.Address;
import com.example.fakhr.insurancee.Entites.Insurance;
import com.example.fakhr.insurancee.Utils.MySingleton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class getallInsuranceActivity extends AppCompatActivity {

    public  static List<Insurance> lst_Category=new CopyOnWriteArrayList<Insurance>();
    public  static List<Address> lst_address=new CopyOnWriteArrayList<Address>();


    private ListView listView;
    InssuranceAdapter adapter;

    String json_url="http://10.0.2.2:18080/insurance-web/rest/insurance/getAll";
String laltitude="";
    String longitude="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getall_insurance);

        System.out.println( "***************************************************");
        viewDemande();
    }
    public void viewDemande()
    {
        System.out.println( "-----***************************************************");


        listView = (ListView) findViewById(R.id.list_inssurance);


        JsonArrayRequest jar = new JsonArrayRequest(json_url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        for (int i = 0; i < response.length(); i++) {
                            try {
                                laltitude="";
                                longitude="";
                                JSONObject jsonObject=response.getJSONObject(i);

                                System.out.println("----------------------"+ jsonObject);
                                Insurance c =new Insurance();
                                c.setNameInsurance(jsonObject.getString("nameInsurance"));
                                c.setMail(jsonObject.getString("mail"));
                                c.setDescription(jsonObject.getString("description"));
                                c.setPhone(jsonObject.getString("phone"));
                                //TODO foreign Key

                                if (!jsonObject.getString("adresse").equals("null")) {
                                    JSONObject obj = jsonObject.getJSONObject("adresse");
                                    // System.out.println(jsonObject.getString("localisation"));
                                    laltitude = obj.getString("laltitude");
                                    longitude = obj.getString("longitude");
                                    Toast.makeText(
                                            getallInsuranceActivity.this,laltitude,Toast.LENGTH_SHORT).show();

                                    c.setLaltitude(laltitude);
                                    c.setLongitude(longitude);
                                    System.out.println("lag " + laltitude + " at " + longitude);
                                   Log.d("maaaaaaaap","lag " + laltitude + " at " + longitude);

                                }
                                else
                                {
                                    c.setLaltitude("");
                                    c.setLongitude("");
                                }




                                lst_Category.add(c);


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
        adapter = new InssuranceAdapter(this, lst_Category);
        listView.setAdapter(adapter);


    }

}
