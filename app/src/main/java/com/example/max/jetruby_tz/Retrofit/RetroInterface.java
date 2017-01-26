package com.example.max.jetruby_tz.Retrofit;

import com.example.max.jetruby_tz.Model.Shot;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import static com.example.max.jetruby_tz.Retrofit.RetroClient.DRIBBBLE_CLIENT_ACCESS_TOKEN;

public interface RetroInterface {

    @GET(DRIBBBLE_CLIENT_ACCESS_TOKEN)
    Call<List<Shot>> getJsonValues(@Query("page") int page);
}

