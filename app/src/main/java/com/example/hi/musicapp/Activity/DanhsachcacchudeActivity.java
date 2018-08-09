package com.example.hi.musicapp.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.example.hi.musicapp.Model.Chude;
import com.example.hi.musicapp.R;
import com.example.hi.musicapp.Service.APIService;
import com.example.hi.musicapp.Service.Dataservice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DanhsachcacchudeActivity extends AppCompatActivity {

    RecyclerView recyclerViewAllchude;
    Toolbar toolbarAllchude;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danhsachcacchude);
        init();
        GetData();
    }

    private void GetData() {
        Dataservice dataservice = APIService.getService();
        Call<List<Chude>> callback = dataservice.GetDanhSachAllChuDe();
        callback.enqueue(new Callback<List<Chude>>() {
            @Override
            public void onResponse(Call<List<Chude>> call, Response<List<Chude>> response) {
                ArrayList<Chude> mangchude = (ArrayList<Chude>) response.body();
                Log.d("BBB",mangchude.get(0).getTenChuDe());
            }

            @Override
            public void onFailure(Call<List<Chude>> call, Throwable t) {

            }
        });
    }

    private void init() {
        recyclerViewAllchude = findViewById(R.id.recyclerviewAllchude);
        toolbarAllchude = findViewById(R.id.toolbarAllchude);
        setSupportActionBar(toolbarAllchude);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Tất Cả Chủ Đề");
        toolbarAllchude.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
