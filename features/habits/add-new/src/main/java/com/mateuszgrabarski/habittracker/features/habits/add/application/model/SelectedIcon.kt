package com.mateuszgrabarski.habittracker.features.habits.add.application.model

import com.mateuszgrabarski.habittracker.business.data.models.habits.options.HabitIcon

data class SelectedIcon(
    val icon: HabitIcon,
    val color: Int
)
