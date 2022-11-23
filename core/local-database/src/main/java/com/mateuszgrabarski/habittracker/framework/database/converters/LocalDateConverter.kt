package com.mateuszgrabarski.habittracker.framework.database.converters

import androidx.room.TypeConverter
import java.time.LocalDate
import java.time.format.DateTimeParseException

internal class LocalDateConverter {

    @TypeConverter
    fun toDate(dateString: String?) = if (dateString != null) try {
        LocalDate.parse(dateString)
    } catch (e: DateTimeParseException) {
        null
    } else null

    @TypeConverter
    fun toDateString(date: LocalDate) = date.toString()
}
