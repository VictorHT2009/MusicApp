package com.example.hi.musicapp.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hi.musicapp.Model.BaiHatDuocYeuThich;
import com.example.hi.musicapp.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class BaihathotAdapter extends RecyclerView.Adapter<BaihathotAdapter.ViewHolder>{

    Context context;
    ArrayList<BaiHatDuocYeuThich> baiHatDuocYeuThichArrayList;

    public BaihathotAdapter(Context context, ArrayList<BaiHatDuocYeuThich> baiHatDuocYeuThichArrayList) {
        this.context = context;
        this.baiHatDuocYeuThichArrayList = baiHatDuocYeuThichArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_bai_hat_hot,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        BaiHatDuocYeuThich baiHatDuocYeuThich = baiHatDuocYeuThichArrayList.get(position);
        holder.txttencasi.setText(baiHatDuocYeuThich.getCaSi());
        holder.txtbaihat.setText(baiHatDuocYeuThich.getTenBaiHat());
        Picasso.with(context).load(baiHatDuocYeuThich.getHinhBaiHat()).into(holder.imghinhbaihat);
    }

    @Override
    public int getItemCount() {
        return baiHatDuocYeuThichArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtbaihat, txttencasi;
        ImageView imghinhbaihat, imgluotthich;
        public ViewHolder(View itemView) {
            super(itemView);
            txtbaihat = itemView.findViewById(R.id.textviewbaihathot);
            txttencasi = itemView.findViewById(R.id.textviewtencasibaihathot);
            imghinhbaihat = itemView.findViewById(R.id.imageviewbaihathot);
            imgluotthich = itemView.findViewById(R.id.imageviewluotthich);

        }
    }
}
