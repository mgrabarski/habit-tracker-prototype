package com.mateuszgrabarski.habittracker.business.habits.add

import android.os.Parcelable
import com.mateuszgrabarski.habittracker.business.habits.HabitIcon
import com.mateuszgrabarski.habittracker.business.habits.HabitType
import kotlinx.parcelize.Parcelize

@Parcelize
data class NewHabitBaseDefinition(
    val icon: IconInfo,
    val name: String,
    val description: String,
    val type: HabitType,
    val inputs: InputDescription
) : Parcelable

@Parcelize
data class IconInfo(
    val icon: HabitIcon,
    val color: Int
) : Parcelable

@Parcelize
sealed class InputDescription : Parcelable {

    object NotNeeded : InputDescription()

    data class Number(
        val goal: Double,
        val unit: String
    ) : InputDescription()

    data class Time(
        val hours: Int,
        val minutes: Int
    ) : InputDescription()
}
