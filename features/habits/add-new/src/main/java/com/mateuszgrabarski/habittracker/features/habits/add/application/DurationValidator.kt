package com.mateuszgrabarski.habittracker.features.habits.add.application

import com.mateuszgrabarski.habittracker.business.habits.HabitDuration
import com.mateuszgrabarski.habittracker.features.habits.add.ui.screen.duration.model.month.MonthDay
import com.mateuszgrabarski.habittracker.features.habits.add.ui.screen.duration.model.week.WeekDay

class DurationValidator {

    fun validate(
        type: HabitDuration,
        weekDays: List<WeekDay>,
        monthDays: List<MonthDay>
    ): Boolean = when (type) {
        HabitDuration.DaysInWeek -> weekDays.any { it.selected }
        HabitDuration.DaysInMonth -> monthDays.any { it.selected }
        else -> true
    }
}
