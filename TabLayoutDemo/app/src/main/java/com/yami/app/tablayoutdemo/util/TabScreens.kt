package com.yami.app.tablayoutdemo.util

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.ui.graphics.vector.ImageVector

sealed class TabScreens(val name: String, val selectedIcon: ImageVector, val unSelectedIcon: ImageVector){
    object HomeTab : TabScreens("Home", Icons.Filled.Home, Icons.Outlined.Home)
    object NotificationTab : TabScreens("Notification", Icons.Filled.Notifications, Icons.Outlined.Notifications)
    object ProfileTab : TabScreens("Profile", Icons.Filled.AccountCircle, Icons.Outlined.AccountCircle)
}