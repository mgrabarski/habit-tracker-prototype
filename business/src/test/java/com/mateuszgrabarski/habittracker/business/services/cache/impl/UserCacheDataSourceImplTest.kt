package com.mateuszgrabarski.habittracker.business.services.cache.impl

import com.mateuszgrabarski.habittracker.business.data.models.user.User
import com.mateuszgrabarski.habittracker.business.data.types.Id
import com.mateuszgrabarski.habittracker.business.services.cache.CacheResult.GenericError
import com.mateuszgrabarski.habittracker.business.services.cache.CacheResult.Success
import com.mateuszgrabarski.habittracker.business.services.cache.abstraction.UserDaoService
import com.mateuszgrabarski.habittracker.business.usecases.Errors.CACHE_ERROR
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import io.mockk.coEvery
import io.mockk.mockk

class UserCacheDataSourceImplTest : DescribeSpec({

    val daoService: UserDaoService = mockk()

    val sut = UserCacheDataSourceImpl(
        daoService = daoService
    )

    describe("create user") {

        describe("success cache") {

            beforeEach {
                coEvery { daoService.insertUser(any()) } returns 1
            }

            it("returns success") {
                val result = sut.createUser(user = User(id = Id.randomUUID()))

                result shouldBe Success(1L)
            }
        }

        describe("failure cache") {

            beforeEach {
                coEvery { daoService.insertUser(any()) } returns 0
            }

            it("returns failure") {
                val result = sut.createUser(user = User(id = Id.randomUUID()))

                result shouldBe GenericError(errorMessage = CACHE_ERROR)
            }
        }
    }
})
