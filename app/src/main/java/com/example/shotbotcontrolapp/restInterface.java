package com.example.shotbotcontrolapp;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface restInterface {

    @POST("delay")
    Call<ResponseBody> postTime(@Query("time") int amount);
}
