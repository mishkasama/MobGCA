package com.example.yekkenyosr.pi.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.yekkenyosr.pi.R;

/**
 * Created by Yekken Yosr on 26/11/2017.
 */

public class InscriptionFragment extends Fragment implements View.OnClickListener {
    EditText username;
    EditText password;
    Button bLogin;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (inflater == null) {
            inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        View view = inflater.inflate(R.layout.inscription_fragment, null);
        username = view.findViewById(R.id.etUserNameLogin);
        password = view.findViewById(R.id.etUserPasswordLogin);
        bLogin = view.findViewById(R.id.bSignUP);
        bLogin.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {

    }
}
