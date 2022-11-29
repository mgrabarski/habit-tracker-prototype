package com.mateuszgrabarski.habittracker.framework.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.mateuszgrabarski.habittracker.framework.database.converters.DayOfWeekConverter
import com.mateuszgrabarski.habittracker.framework.database.converters.IdConverter
import com.mateuszgrabarski.habittracker.framework.database.converters.ListOfIntsConverter
import com.mateuszgrabarski.habittracker.framework.database.converters.LocalDateConverter
import com.mateuszgrabarski.habittracker.framework.database.converters.LocalDateTimeConverter
import com.mateuszgrabarski.habittracker.framework.database.daos.HabitAndDetailsRelationDao
import com.mateuszgrabarski.habittracker.framework.database.daos.HabitDao
import com.mateuszgrabarski.habittracker.framework.database.daos.HabitDurationDao
import com.mateuszgrabarski.habittracker.framework.database.daos.HabitTypeDetailsDao
import com.mateuszgrabarski.habittracker.framework.database.daos.UserDao
import com.mateuszgrabarski.habittracker.framework.database.entities.HabitDurationEntity
import com.mateuszgrabarski.habittracker.framework.database.entities.HabitEntity
import com.mateuszgrabarski.habittracker.framework.database.entities.HabitTypeDetailsEntity
import com.mateuszgrabarski.habittracker.framework.database.entities.UserEntity

@Database(
    version = DatabaseDescription.DatabaseVersion,
    exportSchema = true,
    entities = [
        UserEntity::class,
        HabitEntity::class,
        HabitTypeDetailsEntity::class,
        HabitDurationEntity::class
    ]
)
@TypeConverters(
    value = [
        LocalDateTimeConverter::class,
        LocalDateConverter::class,
        DayOfWeekConverter::class,
        ListOfIntsConverter::class,
        IdConverter::class
    ]
)
internal abstract class HabitDatabase : RoomDatabase() {

    abstract fun provideUserDao(): UserDao

    abstract fun provideHabitDao(): HabitDao

    abstract fun provideHabitTypeDetailsDao(): HabitTypeDetailsDao

    abstract fun provideHabitDurationDao(): HabitDurationDao

    abstract fun provideHabitAndDetailsRelationDao(): HabitAndDetailsRelationDao

    companion object {

        fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                HabitDatabase::class.java,
                DatabaseDescription.DatabaseName
            ).build()
    }
}
