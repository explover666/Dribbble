package com.example.max.jetruby_tz.Retrofit;

import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.Retrofit;

public class RetroClient {

    public static final String BASE_URL = "https://api.dribbble.com/v1/";
    private static Retrofit retrofit = null;
    public static final String DRIBBBLE_CLIENT_ACCESS_TOKEN="shots?access_token=d682aa6b981f1b61b2980de1ff9ced29e66b24b347edb2c15726afce416c0918";

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
