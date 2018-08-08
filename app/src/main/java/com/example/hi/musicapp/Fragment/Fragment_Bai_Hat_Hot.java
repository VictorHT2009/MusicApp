package com.example.hi.musicapp.Fragment;

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

import com.example.hi.musicapp.Adapter.BaihathotAdapter;
import com.example.hi.musicapp.Model.BaiHatDuocYeuThich;
import com.example.hi.musicapp.R;
import com.example.hi.musicapp.Service.APIService;
import com.example.hi.musicapp.Service.Dataservice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_Bai_Hat_Hot extends Fragment {

    View view;
    RecyclerView recyclerViewbaihathot;
    BaihathotAdapter baihathotAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_bai_hat_hot,container,false);
        anhxa();
        Getdata();
        return view;
    }

    private void anhxa(){
        recyclerViewbaihathot = view.findViewById(R.id.recyclerviewbaihathot);
    }

    private void Getdata(){
        Dataservice dataservice = APIService.getService();
        Call<List<BaiHatDuocYeuThich>> callback = dataservice.GetBaiHatHot();
        callback.enqueue(new Callback<List<BaiHatDuocYeuThich>>() {
            @Override
            public void onResponse(Call<List<BaiHatDuocYeuThich>> call, Response<List<BaiHatDuocYeuThich>> response) {
                ArrayList<BaiHatDuocYeuThich> baiHatDuocYeuThichArrayList = (ArrayList<BaiHatDuocYeuThich>) response.body();
                baihathotAdapter = new BaihathotAdapter(getActivity(),baiHatDuocYeuThichArrayList);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                recyclerViewbaihathot.setLayoutManager(linearLayoutManager);
                recyclerViewbaihathot.setAdapter(baihathotAdapter);
            }

            @Override
            public void onFailure(Call<List<BaiHatDuocYeuThich>> call, Throwable t) {

            }
        });
    }
}
