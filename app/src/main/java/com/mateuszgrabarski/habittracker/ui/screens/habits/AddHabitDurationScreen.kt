package com.mateuszgrabarski.habittracker.ui.screens.habits

import androidx.compose.runtime.Composable
import com.mateuszgrabarski.habittracker.business.habits.add.NewHabitBaseDefinition
import com.mateuszgrabarski.habittracker.features.habits.add.ui.screen.AddNewHabitDurationScreen
import com.ramcosta.composedestinations.annotation.Destination

@Destination
@Composable
fun AddHabitDurationScreen(
    habitBaseDefinition: NewHabitBaseDefinition
) {
    AddNewHabitDurationScreen(
        habitBaseDefinition = habitBaseDefinition
    )
}
