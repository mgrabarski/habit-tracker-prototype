package com.mateuszgrabarski.habittracker.business.data.models.habits.add

import com.mateuszgrabarski.habittracker.business.data.models.habits.NewHabit
import com.mateuszgrabarski.habittracker.business.data.types.Id

class NewHabitFactory {

    fun new(
        userId: Id,
        baseDefinition: NewHabitBaseDefinition,
        durationDefinition: HabitDurationDefinition
    ) = NewHabit(
        ownerId = userId,
        id = Id.randomUUID(),
        name = baseDefinition.name,
        description = baseDefinition.description,
        icon = baseDefinition.toIconData(),
        type = baseDefinition.type,
        inputs = baseDefinition.inputs.toHabitTypeData(),
        startDate = durationDefinition.startDate,
        endDate = durationDefinition.endDate,
        duration = durationDefinition.duration,
        weekDays = durationDefinition.weekDays,
        monthDays = durationDefinition.monthDays
    )
}
