package com.example.yekkenyosr.pi.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.yekkenyosr.pi.Entites.User;
import com.example.yekkenyosr.pi.LoginActivity;
import com.example.yekkenyosr.pi.R;

/**
 * Created by Yekken Yosr on 27/11/2017.
 */

public class ProfilFragment extends Fragment implements View.OnClickListener {
    TextView tvmail;
    TextView tvusername;
    TextView tvaddress;
    TextView tvphone;
    TextView tvdate;
    Button logoutButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (inflater == null) {
            inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        View view = inflater.inflate(R.layout.profil_fragment, null);
        logoutButton = view.findViewById(R.id.logout);
        tvmail=view.findViewById(R.id.tvmail);
        tvusername=view.findViewById(R.id.tvusername);
        tvaddress=view.findViewById(R.id.tvaddress);
        tvphone=view.findViewById(R.id.tvphone);
        tvdate=view.findViewById(R.id.tvdate);
        logoutButton.setOnClickListener(this);

        tvmail.setText(User.CurrentEmail);
        tvaddress.setText(User.CurrentAdress);
        tvdate.setText(User.CurrentBirthdayDate.toString());
        tvphone.setText(User.CurrentPhone);
        tvusername.setText(User.CurrentName);



        return view;
    }

    @Override
    public void onClick(View view) {
        System.out.println("clicked");
        if (view.getId() == R.id.logout)
        {

            Intent intent = new Intent(getActivity(), LoginActivity.class);
            startActivity(intent);
        }
    }
}
