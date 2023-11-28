package com.yami.app.retrofitdemo.data.network

import com.yami.app.retrofitdemo.data.entity.response.PostDTO
import com.yami.app.retrofitdemo.domain.model.Post
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PostRepository {
    suspend fun getPosts(): List<Post>
}