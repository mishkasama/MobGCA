package com.example.yekkenyosr.pi;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.yekkenyosr.pi.Fragment.ProfilFragment;
import com.example.yekkenyosr.pi.Fragment.ShowAllFragment;

import java.util.ArrayList;

import devlight.io.library.ntb.NavigationTabBar;

public class MainActivity extends AppCompatActivity {
    NavigationTabBar navigationTabBar;
    final ArrayList<NavigationTabBar.Model> models = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navigationTabBar = findViewById(R.id.ntb);
        InitMenu();
        CommitFragment(new ShowAllFragment());
        getSupportActionBar().hide();
    }

    public void CommitFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.replace(R.id.container, fragment).commit();
    }

    private void InitMenu() {

        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.drawable.insurance_icon),
                        Color.parseColor("#40bf80")
                ).title("Add")
                        .badgeTitle("NTB")
                        .build()
        );
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.drawable.insurance_icon),//TODO change icon
                        Color.parseColor("#ff7373")
                ).title("Profil")
                        .badgeTitle("with")
                        .build()
        );
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.drawable.insurance_icon),//TODO change icon
                        Color.parseColor("#ffb14c")
                ).title("Sinister")
                        .badgeTitle("with")
                        .build()
        );
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.drawable.insurance_icon),//TODO change icon
                        Color.parseColor("#cc33ff")
                ).title("Update")
                        .badgeTitle("with")
                        .build()
        );


        navigationTabBar.setModels(models);
        navigationTabBar.setTitleMode(NavigationTabBar.TitleMode.ACTIVE);
        navigationTabBar.setBadgeGravity(NavigationTabBar.BadgeGravity.BOTTOM);
        navigationTabBar.setBadgePosition(NavigationTabBar.BadgePosition.CENTER);
        navigationTabBar.setIsBadged(true);
        navigationTabBar.setIsTitled(true);
        navigationTabBar.setIsTinted(true);
        navigationTabBar.setIsBadgeUseTypeface(true);
        navigationTabBar.setBadgeBgColor(Color.parseColor("#fa8072")); //TODO change badge color
        navigationTabBar.setBadgeTitleColor(Color.parseColor("#ffc3a0"));
        navigationTabBar.setIsSwiped(true);
        navigationTabBar.setBgColor(Color.parseColor("#2e2eb8"));
        navigationTabBar.setBadgeSize(10);
        navigationTabBar.setTitleSize(10);
        navigationTabBar.setIconSizeFraction(0.5f);
        navigationTabBar.setActivated(true);
        navigationTabBar.setOnTabBarSelectedIndexListener(new NavigationTabBar.OnTabBarSelectedIndexListener() {
            @Override
            public void onStartTabSelected(NavigationTabBar.Model model, int index) {
                if(index == 0 ){
                    CommitFragment(new ShowAllFragment());
                }else if (index == 1){
                    CommitFragment(new ProfilFragment());
                }
            }

            @Override
            public void onEndTabSelected(NavigationTabBar.Model model, int index) {

            }
        });
    }
}
