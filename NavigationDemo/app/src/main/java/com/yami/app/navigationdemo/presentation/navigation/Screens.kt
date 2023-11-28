package com.yami.app.navigationdemo.presentation.navigation

sealed class Screens(val name: String, val routeId: String) {
    object PostScreen: Screens("post", "post")
    object PostDetailScreen: Screens("postDetail", "postDetail/{postId}")

}