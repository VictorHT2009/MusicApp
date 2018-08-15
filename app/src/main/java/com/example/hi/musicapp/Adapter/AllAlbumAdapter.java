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

import com.example.hi.musicapp.Activity.DanhsachbaihatActivity;
import com.example.hi.musicapp.Activity.DanhsachtatcaAlbumActivity;
import com.example.hi.musicapp.Model.AlbumHot;
import com.example.hi.musicapp.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AllAlbumAdapter extends RecyclerView.Adapter<AllAlbumAdapter.ViewHolder>{

    Context context;
    ArrayList<AlbumHot> albumHotArrayList;

    public AllAlbumAdapter(Context context, ArrayList<AlbumHot> albumHotArrayList) {
        this.context = context;
        this.albumHotArrayList = albumHotArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_all_album,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        AlbumHot albumHot = albumHotArrayList.get(position);
        Picasso.with(context).load(albumHot.getHinhAlbum()).into(holder.imgallalbum);
        holder.txtallalbum.setText(albumHot.getTenAlbum());

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imgallalbum;
        TextView txtallalbum;
        public ViewHolder(View itemView) {
            super(itemView);
            imgallalbum = itemView.findViewById(R.id.imageviewdanhsachcacalbum);
            txtallalbum = itemView.findViewById(R.id.textviewdanhsachcacalbum);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, DanhsachbaihatActivity.class);
                    intent.putExtra("album",albumHotArrayList.get(getPosition()));
                    context.startActivity(intent);
                }
            });
        }
    }
}
