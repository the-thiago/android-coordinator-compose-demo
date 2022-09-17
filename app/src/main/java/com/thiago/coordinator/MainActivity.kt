package com.thiago.coordinator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.thiago.coordinator.ui.theme.CoordinatorTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    lateinit var navController: NavHostController

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoordinatorTheme {
                navController = rememberNavController()
                observeAndNavigate(viewModel, navController)
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    AppNavigation(navController)
                }
            }
        }
    }

    private fun observeAndNavigate(
        viewModel: MainViewModel,
        navController: NavHostController
    ) {
        lifecycleScope.launch {
            viewModel.navigationManager.commands.collect { command ->
                when (command) {
                    is com.thiago.navigation.NavigationCommand.Navigate -> {
                        when (val type = command.type) {
                            com.thiago.navigation.NavigationType.NavigateTo -> {
                                navController.navigate(
                                    route = command.destination,
                                    navOptions = command.navOptions
                                )
                            }
                            is com.thiago.navigation.NavigationType.PopUpTo -> {
                                navController.popBackStack(
                                    command.destination,
                                    type.inclusive
                                )
                            }
                        }
                    }
                    is com.thiago.navigation.NavigationCommand.NavigateUp ->
                        navController.navigateUp()
                    is com.thiago.navigation.NavigationCommand.PopStackBack ->
                        navController.popBackStack()
                }
            }
        }
    }
}