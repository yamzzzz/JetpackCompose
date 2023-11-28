package com.yami.app.retrofitdemo.data.repository

import com.yami.app.retrofitdemo.domain.repository.PostRepository
import com.yami.app.retrofitdemo.domain.model.Post
import javax.inject.Inject

class PostRepositoryImpl @Inject constructor(private val apiService: APIService) : PostRepository {
    override suspend fun getPosts(): List<Post> {
        return apiService.getPosts().map { response -> response.toDomain() }
    }
}