package com.mateuszgrabarski.habittracker.business.data.models.habits.add

import android.os.Parcelable
import com.mateuszgrabarski.habittracker.business.data.models.habits.HabitIconData
import com.mateuszgrabarski.habittracker.business.data.models.habits.HabitTypeData
import com.mateuszgrabarski.habittracker.business.data.models.habits.HabitTypeData.*
import com.mateuszgrabarski.habittracker.business.data.models.habits.options.HabitIcon
import com.mateuszgrabarski.habittracker.business.data.models.habits.options.HabitType
import kotlinx.parcelize.Parcelize

@Parcelize
data class NewHabitBaseDefinition(
    val icon: IconInfo,
    val name: String,
    val description: String,
    val type: HabitType,
    val inputs: InputDescription
) : Parcelable {

    fun toIconData() = HabitIconData(
        icon = icon.icon,
        color = icon.color
    )
}

@Parcelize
data class IconInfo(
    val icon: HabitIcon,
    val color: Int
) : Parcelable

@Parcelize
sealed class InputDescription : Parcelable {

    abstract fun toHabitTypeData(): HabitTypeData

    object NotNeeded : InputDescription() {

        override fun toHabitTypeData(): HabitTypeData = NotNeededData
    }

    data class Number(
        val goal: Double,
        val unit: String
    ) : InputDescription() {

        override fun toHabitTypeData(): HabitTypeData = NumberData(
            goal = goal,
            unit = unit
        )
    }

    data class Time(
        val hours: Int,
        val minutes: Int
    ) : InputDescription() {
        override fun toHabitTypeData(): HabitTypeData = TimeData(
            hours = hours,
            minutes = minutes
        )
    }
}
