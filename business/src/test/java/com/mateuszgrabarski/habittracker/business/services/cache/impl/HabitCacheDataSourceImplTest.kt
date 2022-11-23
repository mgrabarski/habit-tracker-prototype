package com.mateuszgrabarski.habittracker.business.services.cache.impl

import com.mateuszgrabarski.habittracker.business.fixtures.NewHabitFixtures.anyNewHabit
import com.mateuszgrabarski.habittracker.business.services.cache.CacheResult.GenericError
import com.mateuszgrabarski.habittracker.business.services.cache.CacheResult.Success
import com.mateuszgrabarski.habittracker.business.services.cache.abstraction.HabitDaoService
import com.mateuszgrabarski.habittracker.business.usecases.Errors.CACHE_ERROR
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import io.mockk.coEvery
import io.mockk.mockk

class HabitCacheDataSourceImplTest : DescribeSpec({

    val dao: HabitDaoService = mockk()

    val sut = HabitCacheDataSourceImpl(
        dao = dao
    )

    describe("create new habit") {

        describe("success cache") {

            beforeEach {
                coEvery { dao.insertNewHabit(any()) } returns 1L
            }

            it("returns success") {
                val result = sut.insertNewHabit(habit = anyNewHabit())

                result shouldBe Success(1L)
            }
        }

        describe("failure cache") {

            beforeEach {
                coEvery { dao.insertNewHabit(any()) } returns 0
            }

            it("returns failure") {
                val result = sut.insertNewHabit(habit = anyNewHabit())

                result shouldBe GenericError(errorMessage = CACHE_ERROR)
            }
        }
    }
})
