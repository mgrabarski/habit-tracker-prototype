package com.mateuszgrabarski.habittracker.business.usecases

sealed class UseCaseWithResult<out T> {

    data class Success<out T>(val value: T) : UseCaseWithResult<T>()

    data class GenericError(
        val errorMessage: String? = null
    ) : UseCaseWithResult<Nothing>()
}
