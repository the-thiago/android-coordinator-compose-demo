package com.thiago.auth.createpassword

import androidx.lifecycle.ViewModel
import com.thiago.navigation.AuthCoordinator
import com.thiago.navigation.AuthCoordinatorEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CreatePasswordViewModel @Inject constructor(
    private val authCoordinator: AuthCoordinator,
) : ViewModel() {

    fun navigate() {
        authCoordinator.onEvent(event = AuthCoordinatorEvent.Signup)
    }
}