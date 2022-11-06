package com.mateuszgrabarski.habittracker.features.habits.add.ui.screen

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.mateuszgrabarski.habittracker.business.habits.add.NewHabitBaseDefinition

@Composable
fun AddNewHabitDurationScreen(habitBaseDefinition: NewHabitBaseDefinition) {
    Log.d("AddNewHabitDurationScreen", "AddNewHabitDurationScreen: $habitBaseDefinition")
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Red)
    )
}
