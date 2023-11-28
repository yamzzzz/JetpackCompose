package com.yami.app.navigationdemo.data.repository

import com.yami.app.navigationdemo.data.entity.response.PostDTO
import retrofit2.http.GET
import retrofit2.http.Path

interface APIService {
    @GET("posts")
    suspend fun getPostList(): List<PostDTO>

    @GET("posts/{postId}")
    suspend fun getPost(@Path("postId") postId: Int): PostDTO
}