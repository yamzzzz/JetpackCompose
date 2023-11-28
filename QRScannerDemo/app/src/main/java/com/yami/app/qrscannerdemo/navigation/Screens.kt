package com.yami.app.qrscannerdemo.navigation

sealed class Screens(val name: String, val routeId: String, val routePrefix: String? = null) {
    object HomeScreen : Screens("home", "home")
    object DetailScreen : Screens("detail", "detail/{qrString}", "detail/")

}