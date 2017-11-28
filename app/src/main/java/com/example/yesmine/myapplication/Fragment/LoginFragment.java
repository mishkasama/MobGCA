package com.example.yekkenyosr.pi.Fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.yekkenyosr.pi.App;
import com.example.yekkenyosr.pi.Entites.User;
import com.example.yekkenyosr.pi.LoginActivity;
import com.example.yekkenyosr.pi.MainActivity;
import com.example.yekkenyosr.pi.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;

/**
 * Created by Yekken Yosr on 26/11/2017.
 */

public class LoginFragment extends Fragment implements View.OnClickListener {
    EditText username;
    EditText password;
    Button bLogin;
    TextView inscription;
    String url = "http://10.0.2.2:18080/JEEPI-web/rest/users/";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (inflater == null) {
            inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        View view = inflater.inflate(R.layout.login_fragment, null);
        username = view.findViewById(R.id.etUserNameLogin);
        password = view.findViewById(R.id.etUserPasswordLogin);
        bLogin = view.findViewById(R.id.bSignUP);
        inscription = view.findViewById(R.id.textView4);
        bLogin.setOnClickListener(this);
        inscription.setOnClickListener(this);
        return view;
    }
    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.textView4) {
            ((LoginActivity) getActivity()).CommitFragment(new InscriptionFragment());
        } else if (view.getId() == R.id.bSignUP) {
            final ProgressDialog pDialog = new ProgressDialog(getActivity());
            pDialog.setMessage("Loading...");
            pDialog.show();
            url = url + username.getText().toString() + "/" + password.getText().toString();
            Log.e("URL", url);
            JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
                    url, null,
                    new Response.Listener<JSONObject>() {

                        @Override
                        public void onResponse(JSONObject response) {
                            try {
                                User.CurrentAdress = response.getString("adress");
                                Date  date = new Date(response.getLong("birthdayDate"));
                                User.CurrentBirthdayDate = date;
                                User.CurrentEmail = response.getString("email");
                                User.CurrentName = response.getString("name");
                                User.CurrentPhone = response.getString("phone");
                                User.CurrentLogin = response.getString("login");
                                User.CurrentPassword = response.getString("password");
                                User.CurrentId = response.getInt("id");
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            pDialog.hide();
                            Intent intent = new Intent(getActivity(), MainActivity.class);
                            startActivity(intent);
                        }
                    }, new Response.ErrorListener() {

                @Override
                public void onErrorResponse(VolleyError error) {
                    // Log.e("Error during login", error.getMessage().toString());

                    // hide the progress dialog
                    pDialog.hide();
                }
            });
            App.getInstance().addToRequestQueue(jsonObjReq);

        }
    }
}
