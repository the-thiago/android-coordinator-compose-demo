package com.thiago.coordinator.features.auth.createpassword

import androidx.lifecycle.ViewModel
import com.thiago.coordinator.navigation.flow.AuthCoordinator
import com.thiago.coordinator.navigation.flow.Auth
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CreatePasswordScreenViewModel @Inject constructor(
    private val authCoordinator: AuthCoordinator,
) : ViewModel() {

    fun navigate() {
        authCoordinator.onEvent(currentScreen = Auth.CreatePassword)
    }
}