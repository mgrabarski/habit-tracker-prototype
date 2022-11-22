package com.mateuszgrabarski.habittracker.framework.database

internal object DatabaseDescription {
    internal const val DatabaseDiScope = "DATABASE"

    internal const val DatabaseName = "habit.db"
    internal const val DatabaseVersion = 1
}

internal object Tables {

    object TableUser {
        const val TableName = "user"

        object Columns {
            const val Id = "id"
            const val CreateDate = "created_ts"
        }

        object Indexes {
            const val Id = "id"
        }
    }

    object TableHabit {
        const val TableName = "habit"

        object Columns {
            const val Id = "id"
            const val Name = "name"
            const val Description = "description"
            const val IconImage = "image"
            const val IconColor = "color"
        }

        object Prefix {
            const val IconPrefix = "icon_"
        }

        object ForeignKeys {
            const val UserId = "user_id"
        }

        object Indexes {
            const val Id = "id"
            const val UserId = "user_id"
        }
    }

    object TableHabitTypeDetails {
        const val TableName = "habit_type_details"

        object Columns {
            const val Id = "id"
            const val Type = "type"
            const val NumberGoal = "goal"
            const val NumberUnit = "unit"
        }

        object ForeignKeys {
            const val HabitId = "habit_id"
        }

        object Prefix {
            const val Number = "numbers_"
            const val Time = "time_"
        }

        object Indexes {
            const val Id = "id"
            const val HabitId = "habit_id"
        }
    }

    object TableHabitDuration {
        const val TableName = "habit_duration"

        object Columns {
            const val Id = "id"
            const val StartDate = "start_date"
            const val EndDate = "end_date"
            const val Duration = "duration"
            const val WeekDays = "week_days"
            const val MonthDays = "month_days"
        }

        object ForeignKeys {
            const val HabitId = "habit_id"
        }

        object Indexes {
            const val Id = "id"
            const val HabitId = "habit_id"
        }
    }
}
