package com.example.retrofit.data;

import com.example.retrofit.data.model.BoredApiModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface BoredApi {

  @GET("api/activity/")
    Call<BoredApiModel>getActivities();

}
