package com.example.urbranfresh.API;

import java.util.ArrayList;

import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Url;

public interface APIInterface {

    @Multipart
    @POST
    Call<ResponseBody> getParams(@Url String methodName, @Part ArrayList<MultipartBody.Part> partArrayList);

}
