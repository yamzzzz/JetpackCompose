package com.yami.app.qrscannerdemo.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.yami.app.qrscannerdemo.screens.DetailScreen
import com.yami.app.qrscannerdemo.screens.QRScanScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screens.HomeScreen.routeId) {
        composable(Screens.HomeScreen.routeId) {
            val qrScanned: (String) -> Unit = { qrString ->
                navController.navigate(Screens.DetailScreen.routePrefix.plus(qrString))
            }
            QRScanScreen(navController = navController, onScanDone = qrScanned)
        }

        composable(
            route = Screens.DetailScreen.routeId,
            arguments = listOf(navArgument(name = "qrString") {
                type = NavType.StringType
            })
        ) {
            DetailScreen(
                qrString = it.arguments?.getString("qrString") ?: "",
                navController = navController
            )

        }

    }
}