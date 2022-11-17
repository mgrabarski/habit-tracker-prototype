package com.mateuszgrabarski.habittracker.features.habits.add.ui

import com.mateuszgrabarski.habittracker.business.data.models.habits.add.IconInfo
import com.mateuszgrabarski.habittracker.business.data.models.habits.add.InputDescription
import com.mateuszgrabarski.habittracker.business.data.models.habits.add.NewHabitBaseDefinition
import com.mateuszgrabarski.habittracker.business.data.models.habits.options.HabitIcon
import com.mateuszgrabarski.habittracker.business.data.models.habits.options.HabitType
import com.mateuszgrabarski.habittracker.features.habits.add.application.BaseHabitInfoValidator
import com.mateuszgrabarski.habittracker.features.habits.add.application.model.NumberInputs
import com.mateuszgrabarski.habittracker.features.habits.add.application.model.SelectedIcon
import com.mateuszgrabarski.habittracker.features.habits.add.application.model.SelectedTime
import com.mateuszgrabarski.habittracker.features.habits.add.application.model.TimeInputs
import com.mateuszgrabarski.habittracker.features.habits.add.ui.screen.base.viewmodel.AddNewHabitViewModel
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.nulls.shouldBeNull
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldBeEmpty
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify

class AddNewHabitViewModelTest : DescribeSpec({

    val nextButtonValidator: BaseHabitInfoValidator = mockk()

    lateinit var sut: AddNewHabitViewModel

    beforeEach {
        sut = AddNewHabitViewModel(
            nextButtonValidator = nextButtonValidator
        )
        every { nextButtonValidator.isValid(any(), any(), any(), any()) } returns false
    }

    describe("init") {

        it("selected icon is empty") {
            sut.selectedIcon.shouldBeNull()
        }

        it("next button is disabled") {
            sut.nextButtonEnabled.shouldBeFalse()
        }

        it("habit name is empty") {
            sut.habitName.shouldBeEmpty()
        }

        it("habit description is empty") {
            sut.habitDescription.shouldBeEmpty()
        }

        it("type is not selectable") {
            sut.habitType shouldBe HabitType.None
        }

        it("inputs are null") {
            sut.updateHabitName("name")

            verify {
                nextButtonValidator.isValid(
                    selectedIcon = isNull(),
                    habitName = eq("name"),
                    habitType = eq(HabitType.None),
                    inputs = isNull()
                )
            }
        }
    }

    describe("update selected icon") {

        it("should update state") {
            sut.updateSelectedIcon(
                icon = icon
            )

            sut.selectedIcon shouldBe icon
        }

        it("should verify enable button state") {
            sut.updateSelectedIcon(
                icon = icon
            )

            verify {
                nextButtonValidator.isValid(
                    selectedIcon = eq(icon),
                    habitName = any(),
                    habitType = any(),
                    inputs = any()
                )
            }
        }
    }

    describe("update habit name") {

        it("should update state") {
            sut.updateHabitName(name = "some name")

            sut.habitName shouldBe "some name"
        }

        it("should verify enable button state") {
            sut.updateHabitName(name = "some name")

            verify {
                nextButtonValidator.isValid(
                    selectedIcon = any(),
                    habitName = eq("some name"),
                    habitType = any(),
                    inputs = any()
                )
            }
        }
    }

    describe("update habit description") {

        it("should update state") {
            sut.updateHabitDescription(description = "some description")

            sut.habitDescription shouldBe "some description"
        }

        it("should verify enable button state") {
            sut.updateHabitDescription(description = "some description")

            verify {
                nextButtonValidator.isValid(
                    selectedIcon = any(),
                    habitName = any(),
                    habitType = any(),
                    inputs = any()
                )
            }
        }
    }

    describe("update habit type") {

        it("should update state") {
            sut.updateHabitType(type = HabitType.YesOrNo)

            sut.habitType shouldBe HabitType.YesOrNo
        }

        it("should verify enable button state") {
            sut.updateHabitType(type = HabitType.YesOrNo)

            verify {
                nextButtonValidator.isValid(
                    selectedIcon = any(),
                    habitName = any(),
                    habitType = eq(HabitType.YesOrNo),
                    inputs = any()
                )
            }
        }

        it("should clean inputs") {
            sut.updateHabitType(type = HabitType.YesOrNo)
            val inputs = NumberInputs(goal = 0.0, unit = "")
            sut.updateHabitTypeInputs(inputs = inputs)

            verify {
                nextButtonValidator.isValid(
                    selectedIcon = any(),
                    habitName = any(),
                    habitType = any(),
                    inputs = eq(inputs)
                )
            }

            sut.updateHabitType(type = HabitType.Number)

            verify {
                nextButtonValidator.isValid(
                    selectedIcon = any(),
                    habitName = any(),
                    habitType = any(),
                    inputs = isNull()
                )
            }
        }
    }

    describe("update habit inputs") {

        it("should update state") {
            val inputs = NumberInputs(goal = 0.0, unit = "")

            sut.updateHabitTypeInputs(inputs = inputs)

            verify {
                nextButtonValidator.isValid(
                    selectedIcon = any(),
                    habitName = any(),
                    habitType = any(),
                    inputs = eq(inputs)
                )
            }
        }
    }

    describe("enable next button") {

        it("should be enable when validator returns valid state") {
            every { nextButtonValidator.isValid(any(), any(), any(), any()) } returns true

            sut.updateHabitName(name = "name")

            sut.nextButtonEnabled.shouldBeTrue()
        }

        it("should be disabled when validator returns not valid state") {
            every { nextButtonValidator.isValid(any(), any(), any(), any()) } returns false

            sut.updateHabitName(name = "name")

            sut.nextButtonEnabled.shouldBeFalse()
        }
    }

    describe("map to business") {

        it("when icon is not selected then throw exception") {
            shouldThrow<IllegalArgumentException> {
                sut.getNewHabitBaseDefinition()
            }
        }

        it("should returns definition with not needed inputs") {
            sut.updateSelectedIcon(icon = icon)
            sut.updateHabitName(name = "some name")
            sut.updateHabitDescription(description = "some description")
            sut.updateHabitType(type = HabitType.YesOrNo)

            sut.getNewHabitBaseDefinition() shouldBe NewHabitBaseDefinition(
                icon = IconInfo(
                    icon = icon.icon,
                    color = icon.color
                ),
                name = "some name",
                description = "some description",
                type = HabitType.YesOrNo,
                inputs = InputDescription.NotNeeded
            )
        }

        it("should return mapped object") {
            sut.updateSelectedIcon(icon = icon)
            sut.updateHabitName(name = "some name")
            sut.updateHabitDescription(description = "some description")
            sut.updateHabitType(type = HabitType.Timer)
            sut.updateHabitTypeInputs(
                inputs = TimeInputs(
                    time = SelectedTime(
                        hours = 1,
                        minutes = 1
                    )
                )
            )

            sut.getNewHabitBaseDefinition() shouldBe NewHabitBaseDefinition(
                icon = IconInfo(
                    icon = icon.icon,
                    color = icon.color
                ),
                name = "some name",
                description = "some description",
                type = HabitType.Timer,
                inputs = InputDescription.Time(
                    hours = 1,
                    minutes = 1
                )
            )
        }
    }
})

private val icon = SelectedIcon(
    icon = HabitIcon.Book,
    color = 1
)
