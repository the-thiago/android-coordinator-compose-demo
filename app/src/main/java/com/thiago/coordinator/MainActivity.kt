package com.thiago.coordinator

import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
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
import com.thiago.coordinator.navigation.NavigationCommand
import com.thiago.coordinator.navigation.NavigationType
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
                    is NavigationCommand.Navigate -> {
                        when (val type = command.type) {
                            NavigationType.NavigateTo -> {
                                navController.navigate(
                                    route = command.destination,
                                    navOptions = command.navOptions
                                )
                            }
                            is NavigationType.PopUpTo -> {
                                navController.popBackStack(
                                    command.destination,
                                    type.inclusive
                                )
                            }
                        }
                    }
                    is NavigationCommand.NavigateUp ->
                        navController.navigateUp()
                    is NavigationCommand.PopStackBack ->
                        navController.popBackStack()
                }
            }
        }
    }
}