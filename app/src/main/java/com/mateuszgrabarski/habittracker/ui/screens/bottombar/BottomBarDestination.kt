package com.mateuszgrabarski.habittracker.ui.screens.bottombar

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.mateuszgrabarski.habittracker.resources.R
import com.mateuszgrabarski.habittracker.ui.screens.destinations.Destination
import com.mateuszgrabarski.habittracker.ui.screens.destinations.HabitsScreenDestination
import com.mateuszgrabarski.habittracker.ui.screens.destinations.NotesScreenDestination
import com.mateuszgrabarski.habittracker.ui.screens.destinations.StatsScreenDestination
import com.mateuszgrabarski.habittracker.ui.screens.destinations.TaskScreenDestination

enum class BottomBarDestination(
    val direction: Destination,
    @DrawableRes val icon: Int,
    @StringRes val label: Int
) {
    Habits(HabitsScreenDestination, R.drawable.ic_bottom_bar_habits, R.string.bottomBar1),
    Stats(StatsScreenDestination, R.drawable.ic_bottom_bar_stats, R.string.bottomBar2),
    Notes(NotesScreenDestination, R.drawable.ic_bottom_bar_notes, R.string.bottomBar3),
    Tasks(TaskScreenDestination, R.drawable.ic_bottom_bar_tasks, R.string.bottomBar4)
}
