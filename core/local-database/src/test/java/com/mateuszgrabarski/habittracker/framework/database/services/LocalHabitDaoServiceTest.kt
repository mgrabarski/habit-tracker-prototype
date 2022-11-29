package com.mateuszgrabarski.habittracker.framework.database.services

import com.mateuszgrabarski.habittracker.framework.database.application.LocalTimeProvider
import com.mateuszgrabarski.habittracker.framework.database.daos.HabitAndDetailsRelationDao
import com.mateuszgrabarski.habittracker.framework.database.fixtures.NewHabitFixtures.anyNewHabit
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import io.mockk.clearAllMocks
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import java.time.LocalDateTime

class LocalHabitDaoServiceTest : DescribeSpec({

    val now = LocalDateTime.now()
    val timeProvider: LocalTimeProvider = mockk(relaxed = true)
    val dao: HabitAndDetailsRelationDao = mockk(relaxed = true)

    val sut = LocalHabitDaoService(
        timeProvider = timeProvider,
        dao = dao
    )

    beforeEach {
        clearAllMocks()
        every { timeProvider.now() } returns now
    }

    describe("insert new habit") {

        it("verify calling dao") {
            val habit = anyNewHabit()
            sut.insertNewHabit(habit = habit)

            coVerify(exactly = 1) { dao.insert(any()) }
        }

        it("verify calling time provider") {
            sut.insertNewHabit(habit = anyNewHabit())

            verify(exactly = 1) { timeProvider.now() }
        }

        it("should returns one") {
            sut.insertNewHabit(habit = anyNewHabit()) shouldBe 1
        }
    }
})
