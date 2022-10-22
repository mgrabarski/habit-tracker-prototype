package com.mateuszgrabarski.habittracker.features.habits.add.ui.topbar

import android.content.res.Configuration
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.mateuszgrabarski.habittracker.resources.R.string.add_habit_top_bar_title
import com.mateuszgrabarski.habittracker.resources.ui.components.topbar.NoActionsTopBar

@Composable
fun AddNewHabitTopBar() {
    NoActionsTopBar(title = add_habit_top_bar_title)
}

@Preview
@Composable
private fun AddNewHabitTopBarLight() {
    AddNewHabitTopBar()
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun AddNewHabitTopBarDark() {
    AddNewHabitTopBar()
}
