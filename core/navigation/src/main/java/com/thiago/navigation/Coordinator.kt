package com.thiago.navigation

abstract class Coordinator(
    val navigationManager: NavigationManager,
) {

    abstract fun onStart()

    abstract fun onEvent(event: CoordinatorEvent)
}

interface CoordinatorEvent