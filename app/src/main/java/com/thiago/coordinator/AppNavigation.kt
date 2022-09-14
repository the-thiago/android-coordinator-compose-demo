package com.thiago.coordinator

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.thiago.coordinator.features.auth.createpassword.CreatePasswordScreen
import com.thiago.coordinator.features.auth.signup.SignupScreen

@Composable
internal fun AppNavigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "createPassword"
    ) {
        composable("createPassword") {
            CreatePasswordScreen()
        }
        composable("signup") {
            SignupScreen()
        }
    }
}