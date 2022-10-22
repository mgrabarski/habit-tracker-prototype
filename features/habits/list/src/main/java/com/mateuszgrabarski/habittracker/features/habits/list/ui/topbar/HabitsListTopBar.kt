package com.mateuszgrabarski.habittracker.features.habits.list.ui.topbar

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import com.mateuszgrabarski.habittracker.resources.R.drawable.ic_add
import com.mateuszgrabarski.habittracker.resources.R.string.add_habit_action
import com.mateuszgrabarski.habittracker.resources.ui.components.TopAppBarActionButton
import com.mateuszgrabarski.habittracker.resources.ui.theme.topBarBackground
import com.mateuszgrabarski.habittracker.resources.ui.theme.topBarContent

@Composable
fun HabitsListTopBar(
    navigateToAddNewHabit: () -> Unit
) {
    TopAppBar(
        backgroundColor = MaterialTheme.colors.topBarBackground,
        contentColor = MaterialTheme.colors.topBarContent,
        title = {
            Text(text = "Habits list")
        },
        actions = {
            TopAppBarActionButton(
                icon = ic_add,
                contentDescription = add_habit_action,
                onClick = navigateToAddNewHabit
            )
        }
    )
}
