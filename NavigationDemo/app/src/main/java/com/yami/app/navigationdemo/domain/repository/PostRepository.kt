package com.yami.app.navigationdemo.domain.repository

import com.yami.app.navigationdemo.domain.model.Post

interface PostRepository {
    suspend fun getPostList(): List<Post>
    suspend fun getPost(postId: Int): Post
}