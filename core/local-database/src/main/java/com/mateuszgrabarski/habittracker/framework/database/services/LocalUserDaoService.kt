package com.mateuszgrabarski.habittracker.framework.database.services

import com.mateuszgrabarski.habittracker.business.data.models.user.User
import com.mateuszgrabarski.habittracker.business.services.cache.abstraction.UserDaoService
import com.mateuszgrabarski.habittracker.framework.database.application.LocalTimeProvider
import com.mateuszgrabarski.habittracker.framework.database.daos.UserDao
import com.mateuszgrabarski.habittracker.framework.database.entities.UserEntity

internal class LocalUserDaoService(
    private val timeProvider: LocalTimeProvider,
    private val dao: UserDao
) : UserDaoService {

    override suspend fun insertUser(user: User): Long = dao.insert(
        user = UserEntity(
            id = user.id,
            createDate = timeProvider.now()
        )
    )
}
