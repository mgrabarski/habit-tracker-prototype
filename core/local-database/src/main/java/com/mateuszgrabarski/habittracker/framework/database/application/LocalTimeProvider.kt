package com.mateuszgrabarski.habittracker.framework.database.application

import java.time.LocalDateTime

interface LocalTimeProvider {
    fun now(): LocalDateTime
}
