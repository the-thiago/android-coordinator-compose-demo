package com.thiago.coordinator

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.thiago.coordinator.features.first.FirstScreen
import com.thiago.coordinator.features.second.SecondScreen

@Composable
internal fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "first"
    ) {
        composable("first") {
            FirstScreen {
                navController.navigate("second")
            }
        }
        composable("second") {
            SecondScreen()
        }
    }
}