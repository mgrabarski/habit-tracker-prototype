package com.mateuszgrabarski.habittracker.framework.database.converters

import androidx.room.TypeConverter
import java.time.LocalDateTime
import java.time.format.DateTimeParseException

internal class LocalDateTimeConverter {

    @TypeConverter
    fun toDate(dateString: String?) = when {
        dateString.isNullOrEmpty() -> null
        else -> try {
            LocalDateTime.parse(dateString)
        } catch (e: DateTimeParseException) {
            null
        }
    }

    @TypeConverter
    fun toDateString(date: LocalDateTime) = date.toString()
}
