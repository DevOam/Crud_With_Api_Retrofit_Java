package com.example.retrofittawsi;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface Api {
    @GET("posts/{id}")
    public Call<User> getUser(@Path("id") int id);

    @POST("posts")
    public Call<User> addUser(@Body User user);

    @PATCH("posts/{id}")
    public Call<User> updateUser(@Path("id") int id, @Body User user);

    @DELETE("posts/{id}")
    public Call<User> deleteUser(@Path("id") int id);
}
