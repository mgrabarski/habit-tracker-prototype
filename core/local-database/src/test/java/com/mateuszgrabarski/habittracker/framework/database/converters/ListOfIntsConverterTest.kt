package com.mateuszgrabarski.habittracker.framework.database.converters

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.collections.shouldBeEmpty
import io.kotest.matchers.shouldBe

class ListOfIntsConverterTest : DescribeSpec({

    val sut = ListOfIntsConverter()

    describe("conversion") {

        describe("to list") {

            it("null to empty list") {
                sut.toList(dateString = null).shouldBeEmpty()
            }

            it("empty string to empty list") {
                sut.toList(dateString = "").shouldBeEmpty()
            }

            it("String to list of ints") {
                sut.toList(dateString = "1,2,3") shouldBe listOf(1, 2, 3)
            }
        }

        describe("from list") {

            it("of ints to String") {
                sut.fromList(days = listOf(1, 2, 3)) shouldBe "1,2,3"
            }
        }
    }
})
