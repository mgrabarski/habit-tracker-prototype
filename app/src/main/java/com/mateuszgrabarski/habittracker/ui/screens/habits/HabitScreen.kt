package com.mateuszgrabarski.habittracker.ui.screens.habits

import androidx.compose.runtime.Composable
import com.mateuszgrabarski.habittracker.features.habits.list.ui.screens.HabitsListScreen
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph

@RootNavGraph(start = true)
@Destination
@Composable
fun HabitsScreen() {
    HabitsListScreen()
}
