package com.example.yesmine.myapplication.UI;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.yesmine.myapplication.Adapter.ProductAdapter;
import com.example.yesmine.myapplication.Model.Assurance;
import com.example.yesmine.myapplication.Model.Produit;
import com.example.yesmine.myapplication.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ProductListActivity extends AppCompatActivity {

    List<Produit> listOfdataAdapter;

    RecyclerView recyclerView;

    String HTTP_JSON_URL = "http://192.168.1.104:18080/GCA-web/api/products";

    String Product_Title_JSON = "title";
    String Product_Insurence_JSON = "insurance";
    String Product_Text_JSON = "text";
    String Product_Rate_JSON = "rate";
    String Product_Image_JSON = "img";

    String Insurence_Name_JSON = "nameInsurance";
    String Insurence_Phone_JSON = "phone";
    String Insurence_Mail_JSON = "mail";
    String Insurence_Rate_JSON = "rate";

    ProductAdapter productAdapter;
    JsonArrayRequest RequestOfJSonArray ;
    RequestQueue requestQueue ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_activity);

        listOfdataAdapter = new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.product_list);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManagerOfrecyclerView = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManagerOfrecyclerView);
        JSON_HTTP_CALL();
    }

    public void JSON_HTTP_CALL() {

        RequestOfJSonArray = new JsonArrayRequest(HTTP_JSON_URL,

                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        ParseJSonResponse(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Context context = getApplicationContext();
                        CharSequence text = "Hello toast! "+error.getMessage();
                        int duration = Toast.LENGTH_SHORT;

                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                    }
                });

        requestQueue = Volley.newRequestQueue(ProductListActivity.this);

        requestQueue.add(RequestOfJSonArray);
    }

    public void ParseJSonResponse(JSONArray array) {

        for (int i = 0; i < array.length(); i++) {

            Produit produit = new Produit();
            Assurance assurance = new Assurance();

            JSONObject PRODUCT = null;
            JSONObject INSURENCE = null;
            try {
                PRODUCT = array.getJSONObject(i);
                INSURENCE = PRODUCT.getJSONObject(Product_Insurence_JSON);

                //get assurence from JSON
                assurance.setName(INSURENCE.getString(Insurence_Name_JSON));
                assurance.setEmail(INSURENCE.getString(Insurence_Mail_JSON));
                assurance.setPhone(INSURENCE.getInt(Insurence_Phone_JSON));
                assurance.setRate(INSURENCE.getInt(Insurence_Rate_JSON));

                Log.e("testtt",assurance.getPhone()+"");
                //get product from JSON
                produit.setTitle(PRODUCT.getString(Product_Title_JSON));
                produit.setImage(PRODUCT.getString(Product_Image_JSON));
                produit.setText(PRODUCT.getString(Product_Text_JSON));
                produit.setRate(PRODUCT.getInt(Product_Rate_JSON));

                produit.setAssurance(assurance);
            } catch (JSONException e) {

                e.printStackTrace();
            }
            listOfdataAdapter.add(produit);
        }

        productAdapter = new ProductAdapter(listOfdataAdapter,this);
        recyclerView.setAdapter(productAdapter);
    }
}
