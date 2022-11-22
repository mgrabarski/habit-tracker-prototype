package com.mateuszgrabarski.habittracker.framework.database.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.mateuszgrabarski.habittracker.business.data.types.Id
import com.mateuszgrabarski.habittracker.framework.database.entities.HabitDurationEntity

@Dao
interface HabitDurationDao {

    @Insert
    suspend fun insert(durationEntity: HabitDurationEntity): Long

    @Query("select * from habit_duration where habit_id = :habitId")
    suspend fun get(habitId: Id): HabitDurationEntity?
}
