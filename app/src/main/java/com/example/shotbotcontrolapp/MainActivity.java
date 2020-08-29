package com.example.shotbotcontrolapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;


import okhttp3.ResponseBody;
import retrofit2.*;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    restInterface restInterface;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createPost(4000);
            }
        });

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.188.101:8080/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        restInterface = retrofit.create(restInterface.class);




    }
    private void createPost(int amount) {

        Call<ResponseBody> call = restInterface.postTime(amount);
        call.toString();
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Log.i(response.toString(), "message" );
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.i(t.getMessage(), "message" );
            }
        });
    }
}