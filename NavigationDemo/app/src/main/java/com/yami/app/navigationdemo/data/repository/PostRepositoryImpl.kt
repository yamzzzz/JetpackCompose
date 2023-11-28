package com.yami.app.navigationdemo.data.repository

import com.yami.app.navigationdemo.domain.repository.PostRepository
import com.yami.app.navigationdemo.domain.model.Post
import javax.inject.Inject

class PostRepositoryImpl @Inject constructor(val apiService: APIService) : PostRepository {
    override suspend fun getPostList(): List<Post> =
        apiService.getPostList().map { response -> response.toDomain() }

    override suspend fun getPost(postId: Int): Post = apiService.getPost(postId).toDomain()

}