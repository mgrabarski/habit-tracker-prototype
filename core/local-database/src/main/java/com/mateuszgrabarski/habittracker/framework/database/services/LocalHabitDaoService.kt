package com.mateuszgrabarski.habittracker.framework.database.services

import com.mateuszgrabarski.habittracker.business.data.models.habits.NewHabit
import com.mateuszgrabarski.habittracker.business.services.cache.abstraction.HabitDaoService
import com.mateuszgrabarski.habittracker.framework.database.application.LocalTimeProvider
import com.mateuszgrabarski.habittracker.framework.database.daos.HabitAndDetailsRelationDao
import com.mateuszgrabarski.habittracker.framework.database.mappers.fromBusinessToEntitiesRelations

internal class LocalHabitDaoService(
    private val timeProvider: LocalTimeProvider,
    private val dao: HabitAndDetailsRelationDao
) : HabitDaoService {

    override suspend fun insertNewHabit(habit: NewHabit): Long {
        dao.insert(
            habit = habit.fromBusinessToEntitiesRelations(
                createDate = timeProvider.now()
            )
        )
        return 1
    }
}
