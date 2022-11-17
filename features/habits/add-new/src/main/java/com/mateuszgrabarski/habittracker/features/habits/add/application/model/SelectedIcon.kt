package com.mateuszgrabarski.habittracker.features.habits.add.application.model

import com.mateuszgrabarski.habittracker.business.habits.HabitIcon

data class SelectedIcon(
    val icon: HabitIcon,
    val color: Int
)
