package com.mateuszgrabarski.habittracker.business.usecases.user.impl

import com.mateuszgrabarski.habittracker.business.data.models.user.User
import com.mateuszgrabarski.habittracker.business.data.models.user.UserFactory
import com.mateuszgrabarski.habittracker.business.services.cache.CacheResult
import com.mateuszgrabarski.habittracker.business.services.cache.UserCacheDataSource
import com.mateuszgrabarski.habittracker.business.usecases.UseCaseResult
import com.mateuszgrabarski.habittracker.business.usecases.user.CreateUser
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class CreateUserImpl(
    private val userFactory: UserFactory,
    private val cacheDataSource: UserCacheDataSource
) : CreateUser {

    override fun create(): Flow<UseCaseResult<User>> = flow {
        val user = userFactory.new()
        when (val result = cacheDataSource.createUser(user = user)) {
            is CacheResult.Success -> emit(UseCaseResult.Success(value = user))
            is CacheResult.GenericError -> emit(UseCaseResult.GenericError(errorMessage = result.errorMessage))
        }
    }
}
