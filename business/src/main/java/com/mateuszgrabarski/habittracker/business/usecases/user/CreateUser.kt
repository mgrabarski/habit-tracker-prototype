package com.mateuszgrabarski.habittracker.business.usecases.user

import com.mateuszgrabarski.habittracker.business.data.models.user.User
import com.mateuszgrabarski.habittracker.business.usecases.UseCaseResult
import kotlinx.coroutines.flow.Flow

interface CreateUser {

    fun create(): Flow<UseCaseResult<User>>
}
