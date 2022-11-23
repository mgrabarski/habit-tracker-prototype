package com.mateuszgrabarski.habittracker.business.fixtures

import com.mateuszgrabarski.habittracker.business.data.models.habits.add.HabitDurationDefinition
import com.mateuszgrabarski.habittracker.business.data.models.habits.options.HabitDuration
import java.time.LocalDate

object HabitDurationDefinitionFixtures {

    fun any() = HabitDurationDefinition(
        startDate = LocalDate.now(),
        endDate = null,
        duration = HabitDuration.getDefaultDuration(),
        weekDays = emptyList(),
        monthDays = emptyList()
    )
}
