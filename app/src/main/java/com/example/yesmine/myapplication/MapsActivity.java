package com.example.fakhr.insurancee;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
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
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    String json_url="http://10.0.2.2:18080/insurance-web/rest/insurance/getAll";

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;
        String at = InssuranceAdapter.insurance.getLaltitude() ;
        String lag = InssuranceAdapter.insurance.getLongitude() ;
        double lat = Double.valueOf(at) ;
        double lng = Double.valueOf(lag) ;

        Toast.makeText(MapsActivity.this,"lat"+lat+" lng"+lng,Toast.LENGTH_SHORT).show();
        // Add a marker in Sydney and move the camera

        // Add a marker in Sydney and move the camera
       LatLng marker= new LatLng(Double.valueOf(at),Double.valueOf(lag));
        //LatLng marker = new LatLng(lat  , lng);
        mMap.addMarker(new MarkerOptions().position(marker).title("Here your distination"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(marker,8));
}}
