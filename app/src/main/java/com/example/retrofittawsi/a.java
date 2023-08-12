package com.example.retrofittawsi;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface a {
    @GET("posts/{id}")
    Call<User> afficher(@Path("id")int id);

    @POST("posts")
    Call<User> add(@Body User user);

    @PUT("posts/{id}")
    Call<User> modifier(@Path("id")int id, @Body User user);

    @DELETE("posts/id")
    Call<User> suprim(@Path("id")int id);
}
