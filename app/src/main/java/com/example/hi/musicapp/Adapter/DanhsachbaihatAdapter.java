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

public class DanhsachbaihatAdapter extends RecyclerView.Adapter<DanhsachbaihatAdapter.ViewHolder> {

    Context context;
    ArrayList<BaiHatDuocYeuThich> mangbaihat;

    public DanhsachbaihatAdapter(Context context, ArrayList<BaiHatDuocYeuThich> mangbaihat) {
        this.context = context;
        this.mangbaihat = mangbaihat;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_danh_sach_bai_hat,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        BaiHatDuocYeuThich baiHatDuocYeuThich = mangbaihat.get(position);
        holder.txttencasi.setText(baiHatDuocYeuThich.getCaSi());
        holder.txttenbaihat.setText(baiHatDuocYeuThich.getTenBaiHat());
        holder.txtindex.setText(position + 1 + "");

    }

    @Override
    public int getItemCount() {
        return mangbaihat.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtindex, txttenbaihat, txttencasi;
        ImageView imgluotthich;
        public ViewHolder(View itemView) {
            super(itemView);
            txtindex = itemView.findViewById(R.id.textviewdanhsachindex);
            txttenbaihat = itemView.findViewById(R.id.textviewtenbaihat);
            txttencasi = itemView.findViewById(R.id.textviewtencasi);
            imgluotthich = itemView.findViewById(R.id.imageviewluotthichdanhsachbaihat);
        }
    }
}
