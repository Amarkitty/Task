package com.example.urbranfresh;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.urbranfresh.API.APIClient;
import com.example.urbranfresh.API.ApiConfig;
import com.example.urbranfresh.ModelClass.Categorydatum;
import com.example.urbranfresh.ModelClass.Components;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
    public void onBackPressed() {
        super.onBackPressed();
        finish();
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