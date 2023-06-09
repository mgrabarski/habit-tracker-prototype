package com.mateuszgrabarski.habittracker.framework.database.services

import com.mateuszgrabarski.habittracker.business.data.models.habits.Habit
import com.mateuszgrabarski.habittracker.business.data.models.habits.HabitIconData
import com.mateuszgrabarski.habittracker.business.data.models.habits.HabitTypeData
import com.mateuszgrabarski.habittracker.business.services.cache.abstraction.HabitDaoService
import com.mateuszgrabarski.habittracker.framework.database.application.LocalTimeProvider
import com.mateuszgrabarski.habittracker.framework.database.daos.HabitAndDetailsRelationDao
import com.mateuszgrabarski.habittracker.framework.database.entities.relations.HabitAndDetailsRelation
import com.mateuszgrabarski.habittracker.framework.database.mappers.fromBusinessToEntitiesRelations
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

internal class LocalHabitDaoService(
    private val timeProvider: LocalTimeProvider,
    private val dao: HabitAndDetailsRelationDao
) : HabitDaoService {

    override suspend fun insertNewHabit(habit: Habit): Long {
        dao.insert(
            habit = habit.fromBusinessToEntitiesRelations(
                createDate = timeProvider.now()
            )
        )
        return 1
    }

    override fun getAll(): Flow<List<Habit>> = dao.getAll().map { habits ->
        habits.map {
            it.toHabit()
        }
    }
}

private fun HabitAndDetailsRelation.toHabit() = Habit(
    ownerId = habit.userId,
    id = habit.id,
    name = habit.name,
    description = habit.description,
    icon = HabitIconData(
        icon = habit.icon.image,
        color = habit.icon.color
    ),
    type = typeDetails.type,
    inputs = HabitTypeData.NotNeededData,
    startDate = duration.startDate,
    endDate = duration.endDate,
    duration = duration.duration,
    weekDays = duration.weekDays,
    monthDays = duration.monthDays
)
