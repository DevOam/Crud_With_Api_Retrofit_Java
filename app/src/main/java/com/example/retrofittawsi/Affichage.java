package com.example.retrofittawsi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Affichage extends AppCompatActivity {
    TextView userId, title, body;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affichage);
        init();
        Intent intent =  getIntent();
        int id  = Integer.parseInt(intent.getStringExtra("id"));
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Api api = retrofit.create(Api.class);


        api.getUser(id).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                userId.setText(String.valueOf(response.body().getUserId()));
                title.setText(response.body().getTitle());
                body.setText(response.body().getBody());
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
    }
    private  void init(){
        userId = findViewById(R.id.userId);
        title = findViewById(R.id.title);
        body = findViewById(R.id.body);
    }
}