package com.example.urbranfresh.API;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class APIClient {

    private static final String url = "http://139.59.83.144:9050/api/";


    public static APIInterface getClient() {

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();

        logging.level(HttpLoggingInterceptor.Level.BODY);

        Gson gson = new GsonBuilder().setLenient().create();

        OkHttpClient okHttpClient = new OkHttpClient.Builder()

                .addInterceptor(logging).readTimeout(300, TimeUnit.SECONDS)

                .connectTimeout(300, TimeUnit.SECONDS)

                .retryOnConnectionFailure(true)

                .build();

        return new Retrofit.Builder().baseUrl(url).client(okHttpClient)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
                .create(APIInterface.class);

    }
}

