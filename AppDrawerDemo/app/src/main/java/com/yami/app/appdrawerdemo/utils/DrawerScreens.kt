package com.yami.app.appdrawerdemo.utils

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.ui.graphics.vector.ImageVector

sealed class DrawerScreens(val name: String, val icon: ImageVector, val routeId: String) {
    object Home : DrawerScreens("Home", Icons.Outlined.Home, "home")
    object Favorites : DrawerScreens("Favorites", Icons.Outlined.FavoriteBorder, "favorites")
    object Notifications : DrawerScreens("Notifications", Icons.Outlined.Notifications, "notifications")
    object Profile : DrawerScreens("Profile", Icons.Outlined.AccountCircle, "profile")
}