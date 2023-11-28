package com.yami.app.retrofitdemo.domain.usecase

import com.yami.app.retrofitdemo.data.repository.PostRepositoryImpl
import com.yami.app.retrofitdemo.domain.model.Post
import javax.inject.Inject

class PostListUseCase @Inject constructor(private val postRepository: PostRepositoryImpl) {
    suspend operator fun invoke(): List<Post> {
        return postRepository.getPosts()
    }
}