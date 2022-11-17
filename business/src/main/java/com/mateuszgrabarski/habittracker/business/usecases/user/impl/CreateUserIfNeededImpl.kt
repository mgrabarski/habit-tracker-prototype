package com.mateuszgrabarski.habittracker.business.usecases.user.impl

import com.mateuszgrabarski.habittracker.business.data.models.user.UserFactory
import com.mateuszgrabarski.habittracker.business.services.cache.CacheResult
import com.mateuszgrabarski.habittracker.business.services.cache.UserCacheDataSource
import com.mateuszgrabarski.habittracker.business.services.storage.UserStorage
import com.mateuszgrabarski.habittracker.business.usecases.UseCaseWithoutResult
import com.mateuszgrabarski.habittracker.business.usecases.UseCaseWithoutResult.GenericError
import com.mateuszgrabarski.habittracker.business.usecases.UseCaseWithoutResult.Success
import com.mateuszgrabarski.habittracker.business.usecases.user.CreateUserIfNeeded
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow

class CreateUserIfNeededImpl(
    private val userFactory: UserFactory,
    private val storage: UserStorage,
    private val cacheDataSource: UserCacheDataSource
) : CreateUserIfNeeded {

    override fun create(): Flow<UseCaseWithoutResult> = flow {
        val userId = storage.readActiveUserId().first()
        when {
            userId != null -> emit(Success)
            else -> {
                val user = userFactory.new()
                when (val result = cacheDataSource.createUser(user = user)) {
                    is CacheResult.Success -> {
                        storage.setActiveUser(user = user)
                        emit(Success)
                    }
                    is CacheResult.GenericError -> emit(GenericError(errorMessage = result.errorMessage))
                }
            }
        }
    }
}
