package com.example.hi.musicapp.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.example.hi.musicapp.Adapter.AllAlbumAdapter;
import com.example.hi.musicapp.Model.AlbumHot;
import com.example.hi.musicapp.R;
import com.example.hi.musicapp.Service.APIService;
import com.example.hi.musicapp.Service.Dataservice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DanhsachtatcaAlbumActivity extends AppCompatActivity {

    RecyclerView recyclerViewtatcaalbum;
    Toolbar toolbartatcaalbum;
    AllAlbumAdapter allAlbumAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danhsachtatca_album);
        GetData();
        init();

    }

    private void GetData() {
        Dataservice dataservice = APIService.getService();
        Call<List<AlbumHot>> callback = dataservice.GetDanhSachAlbum();
        callback.enqueue(new Callback<List<AlbumHot>>() {
            @Override
            public void onResponse(Call<List<AlbumHot>> call, Response<List<AlbumHot>> response) {
                ArrayList<AlbumHot> mangalbum = (ArrayList<AlbumHot>) response.body();
                allAlbumAdapter = new AllAlbumAdapter(DanhsachtatcaAlbumActivity.this,mangalbum);
                recyclerViewtatcaalbum.setLayoutManager(new GridLayoutManager(DanhsachtatcaAlbumActivity.this,2));
                recyclerViewtatcaalbum.setAdapter(allAlbumAdapter);
            }

            @Override
            public void onFailure(Call<List<AlbumHot>> call, Throwable t) {

            }
        });
    }

    private void init() {
        recyclerViewtatcaalbum = findViewById(R.id.recyclerviewAllAlbum);
        toolbartatcaalbum = findViewById(R.id.toolbaralbum);
        setSupportActionBar(toolbartatcaalbum);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Tất Cả Album");
        toolbartatcaalbum.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
