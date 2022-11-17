package com.mateuszgrabarski.habittracker.features.habits.add.application.model

import com.mateuszgrabarski.habittracker.business.data.models.habits.add.InputDescription
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class NumberInputsTest : DescribeSpec({

    describe("to input description") {

        it("maps") {
            NumberInputs(
                goal = 1.0,
                unit = "ks"
            ).toInputDescription() shouldBe InputDescription.Number(
                goal = 1.0,
                unit = "ks"
            )
        }
    }
})
