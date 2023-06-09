package com.mateuszgrabarski.habittracker.business.services.cache

import com.mateuszgrabarski.habittracker.business.data.models.habits.Habit
import kotlinx.coroutines.flow.Flow

interface HabitCacheDataSource {

    suspend fun insertNewHabit(habit: Habit): CacheResult<Long>

    fun loadAll(): Flow<List<Habit>>
}
