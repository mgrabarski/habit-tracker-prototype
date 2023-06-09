package com.mateuszgrabarski.habittracker.business.usecases.habit.add

import com.mateuszgrabarski.habittracker.business.data.models.habits.Habit
import com.mateuszgrabarski.habittracker.business.data.models.habits.add.HabitDurationDefinition
import com.mateuszgrabarski.habittracker.business.data.models.habits.add.NewHabitBaseDefinition
import com.mateuszgrabarski.habittracker.business.usecases.UseCaseWithResult
import kotlinx.coroutines.flow.Flow

interface StoreHabit {

    fun store(
        baseDefinition: NewHabitBaseDefinition,
        durationDefinition: HabitDurationDefinition
    ): Flow<UseCaseWithResult<Habit>>
}
