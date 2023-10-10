package com.yami.app.listgriddemo.utils

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.ui.graphics.vector.ImageVector

sealed class DrawerScreens(val name: String, val icon: ImageVector, val routeId: String) {
    object List : DrawerScreens("List", Icons.Outlined.Home, "home")
    object HorizontalList : DrawerScreens("Horizontal List", Icons.Outlined.FavoriteBorder, "favorites")
    object Grid : DrawerScreens("Grid", Icons.Outlined.Notifications, "notifications")
    object StaggeredGrid : DrawerScreens("Staggered Grid", Icons.Outlined.AccountCircle, "profile")
}