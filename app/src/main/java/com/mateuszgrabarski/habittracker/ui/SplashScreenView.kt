package com.mateuszgrabarski.habittracker.ui

import androidx.compose.runtime.Composable
import com.mateuszgrabarski.habittracker.features.splash.screen.SplashScreen
import com.mateuszgrabarski.habittracker.ui.destinations.FirstScreenDestination
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@RootNavGraph(start = true)
@Destination
@Composable
fun SplashScreenView(
    navigator: DestinationsNavigator
) {
    SplashScreen(
        navigateToHome = {
            navigator.navigate(FirstScreenDestination)
        }
    )
}
