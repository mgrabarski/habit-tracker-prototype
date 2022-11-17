package com.mateuszgrabarski.habittracker.business.usecases.habit.add.impl

import com.mateuszgrabarski.habittracker.business.data.models.habits.NewHabit
import com.mateuszgrabarski.habittracker.business.data.models.habits.add.HabitDurationDefinition
import com.mateuszgrabarski.habittracker.business.data.models.habits.add.NewHabitBaseDefinition
import com.mateuszgrabarski.habittracker.business.data.models.habits.add.NewHabitFactory
import com.mateuszgrabarski.habittracker.business.services.cache.CacheResult
import com.mateuszgrabarski.habittracker.business.services.cache.HabitCacheDataSource
import com.mateuszgrabarski.habittracker.business.usecases.UseCaseResult
import com.mateuszgrabarski.habittracker.business.usecases.UseCaseResult.GenericError
import com.mateuszgrabarski.habittracker.business.usecases.UseCaseResult.Success
import com.mateuszgrabarski.habittracker.business.usecases.habit.add.StoreHabit
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class StoreHabitImpl(
    private val factory: NewHabitFactory,
    private val cache: HabitCacheDataSource
) : StoreHabit {

    override fun store(
        baseDefinition: NewHabitBaseDefinition,
        durationDefinition: HabitDurationDefinition
    ): Flow<UseCaseResult<NewHabit>> = flow {
        val habit = factory.new(
            baseDefinition = baseDefinition,
            durationDefinition = durationDefinition
        )

        when (val cacheResult = cache.insertNewHabit(habit = habit)) {
            is CacheResult.Success -> {
                emit(Success(value = habit))
            }
            is CacheResult.GenericError -> {
                emit(GenericError(errorMessage = cacheResult.errorMessage))
            }
        }
    }
}
