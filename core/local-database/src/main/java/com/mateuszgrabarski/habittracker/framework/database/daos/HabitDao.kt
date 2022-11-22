package com.mateuszgrabarski.habittracker.framework.database.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.mateuszgrabarski.habittracker.business.data.types.Id
import com.mateuszgrabarski.habittracker.framework.database.entities.HabitEntity

@Dao
interface HabitDao {

    @Insert
    suspend fun insert(habit: HabitEntity): Long

    @Query("select * from habit where id = :habitId")
    suspend fun get(habitId: Id): HabitEntity?
}
