package com.mateuszgrabarski.habittracker.features.habits.add.ui.dialog.viewmodels

import com.mateuszgrabarski.habittracker.business.habits.HabitIcon
import com.mateuszgrabarski.habittracker.features.habits.add.application.model.SelectedIcon
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.nulls.shouldBeNull
import io.kotest.matchers.shouldBe

class ChooseHabitIconDialogViewModelTest : DescribeSpec({

    lateinit var sut: ChooseHabitIconDialogViewModel

    beforeEach {
        sut = ChooseHabitIconDialogViewModel()
    }

    describe("init") {

        it("icon should not be selected") {
            sut.selectedIcon.shouldBeNull()
        }

        it("color should not be selected") {
            sut.selectedColor shouldBe 0
        }
    }

    describe("update selected icon") {

        it("should update state") {
            sut.updateSelectedIcon(icon = HabitIcon.Water)

            sut.selectedIcon shouldBe HabitIcon.Water
        }
    }

    describe("update selected color") {

        it("should update state") {
            sut.updateSelectedColor(color = 1)

            sut.selectedColor shouldBe 1
        }
    }

    describe("reset") {

        it("should reset states") {
            sut.updateSelectedIcon(icon = HabitIcon.Water)
            sut.updateSelectedColor(color = 1)

            sut.reset()

            sut.selectedIcon.shouldBeNull()
            sut.selectedColor shouldBe 0
        }
    }

    describe("to selected icon") {

        it("should throw exception when icon is not selected") {
            shouldThrow<IllegalArgumentException> {
                sut.toSelectedIcon()
            }
        }

        it("should map to selected icon object") {
            sut.updateSelectedIcon(icon = HabitIcon.Water)
            sut.updateSelectedColor(color = 1)

            sut.toSelectedIcon() shouldBe SelectedIcon(
                icon = HabitIcon.Water,
                color = 1
            )
        }
    }
})
