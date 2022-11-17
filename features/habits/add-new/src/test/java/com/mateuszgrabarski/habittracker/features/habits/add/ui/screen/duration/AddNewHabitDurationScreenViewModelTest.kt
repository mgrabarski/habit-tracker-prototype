package com.mateuszgrabarski.habittracker.features.habits.add.ui.screen.duration

import com.mateuszgrabarski.habittracker.business.data.models.habits.options.HabitDuration
import com.mateuszgrabarski.habittracker.business.data.models.habits.options.HabitDuration.DaysInMonth
import com.mateuszgrabarski.habittracker.business.data.models.habits.options.HabitIcon
import com.mateuszgrabarski.habittracker.business.data.models.habits.options.HabitType
import com.mateuszgrabarski.habittracker.business.data.models.habits.add.IconInfo
import com.mateuszgrabarski.habittracker.business.data.models.habits.add.InputDescription
import com.mateuszgrabarski.habittracker.business.data.models.habits.add.NewHabitBaseDefinition
import com.mateuszgrabarski.habittracker.features.habits.add.application.DurationValidator
import com.mateuszgrabarski.habittracker.features.habits.add.ui.screen.duration.model.SelectedDate
import com.mateuszgrabarski.habittracker.features.habits.add.ui.screen.duration.model.month.MonthDay
import com.mateuszgrabarski.habittracker.features.habits.add.ui.screen.duration.model.month.MonthSelectedDays
import com.mateuszgrabarski.habittracker.features.habits.add.ui.screen.duration.model.week.WeekDay
import com.mateuszgrabarski.habittracker.features.habits.add.ui.screen.duration.model.week.WeekSelectedDays
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.nulls.shouldBeNull
import io.kotest.matchers.shouldBe
import io.mockk.clearAllMocks
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import java.time.LocalDate

class AddNewHabitDurationScreenViewModelTest : DescribeSpec({

    val today = LocalDate.of(2022, 11, 16)

    val validator: DurationValidator = mockk(relaxed = true)

    lateinit var sut: AddNewHabitDurationScreenViewModel

    beforeEach {
        clearAllMocks()
        sut = AddNewHabitDurationScreenViewModel(
            habitBaseDefinition = anyNewHabitBaseDefinition(),
            today = today,
            selectedDays = MonthSelectedDays(),
            daysSelected = WeekSelectedDays(),
            validator = validator
        )
    }

    describe("init") {

        it("selected duration should be default") {
            sut.selectedDuration shouldBe HabitDuration.getDefaultDuration()
        }

        it("month days should be all not selected") {
            sut.monthDays shouldBe MonthDay.generateNotSelectedDays()
        }

        it("week days should be all not selected") {
            sut.weekDays shouldBe WeekDay.generateNotSelectedWeekDays()
        }

        it("start date should be today") {
            sut.startDate shouldBe SelectedDate.from(date = today)
        }

        it("end date should not be selected") {
            sut.endDate.shouldBeNull()
        }

        it("save should be enabled") {
            sut.saveEnabled.shouldBeTrue()
        }
    }

    describe("update selected month day") {

        val dayToChange = sut.monthDays[0]

        it("should update selected day state") {
            sut.updateSelectedMonthDay(day = dayToChange)

            sut.monthDays[0] shouldBe dayToChange.reverse()
        }

        it("should validate inputs") {
            sut.updateSelectedMonthDay(day = dayToChange)

            verify(exactly = 1) { validator.validate(any(), any(), any()) }
        }
    }

    describe("update selected week day") {

        val dayToChange = sut.weekDays[0]

        it("should update selected day state") {
            sut.updateSelectedWeekDay(day = dayToChange)

            sut.weekDays[0] shouldBe dayToChange.reverse()
        }

        it("should verify inputs") {
            sut.updateSelectedWeekDay(day = dayToChange)

            verify(exactly = 1) { validator.validate(any(), any(), any()) }
        }
    }

    describe("update duration") {

        it("should update duration state") {
            sut.updateSelectedDuration(duration = DaysInMonth)

            sut.selectedDuration shouldBe DaysInMonth
        }

        it("should verify inputs") {
            sut.updateSelectedDuration(duration = DaysInMonth)

            verify(exactly = 1) { validator.validate(any(), any(), any()) }
        }
    }

    describe("update start date") {

        it("should update correct date") {
            sut.updateStartDate(
                year = 2022,
                month = 0,
                dayOfMonth = 10
            )

            sut.startDate shouldBe SelectedDate(
                year = 2022,
                month = 1,
                dayOfMonth = 10
            )
        }

        it("should verify inputs") {
            sut.updateStartDate(
                year = 2022,
                month = 0,
                dayOfMonth = 10
            )

            verify(exactly = 1) { validator.validate(any(), any(), any()) }
        }
    }

    describe("update end date") {

        it("should update correct date") {
            sut.updateEndDate(
                year = 2022,
                month = 0,
                dayOfMonth = 10
            )

            sut.endDate shouldBe SelectedDate(
                year = 2022,
                month = 1,
                dayOfMonth = 10
            )
        }

        it("should verify inputs") {
            sut.updateEndDate(
                year = 2022,
                month = 0,
                dayOfMonth = 10
            )

            verify(exactly = 1) { validator.validate(any(), any(), any()) }
        }
    }

    describe("validate") {

        describe("positive") {

            beforeEach {
                every { validator.validate(any(), any(), any()) } returns true
            }

            it("should update save enable state") {
                sut.updateSelectedDuration(duration = DaysInMonth)

                sut.saveEnabled.shouldBeTrue()
            }
        }

        describe("negative") {

            beforeEach {
                every { validator.validate(any(), any(), any()) } returns false
            }

            it("should update save enable state") {
                sut.updateSelectedDuration(duration = DaysInMonth)

                sut.saveEnabled.shouldBeFalse()
            }
        }
    }
})

fun anyNewHabitBaseDefinition() = NewHabitBaseDefinition(
    icon = IconInfo(
        icon = HabitIcon.Water,
        color = 0
    ),
    name = "some name",
    description = "some desc",
    type = HabitType.YesOrNo,
    inputs = InputDescription.NotNeeded
)
