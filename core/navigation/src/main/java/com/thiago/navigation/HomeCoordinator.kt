package com.thiago.navigation

import javax.inject.Inject

class HomeCoordinator @Inject constructor(
    navigationManager: NavigationManager
) : Coordinator(navigationManager) {

    override fun onStart() {
        navigationManager.navigate(Screen.Home.List.route)
    }

    override fun onEvent(event: CoordinatorEvent) {
        when (event as HomeCoordinatorEvent) {
            HomeCoordinatorEvent.Details -> {
                navigationManager.navigate(Screen.Home.Details.route)
            }
        }
    }
}

sealed class HomeCoordinatorEvent : CoordinatorEvent {
    object Details : HomeCoordinatorEvent()
}