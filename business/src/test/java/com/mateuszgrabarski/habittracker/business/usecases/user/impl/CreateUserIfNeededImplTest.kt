package com.mateuszgrabarski.habittracker.business.usecases.user.impl

import com.mateuszgrabarski.habittracker.business.data.models.user.UserFactory
import com.mateuszgrabarski.habittracker.business.data.types.Id
import com.mateuszgrabarski.habittracker.business.services.cache.CacheResult
import com.mateuszgrabarski.habittracker.business.services.cache.UserCacheDataSource
import com.mateuszgrabarski.habittracker.business.services.storage.UserStorage
import com.mateuszgrabarski.habittracker.business.usecases.UseCaseWithoutResult.GenericError
import com.mateuszgrabarski.habittracker.business.usecases.UseCaseWithoutResult.Success
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf

class CreateUserIfNeededImplTest : DescribeSpec({

    val userFactory = UserFactory()
    val storage: UserStorage = mockk(relaxed = true)
    val cacheDataSource: UserCacheDataSource = mockk()

    val sut = CreateUserIfNeededImpl(
        userFactory = userFactory,
        storage = storage,
        cacheDataSource = cacheDataSource
    )

    beforeEach {
        clearAllMocks()
    }

    describe("create") {

        describe("user already exists") {

            beforeEach {
                coEvery { storage.readActiveUserId() } returns flowOf(Id.randomUUID())
            }

            it("expect success") {
                sut.create().first() shouldBe Success
            }
        }

        describe("creates new user") {

            beforeEach {
                coEvery { storage.readActiveUserId() } returns flowOf(null)
            }

            describe("success creates user in cache") {

                beforeEach {
                    coEvery { cacheDataSource.createUser(any()) } returns CacheResult.Success(1)
                }

                it("verify cache interaction") {
                    sut.create().first()

                    coVerify(exactly = 1) { cacheDataSource.createUser(any()) }
                }

                it("verify store interaction") {
                    sut.create().first()

                    coVerify(exactly = 1) { storage.setActiveUser(any()) }
                }

                it("expected result is success") {
                    sut.create().first() shouldBe Success
                }
            }

            describe("failure to create user in cache") {

                beforeEach {
                    coEvery { cacheDataSource.createUser(any()) } returns CacheResult.GenericError(
                        errorMessage = "message"
                    )
                }

                it("verify cache interaction") {
                    sut.create().first()

                    coVerify(exactly = 1) { cacheDataSource.createUser(any()) }
                }

                it("expect failure") {
                    sut.create().first() shouldBe GenericError(errorMessage = "message")
                }
            }
        }
    }
})
