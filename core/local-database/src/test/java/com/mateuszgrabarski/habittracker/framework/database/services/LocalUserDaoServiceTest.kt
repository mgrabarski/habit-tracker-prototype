package com.mateuszgrabarski.habittracker.framework.database.services

import com.mateuszgrabarski.habittracker.business.data.models.user.User
import com.mateuszgrabarski.habittracker.business.data.types.Id
import com.mateuszgrabarski.habittracker.framework.database.application.LocalTimeProvider
import com.mateuszgrabarski.habittracker.framework.database.daos.UserDao
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import java.time.LocalDateTime

class LocalUserDaoServiceTest : DescribeSpec({

    val timeProvider: LocalTimeProvider = mockk()
    val dao: UserDao = mockk(relaxed = true)

    beforeEach {
        clearAllMocks()
        every { timeProvider.now() } returns LocalDateTime.now()
    }

    val sut = LocalUserDaoService(
        timeProvider = timeProvider,
        dao = dao
    )

    describe("insert") {

        it("verify time provider call") {
            sut.insertUser(user = User(id = Id.randomUUID()))

            verify(exactly = 1) { timeProvider.now() }
        }

        it("verify dao call") {
            sut.insertUser(user = User(id = Id.randomUUID()))

            coVerify(exactly = 1) { dao.insert(any()) }
        }

        it("received value should be same as dao returns") {
            coEvery { dao.insert(any()) } returns 1

            val result = sut.insertUser(user = User(id = Id.randomUUID()))

            result shouldBe 1
        }
    }
})
