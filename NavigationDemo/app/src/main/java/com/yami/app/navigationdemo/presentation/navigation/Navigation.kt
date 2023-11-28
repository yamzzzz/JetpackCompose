package com.yami.app.navigationdemo.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.yami.app.navigationdemo.presentation.ui.postdetail.PostDetailScreen
import com.yami.app.navigationdemo.presentation.ui.postdetail.PostDetailViewModel
import com.yami.app.navigationdemo.presentation.ui.postlist.PostListScreen
import com.yami.app.navigationdemo.presentation.ui.postlist.PostListViewModel

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screens.PostScreen.routeId) {
        composable(Screens.PostScreen.routeId) {
            val viewModel = hiltViewModel<PostListViewModel>()
            val selectedItem: (Int) -> Unit = { id: Int ->
                navController.navigate("postDetail/$id")
            }
            PostListScreen(viewModel, selectedItem)
        }
        composable(
            route = Screens.PostDetailScreen.routeId,
            arguments = listOf(navArgument(name = "postId") {
                type = NavType.IntType
            })
        ) {
            val viewModel = hiltViewModel<PostDetailViewModel>()
            PostDetailScreen(viewModel, it.arguments?.getInt("postId"))
        }
    }
}