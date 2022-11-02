package com.mateuszgrabarski.habittracker.ui.screens.habits

import androidx.compose.runtime.Composable
import com.mateuszgrabarski.habittracker.features.habits.add.ui.screen.AddNewHabitScreen
import com.mateuszgrabarski.habittracker.ui.screens.destinations.AddHabitDurationScreenDestination
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun AddHabitScreen(
    destinationsNavigator: DestinationsNavigator
) {
    AddNewHabitScreen(
        onMoveToDurationSet = {
            destinationsNavigator.navigate(direction = AddHabitDurationScreenDestination)
        }
    )
}
