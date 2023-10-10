package com.yami.app.bottomnavigationdemo.widget

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.yami.app.bottomnavigationdemo.utils.BottomScreens

val bottomScreens = listOf(
    BottomScreens.Home,
    BottomScreens.Favorites,
    BottomScreens.Notifications,
    BottomScreens.Profile
)

@Composable
fun BottomNavigationBar(navController: NavController) {
    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = currentBackStackEntry?.destination
    NavigationBar {
        for (screen in bottomScreens) {

            NavigationBarItem(
                selected = currentDestination?.hierarchy?.any { it.route == screen.routeId } == true,
                onClick = {
                    navController.navigate(screen.routeId) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }

                },
                icon = { Icon(imageVector = screen.icon, contentDescription = screen.name) },
                label = { Text(text = screen.name) }
            )

        }
    }
}