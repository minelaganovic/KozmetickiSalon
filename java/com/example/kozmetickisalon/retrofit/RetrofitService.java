package com.example.kozmetickisalon.retrofit;

import com.example.kozmetickisalon.api.appapi;
import com.google.gson.Gson;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
public class RetrofitService {
    private Retrofit retrofit;
    public RetrofitService() {
        initializeRetrofit();
    }

    private void initializeRetrofit() {
        retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.0.112:8080") //ipv4 adresa sa lokala racunara i zadnji broj od bekenda
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .build();
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }
    ///za preuzimanje usera
    public appapi getUserApi() {
        return retrofit.create(appapi.class);
    }
    //za preuzimanje kproizvoda
    public appapi getAllKProizvod(){
        return retrofit.create(appapi.class);
    }

}

