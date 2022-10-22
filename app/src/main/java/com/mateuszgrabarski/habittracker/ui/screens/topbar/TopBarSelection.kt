package com.mateuszgrabarski.habittracker.ui.screens.topbar

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.mateuszgrabarski.habittracker.features.habits.add.ui.topbar.AddNewHabitTopBar
import com.mateuszgrabarski.habittracker.features.habits.list.ui.topbar.HabitsListTopBar
import com.mateuszgrabarski.habittracker.ui.screens.destinations.AddHabitScreenDestination
import com.mateuszgrabarski.habittracker.ui.screens.destinations.Destination
import com.mateuszgrabarski.habittracker.ui.screens.destinations.HabitsScreenDestination

@Composable
fun TopBarSelection(
    destination: Destination,
    navController: NavController
) {
    when (destination) {
        HabitsScreenDestination -> HabitsListTopBar(
            navigateToAddNewHabit = {
                navController.navigate(AddHabitScreenDestination.route)
            }
        )
        AddHabitScreenDestination -> AddNewHabitTopBar()
        else -> Unit
    }
}
