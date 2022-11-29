package com.mateuszgrabarski.habittracker.framework.database.converters

import androidx.room.TypeConverter

internal class ListOfIntsConverter {

    @TypeConverter
    fun toList(dateString: String?): List<Int> =
        when {
            dateString.isNullOrEmpty() -> emptyList()
            else -> dateString.split(",").map { it.toInt() }
        }

    @TypeConverter
    fun fromList(days: List<Int>): String = days.joinToString(separator = ",")
}
