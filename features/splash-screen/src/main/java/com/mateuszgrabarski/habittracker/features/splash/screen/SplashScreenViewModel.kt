package com.mateuszgrabarski.habittracker.features.splash.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mateuszgrabarski.habittracker.business.usecases.user.CreateUserIfNeeded
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class SplashScreenViewModel(
    private val createUser: CreateUserIfNeeded
) : ViewModel() {

    fun init() {
        viewModelScope.launch {
            createUser.create().first()
        }
    }
}
