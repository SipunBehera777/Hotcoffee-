package com.example.hotcoffee.retro;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroInstance {
    private static final String BASE_URL="https://api.sampleapis.com/coffee/";
    private static Retrofit retrofit;

    public static  Retrofit getRetrofit(){
        if (retrofit == null) {
           retrofit=new Retrofit.Builder()
                   .baseUrl(BASE_URL)
                   .addConverterFactory(GsonConverterFactory.create())
                   .build();

        }
        return  retrofit;
    }
}
