package com.example.hi.musicapp.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hi.musicapp.Activity.DanhsachtatcaAlbumActivity;
import com.example.hi.musicapp.Adapter.AlbumAdapter;
import com.example.hi.musicapp.Model.AlbumHot;
import com.example.hi.musicapp.R;
import com.example.hi.musicapp.Service.APIService;
import com.example.hi.musicapp.Service.Dataservice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_Album_Hot extends Fragment {
    View view;
    RecyclerView recyclerViewalbum;
    TextView txtviewxemthemalbum, txtviewtitlealbum;
    AlbumAdapter albumAdapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_album_hot,container,false);
        anhxa();
        txtviewxemthemalbum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), DanhsachtatcaAlbumActivity.class);
                startActivity(intent);
            }
        });
        Getdata();
        return view;
    }

    private void anhxa(){
        txtviewxemthemalbum = view.findViewById(R.id.textviewxemthemalbum);
        txtviewtitlealbum = view.findViewById(R.id.textviewtitlealbum);
        recyclerViewalbum = view.findViewById(R.id.recyclerviewAlbum);
    }

    private void Getdata(){
        Dataservice dataservice = APIService.getService();
        Call<List<AlbumHot>> callback = dataservice.GetAlbumHot();
        callback.enqueue(new Callback<List<AlbumHot>>() {
            @Override
            public void onResponse(Call<List<AlbumHot>> call, Response<List<AlbumHot>> response) {
                ArrayList<AlbumHot> albumHotArrayList = (ArrayList<AlbumHot>) response.body();
                albumAdapter = new AlbumAdapter(getActivity(),albumHotArrayList);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                recyclerViewalbum.setLayoutManager(linearLayoutManager);
                recyclerViewalbum.setAdapter(albumAdapter);

            }

            @Override
            public void onFailure(Call<List<AlbumHot>> call, Throwable t) {

            }
        });

    }
}
