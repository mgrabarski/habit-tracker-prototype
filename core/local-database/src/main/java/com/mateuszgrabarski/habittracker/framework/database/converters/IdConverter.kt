package com.mateuszgrabarski.habittracker.framework.database.converters

import androidx.room.TypeConverter
import com.mateuszgrabarski.habittracker.business.data.types.Id

internal class IdConverter {

    @TypeConverter
    fun from(id: Id): String = id.toString()

    @TypeConverter
    fun to(id: String): Id = Id.fromString(id)
}
