package com.mateuszgrabarski.habittracker.business.usecases

sealed class UseCaseResult<out T> {

    data class Success<out T>(val value: T) : UseCaseResult<T>()

    data class GenericError(
        val errorMessage: String? = null
    ) : UseCaseResult<Nothing>()
}
