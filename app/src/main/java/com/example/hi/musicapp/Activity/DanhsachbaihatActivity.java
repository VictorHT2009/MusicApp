package com.example.hi.musicapp.Activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.hi.musicapp.Adapter.DanhsachbaihatAdapter;
import com.example.hi.musicapp.Model.BaiHatDuocYeuThich;
import com.example.hi.musicapp.Model.Quangcao;
import com.example.hi.musicapp.R;
import com.example.hi.musicapp.Service.APIService;
import com.example.hi.musicapp.Service.Dataservice;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DanhsachbaihatActivity extends AppCompatActivity {

    Quangcao quangcao;
    CoordinatorLayout coordinatorLayout;
    CollapsingToolbarLayout collapsingToolbarLayout;
    Toolbar toolbar;
    RecyclerView recyclerViewdanhsachbaihat;
    FloatingActionButton floatingActionButton;
    ImageView imageViewdanhsachcakhuc;
    ArrayList<BaiHatDuocYeuThich> mangbaihat;
    DanhsachbaihatAdapter danhsachbaihatAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danhsachbaihat);
        DataIntent();
        anhxa();
        init();
        if (quangcao != null && !quangcao.getTenBaiHat().equals("")){
            setValueInView(quangcao.getTenBaiHat(),quangcao.getHinhBaiHat());
            GetDataQuangCao(quangcao.getIdQuangCao());
        }
    }



    private void setValueInView(String ten,String hinh) {
        collapsingToolbarLayout.setTitle(ten);
        try {
            URL url = new URL(hinh);
            Bitmap bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(),bitmap);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                collapsingToolbarLayout.setBackground(bitmapDrawable);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Picasso.with(this).load(hinh).into(imageViewdanhsachcakhuc);

    }
    private void GetDataQuangCao(String idquangcao) {
        Dataservice dataservice = APIService.getService();
        Call<List<BaiHatDuocYeuThich>> callback = dataservice.GetDanhSachBaiHatTheoQuangCao(idquangcao);
        callback.enqueue(new Callback<List<BaiHatDuocYeuThich>>() {
            @Override
            public void onResponse(Call<List<BaiHatDuocYeuThich>> call, Response<List<BaiHatDuocYeuThich>> response) {
                mangbaihat = (ArrayList<BaiHatDuocYeuThich>) response.body();
                danhsachbaihatAdapter = new DanhsachbaihatAdapter(DanhsachbaihatActivity.this,mangbaihat);
                recyclerViewdanhsachbaihat.setLayoutManager(new LinearLayoutManager(DanhsachbaihatActivity.this));
                recyclerViewdanhsachbaihat.setAdapter(danhsachbaihatAdapter);

            }

            @Override
            public void onFailure(Call<List<BaiHatDuocYeuThich>> call, Throwable t) {

            }
        });
    }

    private void init() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        collapsingToolbarLayout.setExpandedTitleColor(Color.WHITE);
        collapsingToolbarLayout.setCollapsedTitleTextColor(Color.WHITE);
    }

    private void anhxa() {
        imageViewdanhsachcakhuc = findViewById(R.id.imageviewdanhsachcakhuc);
        coordinatorLayout = findViewById(R.id.coordinatorlayout);
        collapsingToolbarLayout = findViewById(R.id.collapsingtoolbar);
        toolbar =findViewById(R.id.toolbardanhsach);
        recyclerViewdanhsachbaihat = findViewById(R.id.recyclerviewdanhsachbaihat);
        floatingActionButton = findViewById(R.id.floatingactionbutton);
    }

    private void DataIntent() {
        Intent intent = getIntent();
        if (intent != null){
            if (intent.hasExtra("banner")){
                quangcao = (Quangcao) intent.getSerializableExtra("banner");
                Toast.makeText(this, quangcao.getTenBaiHat(), Toast.LENGTH_SHORT).show();
            }
        }
    }
}
