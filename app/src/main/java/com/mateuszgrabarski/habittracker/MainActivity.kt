package com.mateuszgrabarski.habittracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.mateuszgrabarski.habittracker.resources.ui.theme.HabitTrackerTheme
import com.mateuszgrabarski.habittracker.ui.NavGraphs
import com.ramcosta.composedestinations.DestinationsNavHost

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HabitTrackerTheme {
                DestinationsNavHost(navGraph = NavGraphs.root)
            }
        }
    }
}
