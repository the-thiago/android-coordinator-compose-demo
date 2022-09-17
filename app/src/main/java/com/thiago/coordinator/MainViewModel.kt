package com.thiago.coordinator

import androidx.lifecycle.ViewModel
import com.thiago.navigation.NavigationManager
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    val navigationManager: NavigationManager,
) : ViewModel()