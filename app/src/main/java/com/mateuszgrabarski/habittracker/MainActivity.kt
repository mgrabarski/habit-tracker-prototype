package com.mateuszgrabarski.habittracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mateuszgrabarski.habittracker.SplashDestinations.HomeScreen
import com.mateuszgrabarski.habittracker.SplashDestinations.SplashScreen
import com.mateuszgrabarski.habittracker.resources.ui.theme.HabitTrackerTheme
import com.mateuszgrabarski.habittracker.ui.screens.HomeScreenView
import com.mateuszgrabarski.habittracker.ui.screens.SplashScreenView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HabitTrackerTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = SplashScreen.route) {
                    composable(route = SplashScreen.route) {
                        SplashScreenView {
                            navController.navigate(HomeScreen.route) {
                                popUpTo(SplashScreen.route) {
                                    inclusive = true
                                }
                            }
                        }
                    }

                    composable(route = HomeScreen.route) {
                        HomeScreenView()
                    }
                }
            }
        }
    }
}

private enum class SplashDestinations(val route: String) {
    SplashScreen("splash_screen"),
    HomeScreen("home_screen")
}
