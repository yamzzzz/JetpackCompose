package com.yami.app.navigationdemo.presentation.ui.postlist

import androidx.lifecycle.ViewModel
import com.yami.app.navigationdemo.domain.model.Post
import com.yami.app.navigationdemo.domain.usecase.PostListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class PostListViewModel @Inject constructor(private val postListUseCase: PostListUseCase) : ViewModel() {
    private val _posts = MutableStateFlow(emptyList<Post>())
    val posts: StateFlow<List<Post>> = _posts

    suspend fun getPosts() {
        _posts.value = postListUseCase()
    }
}