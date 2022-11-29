package com.mateuszgrabarski.habittracker.business.usecases.user

import com.mateuszgrabarski.habittracker.business.usecases.UseCaseWithoutResult
import kotlinx.coroutines.flow.Flow

interface CreateUserIfNeeded {

    fun create(): Flow<UseCaseWithoutResult>
}
