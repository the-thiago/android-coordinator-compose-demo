package com.thiago.auth.createemail

import androidx.lifecycle.ViewModel
import com.thiago.navigation.AuthCoordinator
import com.thiago.navigation.AuthCoordinatorEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CreateEmailViewModel @Inject constructor(
    private val authCoordinator: AuthCoordinator,
) : ViewModel() {

    fun navigate() {
        authCoordinator.onEvent(event = AuthCoordinatorEvent.CreatePassword)
    }
}