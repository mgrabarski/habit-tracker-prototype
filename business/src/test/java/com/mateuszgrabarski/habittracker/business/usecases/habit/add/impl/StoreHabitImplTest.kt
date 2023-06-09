package com.mateuszgrabarski.habittracker.business.usecases.habit.add.impl

import com.mateuszgrabarski.habittracker.business.data.models.habits.Habit
import com.mateuszgrabarski.habittracker.business.data.models.habits.add.NewHabitFactory
import com.mateuszgrabarski.habittracker.business.data.types.Id
import com.mateuszgrabarski.habittracker.business.fixtures.HabitDurationDefinitionFixtures
import com.mateuszgrabarski.habittracker.business.fixtures.NewHabitBaseDefinitionFixtures
import com.mateuszgrabarski.habittracker.business.services.cache.CacheResult
import com.mateuszgrabarski.habittracker.business.services.cache.HabitCacheDataSource
import com.mateuszgrabarski.habittracker.business.services.storage.UserStorage
import com.mateuszgrabarski.habittracker.business.usecases.Errors
import com.mateuszgrabarski.habittracker.business.usecases.UseCaseWithResult
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeInstanceOf
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf

class StoreHabitImplTest : DescribeSpec({

    val factory = NewHabitFactory()
    val storage: UserStorage = mockk(relaxed = true)
    val cache: HabitCacheDataSource = mockk(relaxed = true)

    val sut = StoreHabitImpl(
        storage = storage,
        factory = factory,
        cache = cache
    )

    beforeEach {
        clearAllMocks()
    }

    describe("user exists") {

        beforeEach {
            every { storage.readActiveUserId() } returns flowOf(Id.randomUUID())
        }

        describe("success creates in cache") {

            beforeEach {
                coEvery { cache.insertNewHabit(any()) } returns CacheResult.Success(1)
            }

            it("verify cache interaction") {
                sut.store(
                    baseDefinition = NewHabitBaseDefinitionFixtures.any(),
                    durationDefinition = HabitDurationDefinitionFixtures.any()
                ).first()

                coVerify(exactly = 1) { cache.insertNewHabit(any()) }
            }

            it("expect success result") {
                val result = sut.store(
                    baseDefinition = NewHabitBaseDefinitionFixtures.any(),
                    durationDefinition = HabitDurationDefinitionFixtures.any()
                ).first()

                result.shouldBeInstanceOf<UseCaseWithResult.Success<Habit>>()
            }
        }

        describe("failure to create in cache") {

            beforeEach {
                coEvery { cache.insertNewHabit(any()) } returns CacheResult.GenericError(
                    errorMessage = "message"
                )
            }

            it("verify cache interaction") {
                sut.store(
                    baseDefinition = NewHabitBaseDefinitionFixtures.any(),
                    durationDefinition = HabitDurationDefinitionFixtures.any()
                ).first()

                coVerify(exactly = 1) { cache.insertNewHabit(any()) }
            }

            it("expect failure result") {
                sut.store(
                    baseDefinition = NewHabitBaseDefinitionFixtures.any(),
                    durationDefinition = HabitDurationDefinitionFixtures.any()
                ).first() shouldBe UseCaseWithResult.GenericError(errorMessage = "message")
            }
        }
    }

    describe("user not exists") {

        beforeEach {
            every { storage.readActiveUserId() } returns flowOf(null)
        }

        it("should return failure with message") {
            val result = sut.store(
                baseDefinition = NewHabitBaseDefinitionFixtures.any(),
                durationDefinition = HabitDurationDefinitionFixtures.any()
            ).first()

            result shouldBe UseCaseWithResult.GenericError(errorMessage = Errors.USER_NOT_SET)
        }
    }
})
