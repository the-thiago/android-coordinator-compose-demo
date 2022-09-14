package com.thiago.coordinator.navigation

abstract class Coordinator(
    val navigationManager: NavigationManager,
) {

    abstract fun onStart()

    abstract fun onEvent(currentScreen: Screen)
}