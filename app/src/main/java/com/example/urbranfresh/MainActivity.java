package com.example.urbranfresh;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private AppCompatButton explore_selected_buttonView, car_selected_buttonView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        explore_selected_buttonView = findViewById(R.id.explore_selected_buttonView);
        car_selected_buttonView = findViewById(R.id.car_selected_buttonView);

        ExploreFrag exploreFrag = new ExploreFrag();
        onFragment(exploreFrag);

        explore_selected_buttonView.setOnClickListener(this);
        car_selected_buttonView.setOnClickListener(this);
    }




    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.explore_selected_buttonView:
                ExploreFrag exploreFrag = new ExploreFrag();
                onFragment(exploreFrag);

                break;


            case R.id.car_selected_buttonView:
                CartFrag cartFrag = new CartFrag();
                onFragment(cartFrag);
                break;
        }

    }

    public void onFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentView, fragment);
        fragmentTransaction.commit();
    }



}