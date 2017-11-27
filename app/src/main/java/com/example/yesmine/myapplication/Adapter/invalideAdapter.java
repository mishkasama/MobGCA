package com.example.asus.sinistermanagment.Adapter;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.asus.sinistermanagment.Entites.Demande;
import com.example.asus.sinistermanagment.R;

import java.util.List;

/**
 * Created by asus on 24/11/2017.
 */

public class invalideAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Demande> categItems;
    Demande d;
    String deleteurl="http://10.0.2.2:18080/JEEPI-web/pi/demandes/DeleteDemande";

    public invalideAdapter(Activity activity, List<Demande> categItems) {
        this.activity = activity;
        this.categItems = categItems;
    }
    @Override
    public int getCount() {
        return categItems.size();
    }

    @Override
    public Object getItem(int location) {
        return categItems.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.invalid, null);


        TextView color = (TextView) convertView.findViewById(R.id.ivtxtcolor);
        TextView newmark = (TextView) convertView.findViewById(R.id.ivtxtnmark);
        TextView oldmark = (TextView) convertView.findViewById(R.id.ivtxtomark);
        TextView horsepower = (TextView) convertView.findViewById(R.id.ivtxthp);
        TextView oldmatriculation = (TextView) convertView.findViewById(R.id.ivtxtoldmat);
        TextView newmat = (TextView) convertView.findViewById(R.id.ivtxtnewmat);

       // Button btnAction = (Button)  convertView.findViewById(R.id.invalidDelete);




        d= categItems.get(position);




        color.setText(d.getColor());
        newmark.setText(d.getNewMark());
        oldmark.setText(d.getOldMark());
        horsepower.setText(d.getHorsePower());
        oldmatriculation.setText(d.getOldMatriculation());
        newmat.setText(d.getNewMatriculation());


        return convertView;
    }


}
