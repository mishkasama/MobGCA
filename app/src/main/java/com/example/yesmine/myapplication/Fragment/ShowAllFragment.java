package com.example.yekkenyosr.pi.Fragment;

import android.animation.LayoutTransition;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.example.yekkenyosr.pi.Adapter.MyAdapter;
import com.example.yekkenyosr.pi.App;
import com.example.yekkenyosr.pi.Entites.User;
import com.example.yekkenyosr.pi.Entites.Vehicule;
import com.example.yekkenyosr.pi.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yekken Yosr on 26/11/2017.
 */

public class ShowAllFragment extends Fragment {
    RecyclerView recyclerView;
    List<Vehicule> list;
    MyAdapter adapter;
    ConstraintLayout Constraint;
    android.widget.FrameLayout.LayoutParams collapsed;
    android.widget.FrameLayout.LayoutParams expanded;
    Button editText;
    LinearLayout cardView;
    boolean isCollapsed = true;
    EditText etMatriculation;
    EditText etMark;
    EditText etModel;
    EditText etColor;
    EditText etNumChassi;
    EditText etHorsePower;
    Button bAjouteVeicule;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (inflater == null) {
            inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        View view = inflater.inflate(R.layout.home_insurance_fragment,null,true);
        etMatriculation = view.findViewById(R.id.etMatriculation);
        etMark = view.findViewById(R.id.etMark);
        etModel = view.findViewById(R.id.etModel);
        etColor = view.findViewById(R.id.etColor);
        etNumChassi = view.findViewById(R.id.etNumChassi);
        etHorsePower = view.findViewById(R.id.etHorsePower);

        bAjouteVeicule = view.findViewById(R.id.bAjouteVeicule);
        bAjouteVeicule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    JSONObject vehicule = new JSONObject();
                    vehicule.put("numChassis", etNumChassi.getText());
                    vehicule.put("matriculation", etMatriculation.getText());
                    vehicule.put("color", etColor.getText());
                    vehicule.put("horsePower", etHorsePower.getText());
                    vehicule.put("model", etModel.getText());
                    vehicule.put("mark", etMark.getText());
                    vehicule.put("id", User.CurrentId);
                    JsonObjectRequest jsonObj = new JsonObjectRequest(Request.Method.POST,
                            "http://10.0.2.2:18080/JEEPI-web/rest/vehicle/AddVehicle", vehicule, null, null
                    );

                    App.getInstance().addToRequestQueue(jsonObj);

                    System.out.println("success");
                    Toast.makeText(getActivity().getApplicationContext(),"ajouté avec succes",Toast.LENGTH_LONG).show();

                    Vehicule v = new Vehicule();
                    v.setMark(etMark.getText().toString());
                    v.setMatriculation(etMatriculation.getText().toString());
                    v.setColor(etColor.getText().toString());
                    v.setHorsePower(etHorsePower.getText().toString());
                    v.setModel(etModel.getText().toString());

                    cardView.setLayoutParams(collapsed);
                    isCollapsed = !isCollapsed;
                    view.setBackgroundColor(Color.parseColor("#40bf80"));
                    adapter.getList().add(v);
                    adapter.notifyDataSetChanged();
                    Integer x = Integer.parseInt(etNumChassi.getText().toString());
                    v.setNumChassis(x);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
        list = new ArrayList<>();
        recyclerView = view.findViewById(R.id.rv);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        getData();
        Constraint = view.findViewById(R.id.Constraint);
        LayoutTransition transition = Constraint.getLayoutTransition();
        transition.enableTransitionType(LayoutTransition.CHANGING);
        collapsed = new android.widget.FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0);
        expanded = new android.widget.FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        editText = view.findViewById(R.id.editText);
        cardView = view.findViewById(R.id.cardView);
        cardView.setLayoutParams(collapsed);
        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cardView.getHeight() < 50) {
                    cardView.setLayoutParams(expanded);
                    isCollapsed = !isCollapsed;
                    view.setBackgroundColor(Color.parseColor("#40bf80"));
                } else {
                    cardView.setLayoutParams(collapsed);//TODO change color
                    isCollapsed = !isCollapsed;
                    view.setBackgroundColor(Color.parseColor("#40bf80"));

                }
            }
        });
        return view;
    }

    public void getData() {

        JsonArrayRequest jsonObjReq = new JsonArrayRequest(Request.Method.GET,
                "http://10.0.2.2:18080/JEEPI-web/rest/vehicle/Find", null,
                new Response.Listener<JSONArray>() {

                    @Override
                    public void onResponse(JSONArray response) {
                        try {

                            for (int i = 0; i < response.length(); i++) {
                                JSONObject vehiculer = response.getJSONObject(i);
                                Vehicule v = new Vehicule();
                                v.setColor(vehiculer.getString("color"));
                                v.setHorsePower(vehiculer.getString("horsePower"));
                                v.setMark(vehiculer.getString("mark"));
                                v.setModel(vehiculer.getString("model"));
                                v.setMatriculation(vehiculer.getString("matriculation"));
                                v.setNumChassis(vehiculer.getInt("numChassis"));
                                if (vehiculer.getJSONObject("id").getInt("id")==User.CurrentId)//TODO get his onw vehicle
                                list.add(v);

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        adapter = new MyAdapter(getActivity(), list);
                        recyclerView.setAdapter(adapter);
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });


        App.getInstance().addToRequestQueue(jsonObjReq);
    }
}
