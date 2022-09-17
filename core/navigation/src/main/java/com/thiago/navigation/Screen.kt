package com.thiago.navigation

sealed class Screen(val route: String) {

    sealed class Auth(route: String) : Screen(route) {
        object CreateEmail : Auth(route = "CreateEmail")
        object CreatePassword : Auth(route = "CreatePassword")
        object Signup : Auth(route = "Signup")
    }

    sealed class Home(route: String) : Screen(route) {
        object List : Home(route = "List")
        object Details : Home(route = "Details")
    }
}