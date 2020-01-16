package com.keeyoshi.foodmandu.API;

import com.keeyoshi.foodmandu.ui.home.Model.Super7;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface Superapi {
    @GET("super7")
    Call<List<Super7>> getsuper();

    @GET("super7")
    Call<Super7> getsuperimage(@Header("Authorization") String token);
}
