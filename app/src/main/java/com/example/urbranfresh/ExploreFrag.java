package com.example.urbranfresh;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

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


public class ExploreFrag extends Fragment {


    private AppCompatImageView staticBanner_imageView, adsBannerr_imageView;
    private RecyclerView categoryMenu_listView;
    List<Components> components = new ArrayList<>();
    List<Categorydatum> categorydata = new ArrayList<>();
    CategoryMenuList categoryMenuList;

    public ExploreFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_explore, container, false);

        staticBanner_imageView = view.findViewById(R.id.staticBanner_imageView);
        categoryMenu_listView = view.findViewById(R.id.categoryMenu_listView);
        adsBannerr_imageView = view.findViewById(R.id.adsBannerr_imageView);

        categoryMenu_listView.setLayoutManager(new GridLayoutManager(getActivity(), 3));

        onMenuData();

        return view;
    }

    public void onMenuData() {
        ArrayList<MultipartBody.Part> parts = new ArrayList<>();
        parts.add(MultipartBody.Part.createFormData("category_id", "2"));

        Call<ResponseBody> ownerVehcileDetailCall = APIClient.getClient().getParams(ApiConfig.menuList, parts);
        ownerVehcileDetailCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(@NotNull Call<ResponseBody> call, @NotNull Response<ResponseBody> response) {

                if (response.body() != null) {
                    try {
                        String result = response.body().string();
                        JSONObject jsonObject = new JSONObject(result);
                        components = new Gson().fromJson(jsonObject.getString("components"), new TypeToken<ArrayList<Components>>() {
                        }.getType());


                        String image = components.get(0).getStaticBanner().get(0).getBannerImage();
                        String bannerImageUrl = "http://139.59.83.144:9050/" + image;
                        Glide.with(getActivity()).load(bannerImageUrl).into(staticBanner_imageView);

                        categorydata = components.get(1).getCategorydata();
                        categoryMenuList = new CategoryMenuList(getActivity(), categorydata);
                        categoryMenu_listView.setAdapter(categoryMenuList);

                        String adImage = components.get(2).getAdsBanner().get(0).getBannerImage();
                        String adBannerImageUrl = "http://139.59.83.144:9050/" + adImage;
                        Glide.with(getActivity()).load(adBannerImageUrl).into(adsBannerr_imageView);

                    } catch (JSONException | IOException e) {
                        e.printStackTrace();
                    }

                }
            }

            @Override
            public void onFailure(@NotNull Call<ResponseBody> call, @NotNull Throwable t) {

            }
        });
    }

    public class CategoryMenuList extends RecyclerView.Adapter<CategoryMenuList.ViewHolder> {
        Context context;
        List<Categorydatum> categorydata;

        public CategoryMenuList(Context context, List<Categorydatum> categorydata) {
            this.context = context;
            this.categorydata = categorydata;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.ic_menu_card_view, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public int getItemCount() {
            return categorydata.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            final ImageView imageView;
            final TextView textView;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                imageView = itemView.findViewById(R.id.imageView);
                textView = itemView.findViewById(R.id.textView);
            }
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            Categorydatum list = categorydata.get(position);

            String image = list.getCategoryPicture();
            String imageUrl = "http://139.59.83.144:9050/" + image;
            Glide.with(context).load(imageUrl).into(holder.imageView);
            holder.textView.setText(list.getCategoryName());
        }
    }
}