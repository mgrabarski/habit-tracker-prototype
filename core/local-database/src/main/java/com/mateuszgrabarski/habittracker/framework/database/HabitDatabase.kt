package com.mateuszgrabarski.habittracker.framework.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.mateuszgrabarski.habittracker.framework.database.converters.LocalDateTimeConverter
import com.mateuszgrabarski.habittracker.framework.database.daos.UserDao
import com.mateuszgrabarski.habittracker.framework.database.entities.UserEntity

@Database(
    version = DATABASE_VERSION,
    exportSchema = true,
    entities = [
        UserEntity::class
    ]
)
@TypeConverters(
    value = [
        LocalDateTimeConverter::class
    ]
)
abstract class HabitDatabase : RoomDatabase() {

    abstract fun provideUserDao(): UserDao

    companion object {

        fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                HabitDatabase::class.java,
                DATABASE_NAME
            ).build()
    }
}
