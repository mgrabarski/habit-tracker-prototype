package com.mateuszgrabarski.habittracker.business.data.models.habits

import com.mateuszgrabarski.habittracker.business.data.models.habits.options.HabitDuration
import com.mateuszgrabarski.habittracker.business.data.models.habits.options.HabitType
import com.mateuszgrabarski.habittracker.business.data.types.Id
import java.time.DayOfWeek
import java.time.LocalDate

data class NewHabit(
    val ownerId: Id,
    val id: Id,
    val name: String,
    val description: String,
    val icon: HabitIconData,
    val type: HabitType,
    val inputs: HabitTypeData,
    val startDate: LocalDate,
    val endDate: LocalDate?,
    val duration: HabitDuration,
    val weekDays: List<DayOfWeek>,
    val monthDays: List<Int>
)
