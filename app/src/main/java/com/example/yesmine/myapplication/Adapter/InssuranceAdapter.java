package com.example.fakhr.insurancee.Adapter;

/**
 * Created by fakhr on 27/11/2017.
 */




import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.example.fakhr.insurancee.Entites.Insurance;
import com.example.fakhr.insurancee.MapsActivity;
import com.example.fakhr.insurancee.R;

import java.util.List;

/**
 * Created by asus on 24/11/2017.
 */

public class InssuranceAdapter extends BaseAdapter {

    private Activity activity;
    private LayoutInflater inflater;
    private List<Insurance> categItems;
    public static Insurance insurance;
    Button btndetails;
    Insurance c;
    public InssuranceAdapter(Activity activity, List<Insurance> categItems) {
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
            convertView = inflater.inflate(R.layout.get_all_inssurance, null);


        TextView nom = (TextView) convertView.findViewById(R.id.txtnom);

        TextView description = (TextView) convertView.findViewById(R.id.txtdescription);
        TextView tel = (TextView) convertView.findViewById(R.id.txttel);
        TextView email = (TextView) convertView.findViewById(R.id.txtmail);
    Button btndetails=(Button) convertView.findViewById(R.id.btndetails);

        btndetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                insurance = c;
                System.out.println("haha"+insurance.getLaltitude());

                if(insurance.getLaltitude().equals(""))
                    Toast.makeText(activity, " This Action is emergicy , you can call the USER for more Information ", Toast.LENGTH_LONG).show();

                else {
                    Intent intent = new Intent(activity, MapsActivity.class);
                    activity.startActivity(intent);
                }

            }
        });
        c = categItems.get(position);



        nom.setText(c.getNameInsurance());
        description.setText(c.getDescription());
        tel.setText(c.getPhone());
        email.setText(c.getMail());



        return convertView;
    }
}
