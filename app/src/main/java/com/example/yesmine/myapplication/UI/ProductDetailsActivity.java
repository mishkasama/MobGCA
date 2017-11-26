package com.example.yesmine.myapplication.UI;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Explode;
import android.util.Base64;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
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
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class ProductDetailsActivity extends Activity {

    // View name of the header image. Used for activity scene transitions
    public static final String VIEW_NAME_HEADER_IMAGE = "detail:header:image";

    // View name of the header title. Used for activity scene transitions
    public static final String VIEW_NAME_HEADER_TITLE = "detail:header:title";

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        getWindow().setEnterTransition(new Explode());
        setContentView(R.layout.product_details_activity);
        ImageView productImage = findViewById(R.id.productImageView);
        TextView productText = findViewById(R.id.productTextView);
        TextView productTitle = findViewById(R.id.productTitleView);
        RatingBar productRate = findViewById(R.id.productRatingBar);

        TextView insuranceName = findViewById(R.id.insuranceNameView);
        TextView insurancePhone = findViewById(R.id.insurancePhoneView);
        TextView insuranceMail = findViewById(R.id.insuranceMailView);

        Intent i = getIntent();
        Produit produit = (Produit)i.getSerializableExtra("produit");

        productTitle.setText(produit.getTitle());
        productText.setText(produit.getText());
        productRate.setRating((float)produit.getRate());

        insuranceName.setText(produit.getAssurance().getName());
        insurancePhone.setText(getString(R.string.phone)+produit.getAssurance().getPhone());
        insuranceMail.setText(produit.getAssurance().getEmail());

        byte[] decodedString = Base64.decode(produit.getImage(), Base64.DEFAULT);
        Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
        productImage.setImageBitmap(decodedByte);

    }

}
