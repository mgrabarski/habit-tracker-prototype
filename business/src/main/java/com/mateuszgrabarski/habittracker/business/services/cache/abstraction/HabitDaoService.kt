package com.mateuszgrabarski.habittracker.business.services.cache.abstraction

import com.mateuszgrabarski.habittracker.business.data.models.habits.Habit
import kotlinx.coroutines.flow.Flow

interface HabitDaoService {

    suspend fun insertNewHabit(habit: Habit): Long
    fun getAll(): Flow<List<Habit>>
}
