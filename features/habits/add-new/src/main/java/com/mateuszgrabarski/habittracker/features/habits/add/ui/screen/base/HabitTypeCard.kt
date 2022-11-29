package com.mateuszgrabarski.habittracker.features.habits.add.ui.screen.base

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mateuszgrabarski.habittracker.business.data.models.habits.options.HabitType
import com.mateuszgrabarski.habittracker.features.habits.add.application.BaseHabitInfoValidator
import com.mateuszgrabarski.habittracker.features.habits.add.ui.screen.base.viewmodel.AddNewHabitViewModel
import com.mateuszgrabarski.habittracker.resources.R
import com.mateuszgrabarski.habittracker.resources.ui.components.spinner.SelectableSpinner

@Composable
fun HabitTypeCard(
    viewModel: AddNewHabitViewModel
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 8.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 8.dp)
        ) {
            SelectableSpinner(
                title = R.string.add_habit_choose_type_title,
                notSelectedOption = HabitType.getNotSelectableType(),
                options = HabitType.getSelectableTypes(),
                selectedOption = viewModel.habitType
            ) {
                viewModel.updateHabitType(type = it as HabitType)
            }
        }
    }
    when (viewModel.habitType) {
        HabitType.Number -> NumberHabitTypeInputs(
            onFilledNumbers = {
                viewModel.updateHabitTypeInputs(inputs = it)
            }
        )
        HabitType.Timer -> TimerHabitTypeInputs(
            onPickerTime = {
                viewModel.updateHabitTypeInputs(inputs = it)
            }
        )
        HabitType.YesOrNo -> Unit
        else -> Unit
    }
}

@Preview(showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Preview(showSystemUi = true)
@Composable
private fun HabitTypeCardPreview() {
    HabitTypeCard(
        viewModel = AddNewHabitViewModel(nextButtonValidator = BaseHabitInfoValidator())
    )
}
