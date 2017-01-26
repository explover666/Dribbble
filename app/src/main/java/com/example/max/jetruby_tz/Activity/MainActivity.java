package com.example.max.jetruby_tz.Activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.max.jetruby_tz.Adapters.RVAdapter;
import com.example.max.jetruby_tz.R;
import com.example.max.jetruby_tz.Retrofit.RetroClient;
import com.example.max.jetruby_tz.Retrofit.RetroInterface;
import com.example.max.jetruby_tz.Model.Shot;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends Activity{

    private RecyclerView rv;
    private List<Shot> shots = new ArrayList<>();
    private RVAdapter rvAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv = (RecyclerView) findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setHasFixedSize(true);
        rvAdapter = new RVAdapter(shots, R.layout.list_item_shots, getApplicationContext());
        rv.setAdapter(rvAdapter);
        RetroInterface retroInterface = RetroClient.getClient().create(RetroInterface.class);
        Call<List<Shot>> call;
            for (int i = 0; i < 4; i++) {
                call = retroInterface.getJsonValues(i+1);
                call.enqueue(new Callback<List<Shot>>() {
                    @Override
                    public void onResponse(Call<List<Shot>> call, Response<List<Shot>> response) {
                        if (response != null && response.body() != null) {
                            rvAdapter.addElements(response.body());
                            rvAdapter.notifyDataSetChanged();
                        }
                    }
                    @Override
                    public void onFailure(Call<List<Shot>> call, Throwable t) {
                        Toast toast = Toast.makeText(getApplicationContext(),
                                "Server unreachable, please try again later(", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                });
            }
    }
}



