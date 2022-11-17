package com.mateuszgrabarski.habittracker.business.usecases.habit.add

import com.mateuszgrabarski.habittracker.business.data.models.habits.NewHabit
import com.mateuszgrabarski.habittracker.business.usecases.UseCaseResult
import com.mateuszgrabarski.habittracker.business.data.models.habits.add.HabitDurationDefinition
import com.mateuszgrabarski.habittracker.business.data.models.habits.add.NewHabitBaseDefinition
import kotlinx.coroutines.flow.Flow

interface StoreHabit {

    fun store(
        baseDefinition: NewHabitBaseDefinition,
        durationDefinition: HabitDurationDefinition
    ): Flow<UseCaseResult<NewHabit>>
}
