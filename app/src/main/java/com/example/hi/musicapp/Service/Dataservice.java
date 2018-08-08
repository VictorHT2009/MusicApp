package com.example.hi.musicapp.Service;

import com.example.hi.musicapp.Model.Playlist;
import com.example.hi.musicapp.Model.Quangcao;
import com.example.hi.musicapp.Model.Theloaitrongngay;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

//tuong tac voi server
public interface Dataservice {
    //tuong tac voi phia duong link
    @GET("songbanner.php")
    //Function nhan phuong thuc, vi o? day nhan ve du lieu la mang Json nen ta dung "List" sau do la Json object thi ta goi object "Quangcao"
    Call<List<Quangcao>> GetDataBanner();

    @GET("playlistforcurrentday.php")
    Call<List<Playlist>> GetPlaylistCurrentDay();

    @GET("ChudevaTheloaitrongngay.php")
    Call<Theloaitrongngay> GetCategoryMusic();
}
