package com.mateuszgrabarski.habittracker.business.services.cache

import com.mateuszgrabarski.habittracker.business.data.models.user.User

interface UserCacheDataSource {

    suspend fun createUser(user: User): CacheResult<Long>
}
