package com.mateuszgrabarski.habittracker.ui.screens

import androidx.compose.runtime.Composable
import com.mateuszgrabarski.habittracker.features.splash.screen.SplashScreen

@Composable
fun SplashScreenView(navigateToHome: () -> Unit) {
    SplashScreen(
        navigateToHome = {
            navigateToHome()
        },
    )
}
