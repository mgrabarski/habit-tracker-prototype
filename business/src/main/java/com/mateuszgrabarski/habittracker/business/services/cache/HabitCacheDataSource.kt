package com.mateuszgrabarski.habittracker.business.services.cache

import com.mateuszgrabarski.habittracker.business.data.models.habits.NewHabit

interface HabitCacheDataSource {

    suspend fun insertNewHabit(habit: NewHabit): CacheResult<Long>
}
