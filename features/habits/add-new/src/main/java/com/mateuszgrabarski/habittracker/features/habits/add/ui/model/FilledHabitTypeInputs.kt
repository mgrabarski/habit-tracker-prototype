package com.mateuszgrabarski.habittracker.features.habits.add.ui.model

sealed class FilledHabitTypeInputs

data class NumberInputs(
    val goal: Double,
    val unit: String
) : FilledHabitTypeInputs()

data class TimeInputs(
    val time: SelectedTime
) : FilledHabitTypeInputs()
