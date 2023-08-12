package com.example.retrofittawsi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Ajout extends AppCompatActivity {
    EditText userId, title, body;
    Button btnajout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout);
        init();
//        int valUserId = Integer.parseInt(userId.getText());
    }
    private void init(){
        userId=findViewById(R.id.userId);
        title=findViewById(R.id.title);
        body=findViewById(R.id.body);
        btnajout=findViewById(R.id.ajouter);
    }
    public void onclickAjout(View view){
        retro();
    }
    private void retro(){
        init();
        Retrofit retrofit =  new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        int userIdTxt = Integer.parseInt(userId.getText().toString());
        String titleTxt = title.getText().toString();
        String bodyTxt = body.getText().toString();
        User user = new User(userIdTxt, titleTxt, bodyTxt);

        Api api = retrofit.create(Api.class);
        api.addUser(user).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Toast.makeText(Ajout.this, String.valueOf(response.body().getId()), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });

    }
}