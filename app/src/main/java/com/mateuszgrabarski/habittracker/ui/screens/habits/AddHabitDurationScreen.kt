package com.mateuszgrabarski.habittracker.ui.screens.habits

import androidx.compose.runtime.Composable
import com.mateuszgrabarski.habittracker.business.data.models.habits.add.NewHabitBaseDefinition
import com.mateuszgrabarski.habittracker.features.habits.add.ui.screen.AddNewHabitDurationScreen
import com.mateuszgrabarski.habittracker.ui.screens.destinations.HabitsScreenDestination
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun AddHabitDurationScreen(
    habitBaseDefinition: NewHabitBaseDefinition,
    destinationsNavigator: DestinationsNavigator
) {
    AddNewHabitDurationScreen(
        habitBaseDefinition = habitBaseDefinition,
        moveBackToList = {
            destinationsNavigator.navigate(HabitsScreenDestination) {
                popUpTo(HabitsScreenDestination.route) {
                    inclusive = true
                }
            }
        }
    )
}
