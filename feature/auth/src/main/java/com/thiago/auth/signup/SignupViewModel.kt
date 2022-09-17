package com.thiago.auth.signup

import androidx.lifecycle.ViewModel
import com.thiago.navigation.HomeCoordinator
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignupViewModel @Inject constructor(
    private val homeCoordinator: HomeCoordinator,
) : ViewModel() {

    fun navigate() {
        homeCoordinator.onStart()
    }
}