package com.yami.app.navigationdemo.presentation.ui.postdetail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
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
import com.yami.app.navigationdemo.domain.model.Post
import kotlinx.coroutines.launch

class PostDetailScreen {
}

@Composable
fun PostDetailScreen(viewModel: PostDetailViewModel = hiltViewModel(), postId: Int?) {
    val scope = rememberCoroutineScope()
    LaunchedEffect(key1 = true) {
        scope.launch {
            postId?.let {
                viewModel.getPosts(it)
            }

        }
    }
    val posts by viewModel.posts.collectAsState()
    loadPost(posts)

}

@Composable
fun loadPost(post: Post) {
    Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)) {
        Text(text = post.title, fontWeight = FontWeight.Bold)
        Text(text = post.body)
        Spacer(modifier = Modifier.padding(8.dp))
        Divider()
    }

}