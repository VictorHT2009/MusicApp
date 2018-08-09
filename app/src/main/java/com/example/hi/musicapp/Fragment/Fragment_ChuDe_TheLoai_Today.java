package com.example.hi.musicapp.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.hi.musicapp.Activity.DanhsachbaihatActivity;
import com.example.hi.musicapp.Activity.DanhsachcacchudeActivity;
import com.example.hi.musicapp.Model.Chude;
import com.example.hi.musicapp.Model.Theloai;
import com.example.hi.musicapp.Model.Theloaitrongngay;
import com.example.hi.musicapp.R;
import com.example.hi.musicapp.Service.APIService;
import com.example.hi.musicapp.Service.Dataservice;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_ChuDe_TheLoai_Today extends Fragment {

    View view;
    HorizontalScrollView horizontalScrollView;
    TextView txtviewxemthemChuDeTheLoai;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_chude_theloai_today,container,false);
        anhxa();
        txtviewxemthemChuDeTheLoai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), DanhsachcacchudeActivity.class);
                startActivity(intent);
            }
        });
        GetData();
        return view;
    }

    private void anhxa(){
        horizontalScrollView = view.findViewById(R.id.horizontalscrollview);
        txtviewxemthemChuDeTheLoai = view.findViewById(R.id.textviewxemthem);
    }

    private void GetData(){
        Dataservice dataservice = APIService.getService();
        Call<Theloaitrongngay> callback = dataservice.GetCategoryMusic();
        callback.enqueue(new Callback<Theloaitrongngay>() {
            @Override
            public void onResponse(Call<Theloaitrongngay> call, Response<Theloaitrongngay> response) {
                Theloaitrongngay theloaitrongngay = response.body();

                final ArrayList<Chude> chudeArrayList = new ArrayList<>();
                chudeArrayList.addAll(theloaitrongngay.getChude());

                final ArrayList<Theloai> theloaiArrayList = new ArrayList<>();
                theloaiArrayList.addAll(theloaitrongngay.getTheloai());

                LinearLayout linearLayout = new LinearLayout(getActivity());
                linearLayout.setOrientation(LinearLayout.HORIZONTAL);

                LinearLayout.LayoutParams layout = new LinearLayout.LayoutParams(580,250);
                layout.setMargins(10,20,10,30);
                    //Chu de Arraylist
                for (int i =0; i <(chudeArrayList.size()); i++){
                    CardView cardView = new CardView(getActivity());
                    cardView.setRadius(10);
                    ImageView imageView = new ImageView(getActivity());
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    if (chudeArrayList.get(i).getHinhChuDe() != null){
                        Picasso.with(getActivity()).load(chudeArrayList.get(i).getHinhChuDe()).into(imageView);
                    }
                    cardView.setLayoutParams(layout);
                    cardView.addView(imageView);
                    linearLayout.addView(cardView);
                }
                    //The loai Arraylist
                for (int j =0; j <(theloaiArrayList.size()); j++){
                    CardView cardView = new CardView(getActivity());
                    cardView.setRadius(10);
                    ImageView imageView = new ImageView(getActivity());
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    if (theloaiArrayList.get(j).getHinhTheLoai() != null){
                        Picasso.with(getActivity()).load(theloaiArrayList.get(j).getHinhTheLoai()).into(imageView);
                    }
                    cardView.setLayoutParams(layout);
                    cardView.addView(imageView);
                    linearLayout.addView(cardView);

                    final int finalJ = j;
                    imageView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(getActivity(), DanhsachbaihatActivity.class);
                            intent.putExtra("idtheloai", theloaiArrayList.get(finalJ));
                            startActivity(intent);
                        }
                    });
                }
                horizontalScrollView.addView(linearLayout);
            }
            @Override
            public void onFailure(Call<Theloaitrongngay> call, Throwable t) {

            }
        });
    }
}
