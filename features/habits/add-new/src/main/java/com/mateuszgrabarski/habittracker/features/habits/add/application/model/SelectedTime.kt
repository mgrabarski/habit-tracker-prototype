package com.mateuszgrabarski.habittracker.features.habits.add.application.model

data class SelectedTime(
    val hours: Int,
    val minutes: Int
) {
    val displayValues: String
        get() = "$hours:$minutes"
}
