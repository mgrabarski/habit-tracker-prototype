package com.mateuszgrabarski.habittracker.framework.database.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.mateuszgrabarski.habittracker.business.data.types.Id
import com.mateuszgrabarski.habittracker.framework.database.entities.HabitDurationEntity
import com.mateuszgrabarski.habittracker.framework.database.entities.HabitEntity
import com.mateuszgrabarski.habittracker.framework.database.entities.HabitTypeDetailsEntity
import com.mateuszgrabarski.habittracker.framework.database.entities.relations.HabitAndDetailsRelation
import kotlinx.coroutines.flow.Flow

@Dao
internal abstract class HabitAndDetailsRelationDao {

    suspend fun insert(habit: HabitAndDetailsRelation) {
        insertHabit(habit = habit.habit)
        insertTypeDetails(details = habit.typeDetails)
        insertDuration(duration = habit.duration)
    }

    @Insert
    abstract suspend fun insertHabit(habit: HabitEntity): Long

    @Insert
    abstract suspend fun insertTypeDetails(details: HabitTypeDetailsEntity): Long

    @Insert
    abstract suspend fun insertDuration(duration: HabitDurationEntity): Long

    @Transaction
    @Query("select * from habit where id = :habitId")
    abstract suspend fun get(habitId: Id): HabitAndDetailsRelation?

    @Transaction
    @Query("select * from habit")
    abstract fun getAll(): Flow<List<HabitAndDetailsRelation>>
}
