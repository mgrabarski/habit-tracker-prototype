package com.mateuszgrabarski.habittracker.features.habits.add.ui.screen.duration.model.week

import com.mateuszgrabarski.habittracker.features.habits.add.ui.screen.duration.model.Day
import java.time.DayOfWeek

data class WeekDay(
    val day: Day,
    val selected: Boolean
) {

    fun reverse() = WeekDay(day = day, selected = selected.not())

    companion object {

        fun generateNotSelectedWeekDays() = DayOfWeek.values()
            .toList()
            .map {
                WeekDay(
                    day = Day(
                        day = it
                    ),
                    selected = false
                )
            }
    }
}
