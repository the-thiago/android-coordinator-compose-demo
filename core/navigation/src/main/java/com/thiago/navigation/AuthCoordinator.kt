package com.thiago.navigation

import javax.inject.Inject

class AuthCoordinator @Inject constructor(
    navigationManager: NavigationManager
) : Coordinator(navigationManager) {

    override fun onStart() {
        navigationManager.navigate(Screen.Auth.Signup.route)
    }

    override fun onEvent(event: CoordinatorEvent) {
        when (event as AuthCoordinatorEvent) {
            AuthCoordinatorEvent.CreatePassword -> {
                navigationManager.navigate(Screen.Auth.CreatePassword.route)
            }
            AuthCoordinatorEvent.Signup -> {
                navigationManager.navigate(Screen.Auth.Signup.route)
            }
        }
    }
}

sealed class AuthCoordinatorEvent : CoordinatorEvent {
    object CreatePassword : AuthCoordinatorEvent()
    object Signup : AuthCoordinatorEvent()
}

sealed class Screen(val route: String) {

    sealed class Auth(route: String) : Screen(route) {
        object CreateEmail : Auth(route = "CreateEmail")
        object CreatePassword : Auth(route = "CreatePassword")
        object Signup : Auth(route = "Signup")
    }
}