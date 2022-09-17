package com.thiago.coordinator

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.thiago.auth.createemail.CreateEmailScreen
import com.thiago.auth.createpassword.CreatePasswordScreen
import com.thiago.auth.signup.SignupScreen
import com.thiago.home.details.DetailsScreen
import com.thiago.home.list.ListScreen
import com.thiago.navigation.Screen

@Composable
internal fun AppNavigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Auth.CreateEmail.route
    ) {
        addAuth()
        addHome()
    }
}

private fun NavGraphBuilder.addAuth() {
    composable(Screen.Auth.CreateEmail.route) {
        CreateEmailScreen()
    }
    composable(Screen.Auth.CreatePassword.route) {
        CreatePasswordScreen()
    }
    composable(Screen.Auth.Signup.route) {
        SignupScreen()
    }
}

private fun NavGraphBuilder.addHome() {
    composable(Screen.Home.List.route) {
        ListScreen()
    }
    composable(Screen.Home.Details.route) {
        DetailsScreen()
    }
}