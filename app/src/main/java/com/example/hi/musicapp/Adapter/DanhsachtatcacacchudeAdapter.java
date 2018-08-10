package com.example.hi.musicapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.hi.musicapp.Activity.DanhsachtheloaitheochudeActivity;
import com.example.hi.musicapp.Model.Chude;
import com.example.hi.musicapp.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DanhsachtatcacacchudeAdapter extends RecyclerView.Adapter<DanhsachtatcacacchudeAdapter.ViewHolder>{

    Context context;
    ArrayList<Chude> mangchude;

    public DanhsachtatcacacchudeAdapter(Context context, ArrayList<Chude> mangchude) {
        this.context = context;
        this.mangchude = mangchude;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_cac_chu_de,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Chude chude = mangchude.get(position);
        Picasso.with(context).load(chude.getHinhChuDe()).into(holder.imgchude);
    }

    @Override
    public int getItemCount() {
        return mangchude.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imgchude;
        public ViewHolder(View itemView) {
            super(itemView);
            imgchude = itemView.findViewById(R.id.imageviewcacchude);
            imgchude.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, DanhsachtheloaitheochudeActivity.class);
                    intent.putExtra("chude",mangchude.get(getPosition()));
                    context.startActivity(intent);
                }
            });

        }
    }
}
