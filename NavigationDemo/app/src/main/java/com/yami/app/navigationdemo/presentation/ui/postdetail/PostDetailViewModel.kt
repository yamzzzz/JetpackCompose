package com.yami.app.navigationdemo.presentation.ui.postdetail

import androidx.lifecycle.ViewModel
import com.yami.app.navigationdemo.domain.model.Post
import com.yami.app.navigationdemo.domain.usecase.PostDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class PostDetailViewModel @Inject constructor(private val postDetailUseCase: PostDetailUseCase) : ViewModel(){
    private val _posts = MutableStateFlow(Post(0,"",""))
    val posts: StateFlow<Post> = _posts

    suspend fun getPosts(postId:Int) {
        _posts.value = postDetailUseCase(postId)
    }
}