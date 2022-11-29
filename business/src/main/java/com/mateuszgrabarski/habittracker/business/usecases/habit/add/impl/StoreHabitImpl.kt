package com.mateuszgrabarski.habittracker.business.usecases.habit.add.impl

import com.mateuszgrabarski.habittracker.business.data.models.habits.NewHabit
import com.mateuszgrabarski.habittracker.business.data.models.habits.add.HabitDurationDefinition
import com.mateuszgrabarski.habittracker.business.data.models.habits.add.NewHabitBaseDefinition
import com.mateuszgrabarski.habittracker.business.data.models.habits.add.NewHabitFactory
import com.mateuszgrabarski.habittracker.business.services.cache.CacheResult
import com.mateuszgrabarski.habittracker.business.services.cache.HabitCacheDataSource
import com.mateuszgrabarski.habittracker.business.services.storage.UserStorage
import com.mateuszgrabarski.habittracker.business.usecases.Errors.USER_NOT_SET
import com.mateuszgrabarski.habittracker.business.usecases.UseCaseWithResult
import com.mateuszgrabarski.habittracker.business.usecases.UseCaseWithResult.GenericError
import com.mateuszgrabarski.habittracker.business.usecases.UseCaseWithResult.Success
import com.mateuszgrabarski.habittracker.business.usecases.habit.add.StoreHabit
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow

class StoreHabitImpl(
    private val storage: UserStorage,
    private val factory: NewHabitFactory,
    private val cache: HabitCacheDataSource
) : StoreHabit {

    override fun store(
        baseDefinition: NewHabitBaseDefinition,
        durationDefinition: HabitDurationDefinition
    ): Flow<UseCaseWithResult<NewHabit>> = flow {
        val userId = storage.readActiveUserId().first() ?: run {
            emit(GenericError(errorMessage = USER_NOT_SET))
            return@flow
        }

        val habit = factory.new(
            userId = userId,
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
