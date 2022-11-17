package com.mateuszgrabarski.habittracker.business.services.cache.abstraction

import com.mateuszgrabarski.habittracker.business.data.models.habits.NewHabit

interface HabitDaoService {

    suspend fun insertNewHabit(habit: NewHabit): Long
}
