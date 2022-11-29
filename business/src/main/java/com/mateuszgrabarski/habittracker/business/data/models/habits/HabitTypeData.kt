package com.mateuszgrabarski.habittracker.business.data.models.habits

sealed class HabitTypeData {

    object NotNeededData : HabitTypeData()

    data class NumberData(
        val goal: Double,
        val unit: String
    ) : HabitTypeData()

    data class TimeData(
        val hours: Int,
        val minutes: Int
    ) : HabitTypeData()
}
