package com.mateuszgrabarski.habittracker.business.services.cache.impl

import com.mateuszgrabarski.habittracker.business.data.models.user.User
import com.mateuszgrabarski.habittracker.business.services.cache.CacheResult
import com.mateuszgrabarski.habittracker.business.services.cache.UserCacheDataSource
import com.mateuszgrabarski.habittracker.business.services.cache.abstraction.UserDaoService

class UserCacheDataSourceImpl(
    private val daoService: UserDaoService
) : UserCacheDataSource {

    override suspend fun createUser(user: User): CacheResult<Long> {
        val numberOfInserts = daoService.insertUser(user = user)
        return when {
            numberOfInserts > 0 -> CacheResult.Success(value = numberOfInserts)
            else -> CacheResult.GenericError(errorMessage = "cache error")
        }
    }
}
