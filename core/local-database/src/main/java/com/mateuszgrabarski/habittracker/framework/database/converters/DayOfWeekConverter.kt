package com.mateuszgrabarski.habittracker.framework.database.converters

import androidx.room.TypeConverter
import java.time.DayOfWeek

class DayOfWeekConverter {

    @TypeConverter
    fun toList(dateString: String?): List<DayOfWeek> =
        when {
            dateString.isNullOrEmpty() -> emptyList()
            else -> dateString.split(",").map { DayOfWeek.valueOf(it) }
        }

    @TypeConverter
    fun fromList(days: List<DayOfWeek>): String = days.joinToString(separator = ",")
}
