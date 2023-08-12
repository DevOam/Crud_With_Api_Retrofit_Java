package com.example.retrofittawsi;

import androidx.appcompat.app.AppCompatActivity;

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

public class Modification extends AppCompatActivity {
    EditText id,userId, title, body;
    Button btnaModif;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modification);
        init();
    }
    private void init(){
        id = findViewById(R.id.id);
        userId=findViewById(R.id.userId);
        title=findViewById(R.id.title);
        body=findViewById(R.id.body);
        btnaModif=findViewById(R.id.ajouter);
    }
    public void onclickModif(View view){
        init();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);

        int userIdTxt = Integer.parseInt(userId.getText().toString());
        String titleTxt = title.getText().toString();
        String bodyTxt = body.getText().toString();
        User user = new User(userIdTxt, null, bodyTxt);

        api.updateUser(Integer.parseInt(id.getText().toString()), user).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Toast.makeText(Modification.this, String.valueOf(response.body().getId()), Toast.LENGTH_SHORT).show();
                Toast.makeText(Modification.this, response.body().getTitle(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
}}