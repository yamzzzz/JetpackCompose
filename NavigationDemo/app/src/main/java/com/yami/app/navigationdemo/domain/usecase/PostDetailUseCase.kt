package com.yami.app.navigationdemo.domain.usecase

import com.yami.app.navigationdemo.domain.model.Post
import com.yami.app.navigationdemo.domain.repository.PostRepository
import javax.inject.Inject

class PostDetailUseCase @Inject constructor(private val postRepository: PostRepository) {
    suspend operator fun invoke(postId: Int): Post = postRepository.getPost(postId = postId)
}