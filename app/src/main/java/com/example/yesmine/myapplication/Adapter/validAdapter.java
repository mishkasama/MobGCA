package com.example.asus.sinistermanagment.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.asus.sinistermanagment.Entites.Demande;
import com.example.asus.sinistermanagment.R;

import java.util.List;

/**
 * Created by asus on 24/11/2017.
 */

public class validAdapter extends BaseAdapter {

    private Activity activity;
    private LayoutInflater inflater;
    private List<Demande> categItems;
    Demande c;

    public validAdapter(Activity activity, List<Demande> categItems) {
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
            convertView = inflater.inflate(R.layout.valid, null);



        TextView color = (TextView) convertView.findViewById(R.id.vtxtcolor);
        TextView newmark = (TextView) convertView.findViewById(R.id.vtxtnmark);
        TextView oldmark = (TextView) convertView.findViewById(R.id.vtxtomark);
        TextView horsepower = (TextView) convertView.findViewById(R.id.vtxthp);
        TextView oldmatriculation = (TextView) convertView.findViewById(R.id.vtxtoldmat);
        TextView newmat = (TextView) convertView.findViewById(R.id.vtxtnewmat);




        c = categItems.get(position);




        color.setText(c.getColor());
        newmark.setText(c.getNewMark());
        oldmark.setText(c.getOldMark());
        horsepower.setText(c.getHorsePower());
        oldmatriculation.setText(c.getOldMatriculation());
        newmat.setText(c.getNewMatriculation());


        return convertView;
    }
}
