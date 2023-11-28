package com.yami.app.retrofitdemo.presentation.ui.postlist

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.yami.app.retrofitdemo.domain.model.Post
import kotlinx.coroutines.launch

@Composable
fun PostListScreen(viewModel:PostListViewModel = hiltViewModel()) {
    val scope = rememberCoroutineScope()
    LaunchedEffect(key1 = true) {
        scope.launch {
            viewModel.getPosts()
        }
    }
    val posts by viewModel.posts.collectAsState()
    loadPosts(posts)

}

@Composable
fun loadPosts(posts: List<Post>) {
    LazyColumn {
        items(posts) { post ->
            Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)) {
                Text(text = post.title, fontWeight = FontWeight.Bold)
                Text(text = post.body)
                Spacer(modifier = Modifier.padding(8.dp))
                Divider()
            }
        }
    }
}