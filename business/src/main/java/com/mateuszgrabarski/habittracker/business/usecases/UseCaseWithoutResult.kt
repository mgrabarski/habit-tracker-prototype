package com.mateuszgrabarski.habittracker.business.usecases

sealed class UseCaseWithoutResult {

    object Success : UseCaseWithoutResult()

    data class GenericError(
        val errorMessage: String? = null
    ) : UseCaseWithoutResult()
}
