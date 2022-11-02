package com.mateuszgrabarski.habittracker.features.habits.add.ui.screen.add.viewmodel

import com.mateuszgrabarski.habittracker.features.habits.add.ui.model.NumberInputs
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class NumberTypeInputsViewModelTest : DescribeSpec({

    val sut = NumberTypeInputsViewModel()

    beforeEach {
        sut.updateUnit("")
        sut.updateGoal("")
    }

    describe("unit") {

        it("update should change state") {
            sut.updateUnit("test")

            sut.unit shouldBe "test"
        }
    }

    describe("goal") {

        it("update should change state") {
            sut.updateGoal("test")

            sut.goal shouldBe "test"
        }
    }

    describe("to filled inputs") {

        it("given filled unit and goal") {
            sut.updateGoal(goal = "5")
            sut.updateUnit(unit = "kg")

            sut.toFilledNumbers() shouldBe NumberInputs(
                goal = 5.0,
                unit = "kg"
            )
        }

        it("given empty unit and goal") {
            sut.toFilledNumbers() shouldBe NumberInputs(
                goal = 0.0,
                unit = ""
            )
        }

        it("given empty unit but filled goal") {
            sut.updateGoal(goal = "5")

            sut.toFilledNumbers() shouldBe NumberInputs(
                goal = 5.0,
                unit = ""
            )
        }

        it("given filled unit but empty goal") {
            sut.updateUnit(unit = "kg")

            sut.toFilledNumbers() shouldBe NumberInputs(
                goal = 0.0,
                unit = "kg"
            )
        }

        describe("map goal") {

            it("given empty") {
                sut.updateGoal(goal = "")

                (sut.toFilledNumbers() as NumberInputs).goal shouldBe 0.0
            }

            it("given positive number") {
                sut.updateGoal(goal = "1")

                (sut.toFilledNumbers() as NumberInputs).goal shouldBe 1.0
            }

            it("given negative number") {
                sut.updateGoal(goal = "-1")

                (sut.toFilledNumbers() as NumberInputs).goal shouldBe -1.0
            }

            it("given text") {
                sut.updateGoal(goal = "text")

                (sut.toFilledNumbers() as NumberInputs).goal shouldBe 0.0
            }
        }
    }
})
