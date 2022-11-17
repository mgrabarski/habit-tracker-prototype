package com.mateuszgrabarski.habittracker.business.services.cache.abstraction

import com.mateuszgrabarski.habittracker.business.data.models.user.User

interface UserDaoService {

    suspend fun insertUser(user: User): Long
}
