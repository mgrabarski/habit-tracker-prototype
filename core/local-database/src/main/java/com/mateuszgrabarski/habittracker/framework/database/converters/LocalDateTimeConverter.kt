package com.mateuszgrabarski.habittracker.framework.database.converters

import androidx.room.TypeConverter
import java.time.LocalDateTime

class LocalDateTimeConverter {

    @TypeConverter
    fun toDate(dateString: String?) = LocalDateTime.parse(dateString)

    @TypeConverter
    fun toDateString(date: LocalDateTime) = date.toString()
}
