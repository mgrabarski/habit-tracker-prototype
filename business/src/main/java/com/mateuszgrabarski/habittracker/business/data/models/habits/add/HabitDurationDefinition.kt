package com.mateuszgrabarski.habittracker.business.data.models.habits.add

import com.mateuszgrabarski.habittracker.business.data.models.habits.options.HabitDuration
import java.time.DayOfWeek
import java.time.LocalDate

data class HabitDurationDefinition(
    val startDate: LocalDate,
    val endDate: LocalDate?,
    val duration: HabitDuration,
    val weekDays: List<DayOfWeek>,
    val monthDays: List<Int>
)
