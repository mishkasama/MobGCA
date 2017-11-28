package com.example.yekkenyosr.pi;

import android.animation.LayoutTransition;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;

import com.example.yekkenyosr.pi.Fragment.InscriptionFragment;
import com.example.yekkenyosr.pi.Fragment.LoginFragment;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.Login;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

public class LoginActivity extends AppCompatActivity {
    ConstraintLayout loginRacine;
    CallbackManager callbackManager;
    EditText username,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginRacine = findViewById(R.id.loginRacine);
        username = findViewById(R.id.etUserNameLogin) ;
        password = findViewById(R.id.etUserPasswordLogin);
        LayoutTransition transition = loginRacine.getLayoutTransition();
        transition.enableTransitionType(LayoutTransition.CHANGING);
        this.CommitFragment(new LoginFragment());
        callbackManager = CallbackManager.Factory.create();
        LoginButton loginButton = (LoginButton) findViewById(R.id.login_button);
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                System.out.println("Success");

            }

            @Override
            public void onCancel() {
                System.out.println("Canceled");
            }

            @Override
            public void onError(FacebookException error) {
                System.out.println("error");
            }
        });


    }

    public void CommitFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.replace(R.id.vpLogin, fragment).commit();
    }

    @Override
    public void onBackPressed() {
        this.CommitFragment(new LoginFragment());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }
}

