package com.example.kozmetickisalon.api;

import java.util.List;

import com.example.kozmetickisalon.model.KozmetickiProzivod;
import com.example.kozmetickisalon.model.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
public interface appapi {
    @GET("/api/users/all")
    Call<List<User>> getAllUsers();
    @POST("/api/users/register")
    Call<User>save(@Body User user );
    @POST("/api/users/login")
    Call<User>login(@Body User user );

    @GET("/api/predmeti/all")
    Call<List<KozmetickiProzivod>> getAllKProizvod();
}
