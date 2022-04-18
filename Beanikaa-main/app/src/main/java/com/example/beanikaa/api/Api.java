package com.example.beanikaa.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.example.beanikaa.result.Second_screen;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface Api {

    // link API: Đơi link api của Huyền
    public static final String DOMAIN = "http://facerecognition.ap.ngrok.io/";

    Gson gson = new GsonBuilder().setDateFormat("yyyy MM dd HH:mm:ss").create();

    Api apiAdd2Cart = new Retrofit.Builder()
            .baseUrl(DOMAIN)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(Api.class);

    @Multipart
    @POST("register")
    Call<Second_screen> add2cart (
                                         @Part(Const.KEY_FOODID)RequestBody foodID,
                                        @Part(Const.KEY_NUMBER)RequestBody number
    );
}
