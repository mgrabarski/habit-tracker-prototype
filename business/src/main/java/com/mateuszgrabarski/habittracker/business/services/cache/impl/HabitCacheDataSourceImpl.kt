package com.mateuszgrabarski.habittracker.business.services.cache.impl

import com.mateuszgrabarski.habittracker.business.data.models.habits.Habit
import com.mateuszgrabarski.habittracker.business.services.cache.CacheResult
import com.mateuszgrabarski.habittracker.business.services.cache.CacheResult.GenericError
import com.mateuszgrabarski.habittracker.business.services.cache.CacheResult.Success
import com.mateuszgrabarski.habittracker.business.services.cache.HabitCacheDataSource
import com.mateuszgrabarski.habittracker.business.services.cache.abstraction.HabitDaoService
import com.mateuszgrabarski.habittracker.business.usecases.Errors.CACHE_ERROR
import kotlinx.coroutines.flow.Flow

class HabitCacheDataSourceImpl(
    private val dao: HabitDaoService
) : HabitCacheDataSource {

    override suspend fun insertNewHabit(habit: Habit): CacheResult<Long> {
        val numberOfInserts = dao.insertNewHabit(habit = habit)
        return when {
            numberOfInserts > 0 -> Success(value = numberOfInserts)
            else -> GenericError(errorMessage = CACHE_ERROR)
        }
    }

    override fun loadAll(): Flow<List<Habit>> = dao.getAll()
}
