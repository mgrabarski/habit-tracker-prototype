package com.mateuszgrabarski.habittracker.business.services.storage

import com.mateuszgrabarski.habittracker.business.data.models.user.User
import com.mateuszgrabarski.habittracker.business.data.types.Id
import kotlinx.coroutines.flow.Flow

interface UserStorage {

    suspend fun setActiveUser(user: User)
    fun readActiveUserId(): Flow<Id?>
}
