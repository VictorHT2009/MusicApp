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
        public ViewHolder(final View itemView) {
            super(itemView);
            txtindex = itemView.findViewById(R.id.textviewdanhsachindex);
            txttenbaihat = itemView.findViewById(R.id.textviewtenbaihat);
            txttencasi = itemView.findViewById(R.id.textviewtencasi);
            imgluotthich = itemView.findViewById(R.id.imageviewluotthichdanhsachbaihat);
            imgluotthich.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    imgluotthich.setImageResource(R.drawable.iconloved);
                    Dataservice dataservice = APIService.getService();
                    //gia tri Id bai hat la ta can lay Id cua bai hat tren server de thay doi
                    Call<String> callback = dataservice.UpdateLuotThich("1",mangbaihat.get(getPosition()).getIdBaiHat());
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
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, PlaynhacActivity.class);
                    intent.putExtra("cakhuc",mangbaihat.get(getPosition()));
                    context.startActivity(intent);
                }
            });
        }
    }
}
