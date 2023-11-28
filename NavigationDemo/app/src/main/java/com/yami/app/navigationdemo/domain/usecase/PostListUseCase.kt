package com.yami.app.navigationdemo.domain.usecase

import com.yami.app.navigationdemo.domain.model.Post
import com.yami.app.navigationdemo.domain.repository.PostRepository
import javax.inject.Inject

class PostListUseCase @Inject constructor(private val postRepository: PostRepository) {
    suspend operator fun invoke(): List<Post> {
        return postRepository.getPostList()
    }
}