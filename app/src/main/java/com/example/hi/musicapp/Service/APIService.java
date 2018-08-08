package com.example.hi.musicapp.Service;

    //Function trung gian ket hop 2 service API retrofit va Data service
public class APIService {
    private static String base_url = "https://mrhoanght2009.000webhostapp.com/Serve/";
    public static Dataservice getService(){
        return APIRetrofitClient.getClient(base_url).create(Dataservice.class);

    }
}
