package com.yami.app.bottomnavigationdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.yami.app.bottomnavigationdemo.screens.FavoriteScreen
import com.yami.app.bottomnavigationdemo.screens.HomeScreen
import com.yami.app.bottomnavigationdemo.screens.NotificationScreen
import com.yami.app.bottomnavigationdemo.screens.ProfileScreen
import com.yami.app.bottomnavigationdemo.ui.theme.BottomNavigationDemoTheme
import com.yami.app.bottomnavigationdemo.utils.BottomScreens
import com.yami.app.bottomnavigationdemo.widget.BottomNavigationBar

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BottomNavigationDemoTheme {
                MainScreen()
            }
        }
    }


}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(modifier = Modifier.fillMaxSize(),
        bottomBar = { BottomNavigationBar(navController) }) { innerPadding ->
        NavHost(navController = navController, startDestination = BottomScreens.Home.routeId) {
            composable(BottomScreens.Home.routeId) { HomeScreen() }
            composable(BottomScreens.Favorites.routeId) { FavoriteScreen() }
            composable(BottomScreens.Notifications.routeId) { NotificationScreen() }
            composable(BottomScreens.Profile.routeId) { ProfileScreen() }
        }

    }
}


