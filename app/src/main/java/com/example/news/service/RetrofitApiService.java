package com.example.news.service;

import com.example.news.entity.Message;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RetrofitApiService {
    @GET("posts/{id}")
    Call<Message> getMessageId(@Path("id") int id);
}
