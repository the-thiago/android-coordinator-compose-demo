package com.thiago.coordinator.navigation.flow

import com.thiago.coordinator.navigation.Coordinator
import com.thiago.coordinator.navigation.NavigationManager
import com.thiago.coordinator.navigation.Screen
import javax.inject.Inject

class AuthCoordinator @Inject constructor(
    navigationManager: NavigationManager
) : Coordinator(navigationManager) {

    override fun onStart() {
        navigationManager.navigate(Auth.Signup.route)
    }

    override fun onEvent(currentScreen: Screen) {
        when (currentScreen as Auth) {
            Auth.CreatePassword -> navigationManager.navigate(Auth.Signup.route)
            Auth.Signup -> navigationManager.navigate(Auth.CreatePassword.route)
        }
    }
}

sealed class Auth(override val route: String) : Screen {
    object CreatePassword : Auth(route = "createPassword")
    object Signup : Auth(route = "signup")
}