package com.yami.app.retrofitdemo.data.repository

import com.yami.app.retrofitdemo.data.entity.response.PostDTO
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import java.util.concurrent.TimeUnit

interface APIService {
    @GET("posts")
    suspend fun getPosts(): List<PostDTO>
}