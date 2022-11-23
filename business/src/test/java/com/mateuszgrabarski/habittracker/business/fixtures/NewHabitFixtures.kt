package com.mateuszgrabarski.habittracker.business.fixtures

import com.mateuszgrabarski.habittracker.business.data.models.habits.HabitIconData
import com.mateuszgrabarski.habittracker.business.data.models.habits.HabitTypeData
import com.mateuszgrabarski.habittracker.business.data.models.habits.NewHabit
import com.mateuszgrabarski.habittracker.business.data.models.habits.options.HabitDuration
import com.mateuszgrabarski.habittracker.business.data.models.habits.options.HabitIcon
import com.mateuszgrabarski.habittracker.business.data.models.habits.options.HabitType
import com.mateuszgrabarski.habittracker.business.data.types.Id
import java.time.LocalDate

object NewHabitFixtures {

    fun anyNewHabit() = NewHabit(
        ownerId = Id.randomUUID(),
        id = Id.randomUUID(),
        name = "some name",
        description = "some description",
        icon = HabitIconData(
            icon = HabitIcon.Water,
            color = 1
        ),
        type = HabitType.None,
        inputs = HabitTypeData.NotNeededData,
        startDate = LocalDate.now(),
        endDate = null,
        duration = HabitDuration.getDefaultDuration(),
        weekDays = emptyList(),
        monthDays = emptyList()
    )
}
