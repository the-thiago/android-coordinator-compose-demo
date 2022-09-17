package com.thiago.home.list

import androidx.lifecycle.ViewModel
import com.thiago.navigation.HomeCoordinator
import com.thiago.navigation.HomeCoordinatorEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    private val homeCoordinator: HomeCoordinator
) : ViewModel() {

    fun navigate() {
        homeCoordinator.onEvent(event = HomeCoordinatorEvent.Details)
    }
}