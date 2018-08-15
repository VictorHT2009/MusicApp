package com.example.hi.musicapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hi.musicapp.Activity.PlaynhacActivity;
import com.example.hi.musicapp.Model.BaiHatDuocYeuThich;
import com.example.hi.musicapp.R;
import com.example.hi.musicapp.Service.APIService;
import com.example.hi.musicapp.Service.Dataservice;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, PlaynhacActivity.class);
                    intent.putExtra("cakhuc",baiHatDuocYeuThichArrayList.get(getPosition()));
                    context.startActivity(intent);
                }
            });
            imgluotthich.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    imgluotthich.setImageResource(R.drawable.iconloved);
                    Dataservice dataservice = APIService.getService();
                    //gia tri Id bai hat la ta can lay Id cua bai hat tren server de thay doi
                    Call<String> callback = dataservice.UpdateLuotThich("1",baiHatDuocYeuThichArrayList.get(getPosition()).getIdBaiHat());
                    callback.enqueue(new Callback<String>() {
                        @Override
                        public void onResponse(Call<String> call, Response<String> response) {
                            String ketqua = response.body();
                            if (ketqua.equals("Success")){
                                Toast.makeText(context, "Đã Thích", Toast.LENGTH_SHORT).show();
                            }else {
                                Toast.makeText(context, "Bị Lỗi", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<String> call, Throwable t) {

                        }
                    });
                    imgluotthich.setEnabled(false);
                }
            });

        }
    }
}
