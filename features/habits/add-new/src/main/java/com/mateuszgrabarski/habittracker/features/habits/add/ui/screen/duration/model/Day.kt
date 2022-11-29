package com.mateuszgrabarski.habittracker.features.habits.add.ui.screen.duration.model

import java.time.DayOfWeek
import java.time.format.TextStyle
import java.util.Locale

data class Day(
    private val day: DayOfWeek
) {

    val name: String
        get() = day.getDisplayName(
            TextStyle.SHORT,
            Locale.getDefault()
        )

    val number: Int
        get() = day.value
}
