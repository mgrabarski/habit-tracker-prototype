package com.mateuszgrabarski.habittracker.framework.database.mappers

import com.mateuszgrabarski.habittracker.business.data.models.habits.HabitTypeData
import com.mateuszgrabarski.habittracker.business.data.models.habits.NewHabit
import com.mateuszgrabarski.habittracker.business.data.types.Id
import com.mateuszgrabarski.habittracker.framework.database.entities.HabitDurationEntity
import com.mateuszgrabarski.habittracker.framework.database.entities.HabitEntity
import com.mateuszgrabarski.habittracker.framework.database.entities.HabitIconEntity
import com.mateuszgrabarski.habittracker.framework.database.entities.HabitTypeDetailsEntity
import com.mateuszgrabarski.habittracker.framework.database.entities.NumberDataEntity
import com.mateuszgrabarski.habittracker.framework.database.entities.TimeDataEntity
import com.mateuszgrabarski.habittracker.framework.database.entities.relations.HabitAndDetailsRelation

fun NewHabit.fromBusinessToEntitiesRelations() = HabitAndDetailsRelation(
    habit = HabitEntity(
        id = id,
        name = name,
        description = description,
        icon = HabitIconEntity(
            image = icon.icon,
            color = icon.color
        ),
        userId = ownerId
    ),
    typeDetails = HabitTypeDetailsEntity(
        id = Id.randomUUID(),
        type = type,
        numberData = inputs.toNumberData(),
        timeData = inputs.toTimeData(),
        habitId = id
    ),
    duration = HabitDurationEntity(
        id = Id.randomUUID(),
        startDate = startDate,
        endDate = endDate,
        duration = duration,
        weekDays = weekDays,
        monthDays = monthDays,
        habitId = id
    )
)

private fun HabitTypeData.toTimeData() = when (this) {
    is HabitTypeData.TimeData -> TimeDataEntity(
        hours = hours,
        minutes = minutes
    )
    else -> null
}

private fun HabitTypeData.toNumberData() = when (this) {
    is HabitTypeData.NumberData -> NumberDataEntity(
        goal = goal,
        unit = unit
    )
    else -> null
}
