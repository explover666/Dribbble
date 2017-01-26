package com.example.max.jetruby_tz.Retrofit;

import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.Retrofit;

public class RetroClient {

    public static final String BASE_URL = "https://api.dribbble.com/v1/";
    private static Retrofit retrofit = null;

    public static Retrofit getClient() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
