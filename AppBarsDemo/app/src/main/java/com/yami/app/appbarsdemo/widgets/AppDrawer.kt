package com.yami.app.appbarsdemo.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.yami.app.appbarsdemo.screens.ContactScreen
import com.yami.app.appbarsdemo.screens.FavoriteScreen
import com.yami.app.appbarsdemo.screens.HomeScreen
import com.yami.app.appbarsdemo.screens.NotificationScreen
import com.yami.app.appbarsdemo.screens.ProfileScreen
import com.yami.app.appbarsdemo.utils.DrawerScreens
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppDrawer() {
    val navController = rememberNavController()
    val scope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = currentBackStackEntry?.destination

    val drawerScreens = listOf(
        DrawerScreens.Home,
        DrawerScreens.Favorites,
        DrawerScreens.Notifications,
        DrawerScreens.Contact,
        DrawerScreens.Profile
    )
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                //Header
                drawHeader()
                //Drawer Content
                drawerScreens.forEach { screen ->
                    NavigationDrawerItem(
                        label = { Text(text = screen.name) },
                        icon = {
                            Icon(
                                imageVector = screen.icon,
                                contentDescription = screen.name
                            )
                        },
                        selected = currentDestination?.hierarchy?.any { it.route == screen.routeId } == true,
                        onClick = {
                            scope.launch {
                                drawerState.close()
                                navController.navigate(screen.routeId) {
                                    popUpTo(navController.graph.findStartDestination().id) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            }
                        })
                }
            }
        }) {
        NavHost(navController = navController, startDestination = DrawerScreens.Home.routeId) {
            composable(DrawerScreens.Home.routeId) {
                HomeScreen(
                    drawerState,
                    scope,
                    DrawerScreens.Home.name
                )
            }
            composable(DrawerScreens.Favorites.routeId) {
                FavoriteScreen(
                    drawerState,
                    scope,
                    DrawerScreens.Favorites.name
                )
            }
            composable(DrawerScreens.Notifications.routeId) {
                NotificationScreen(
                    drawerState,
                    scope,
                    DrawerScreens.Notifications.name
                )
            }
            composable(DrawerScreens.Contact.routeId) {
                ContactScreen()
            }
            composable(DrawerScreens.Profile.routeId) {
                ProfileScreen(
                    drawerState,
                    scope,
                    DrawerScreens.Profile.name
                )
            }
        }
    }

}


@Composable
fun drawHeader() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                imageVector = Icons.Filled.AccountCircle,
                modifier = Modifier.size(150.dp),
                contentScale = ContentScale.Crop,
                contentDescription = null
            )

            Text(
                text = "Yami"
            )
        }
    }
    Spacer(modifier = Modifier.height(20.dp))
}
