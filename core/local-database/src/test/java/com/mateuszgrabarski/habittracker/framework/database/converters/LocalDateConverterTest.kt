package com.mateuszgrabarski.habittracker.framework.database.converters

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.nulls.shouldBeNull
import io.kotest.matchers.shouldBe
import java.time.LocalDate

class LocalDateConverterTest : DescribeSpec({

    val sut = LocalDateConverter()

    describe("conversion") {

        describe("to date") {

            it("null then null") {
                sut.toDate(dateString = null).shouldBeNull()
            }

            it("empty string to null") {
                sut.toDate(dateString = "").shouldBeNull()
            }

            it("parse valid string to local date") {
                sut.toDate(dateString = "2022-11-22") shouldBe LocalDate.of(2022, 11, 22)
            }

            it("null for not valid string") {
                sut.toDate(dateString = "some text").shouldBeNull()
            }
        }

        describe("from date") {

            it("to String") {
                sut.toDateString(date = LocalDate.of(2022, 11, 22)) shouldBe "2022-11-22"
            }
        }
    }
})
