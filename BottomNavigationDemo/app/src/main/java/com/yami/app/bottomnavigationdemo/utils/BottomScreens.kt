package com.yami.app.bottomnavigationdemo.utils

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Star
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomScreens(val name: String, val icon: ImageVector, val routeId: String) {
    object Home : BottomScreens("Home", Icons.Outlined.Home, "home")
    object Favorites : BottomScreens("Favorites", Icons.Outlined.FavoriteBorder, "favorites")
    object Notifications : BottomScreens("Notifications", Icons.Outlined.Notifications, "notifications")
    object Profile : BottomScreens("Profile", Icons.Outlined.AccountCircle, "profile")

}