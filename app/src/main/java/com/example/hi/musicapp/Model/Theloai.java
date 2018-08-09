package com.example.hi.musicapp.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Theloai implements Serializable{

@SerializedName("IdTheLoai")
@Expose
private String idTheLoai;
@SerializedName("IdKeyChuDe")
@Expose
private String idKeyChuDe;
@SerializedName("IdKeyAlbum")
@Expose
private String idKeyAlbum;
@SerializedName("IdKeyPlayList")
@Expose
private String idKeyPlayList;
@SerializedName("TenTheLoai")
@Expose
private String tenTheLoai;
@SerializedName("HinhTheLoai")
@Expose
private String hinhTheLoai;

public String getIdTheLoai() {
return idTheLoai;
}

public void setIdTheLoai(String idTheLoai) {
this.idTheLoai = idTheLoai;
}

public String getIdKeyChuDe() {
return idKeyChuDe;
}

public void setIdKeyChuDe(String idKeyChuDe) {
this.idKeyChuDe = idKeyChuDe;
}

public String getIdKeyAlbum() {
return idKeyAlbum;
}

public void setIdKeyAlbum(String idKeyAlbum) {
this.idKeyAlbum = idKeyAlbum;
}

public String getIdKeyPlayList() {
return idKeyPlayList;
}

public void setIdKeyPlayList(String idKeyPlayList) {
this.idKeyPlayList = idKeyPlayList;
}

public String getTenTheLoai() {
return tenTheLoai;
}

public void setTenTheLoai(String tenTheLoai) {
this.tenTheLoai = tenTheLoai;
}

public String getHinhTheLoai() {
return hinhTheLoai;
}

public void setHinhTheLoai(String hinhTheLoai) {
this.hinhTheLoai = hinhTheLoai;
}

}