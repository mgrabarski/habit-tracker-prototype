package com.mateuszgrabarski.habittracker.framework.database.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.mateuszgrabarski.habittracker.business.data.types.Id
import com.mateuszgrabarski.habittracker.framework.database.entities.HabitTypeDetailsEntity

@Dao
interface HabitTypeDetailsDao {

    @Insert
    suspend fun insert(details: HabitTypeDetailsEntity): Long

    @Query("select * from habit_type_details where habit_id = :habitId")
    suspend fun get(habitId: Id): HabitTypeDetailsEntity?
}
