package com.example.max.jetruby_tz.Retrofit;

import com.example.max.jetruby_tz.Model.Shot;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetroInterface {
    @GET("shots?access_token=d682aa6b981f1b61b2980de1ff9ced29e66b24b347edb2c15726afce416c0918")
    Call<List<Shot>> getJsonValues(@Query("page") int page);
}

