package com.mateuszgrabarski.habittracker.framework.database.converters

import com.mateuszgrabarski.habittracker.business.data.types.Id
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class IdConverterTest : DescribeSpec({

    val sut = IdConverter()

    describe("conversion") {

        describe("from") {

            val anyId = Id.randomUUID()

            it("Id to String") {
                sut.from(id = anyId) shouldBe anyId.toString()
            }
        }

        describe("to") {

            val anyId = Id.randomUUID().toString()

            it("Id from String") {
                sut.to(id = anyId) shouldBe Id.fromString(anyId)
            }
        }
    }
})
