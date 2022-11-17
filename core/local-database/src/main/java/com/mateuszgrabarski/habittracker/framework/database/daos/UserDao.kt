package com.mateuszgrabarski.habittracker.framework.database.daos

import androidx.room.Dao
import androidx.room.Insert
import com.mateuszgrabarski.habittracker.framework.database.entities.UserEntity

@Dao
interface UserDao {

    @Insert
    suspend fun insert(user: UserEntity): Long
}
