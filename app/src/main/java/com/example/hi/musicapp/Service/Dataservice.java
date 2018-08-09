package com.example.hi.musicapp.Service;

import com.example.hi.musicapp.Model.AlbumHot;
import com.example.hi.musicapp.Model.BaiHatDuocYeuThich;
import com.example.hi.musicapp.Model.Chude;
import com.example.hi.musicapp.Model.Playlist;
import com.example.hi.musicapp.Model.Quangcao;
import com.example.hi.musicapp.Model.Theloaitrongngay;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

//tuong tac voi server
public interface Dataservice {
    //tuong tac voi phia duong link
    @GET("songbanner.php")
    //Function nhan phuong thuc, vi o? day nhan ve du lieu la mang Json nen ta dung "List" sau do la Json object thi ta goi object "Quangcao"
    Call<List<Quangcao>> GetDataBanner();

    @GET("playlistforcurrentday.php")
    Call<List<Playlist>> GetPlaylistCurrentDay();

    @GET("chudevatheloaitrongngay.php")
    Call<Theloaitrongngay> GetCategoryMusic();

    @GET("albumhot.php")
    Call<List<AlbumHot>> GetAlbumHot();

    @GET("baihatduocyeuthich.php")
    Call<List<BaiHatDuocYeuThich>> GetBaiHatHot();

    @FormUrlEncoded
    @POST("danhsachbaihat.php")
    Call<List<BaiHatDuocYeuThich>> GetDanhSachBaiHatTheoQuangCao(@Field("idquangcao") String idquangcao);

    @FormUrlEncoded
    @POST("danhsachbaihat.php")
    Call<List<BaiHatDuocYeuThich>> GetDanhSachBaiHatTheoPlayList(@Field("idplaylist") String idplaylist);

    @GET("danhsachcacplaylist.php")
    Call<List<Playlist>> GetDanhSachCacPlaylist();

    @FormUrlEncoded
    @POST("danhsachbaihat.php")
    Call<List<BaiHatDuocYeuThich>> GetDanhSachBaiHatTheoTheLoai(@Field("idtheloai") String idtheloai);

    @GET("tatcachude.php")
    Call<List<Chude>> GetDanhSachAllChuDe();

}
