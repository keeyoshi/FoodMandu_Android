package com.keeyoshi.foodmandu.API;

import com.keeyoshi.foodmandu.Model.Flavours;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface FlavoursAPI {

    @GET("flavours")
    Call<List<Flavours>> getflavours();

    @GET("flavours")
    Call<Flavours> getflavoursimage(@Header("Authorization") String token);
}
