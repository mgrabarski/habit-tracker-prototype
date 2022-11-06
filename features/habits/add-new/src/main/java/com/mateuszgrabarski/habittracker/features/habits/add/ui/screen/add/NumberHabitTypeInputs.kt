package com.mateuszgrabarski.habittracker.features.habits.add.ui.screen.add

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Card
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mateuszgrabarski.habittracker.features.habits.add.application.model.FilledHabitTypeInputs
import com.mateuszgrabarski.habittracker.features.habits.add.ui.screen.add.viewmodel.NumberTypeInputsViewModel
import com.mateuszgrabarski.habittracker.resources.R
import org.koin.androidx.compose.getViewModel

@Composable
fun NumberHabitTypeInputs(
    onFilledNumbers: (FilledHabitTypeInputs) -> Unit
) {
    val viewModel = getViewModel<NumberTypeInputsViewModel>()

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
            Text(text = stringResource(id = R.string.add_habit_fill_inputs_title))
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth(),
                value = viewModel.goal,
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                onValueChange = {
                    viewModel.updateGoal(goal = it)
                    onFilledNumbers(viewModel.toFilledNumbers())
                },
                label = {
                    Text(text = stringResource(id = R.string.add_habit_goal_title))
                }
            )
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth(),
                value = viewModel.unit,
                onValueChange = {
                    viewModel.updateUnit(unit = it)
                    onFilledNumbers(viewModel.toFilledNumbers())
                },
                label = {
                    Text(text = stringResource(id = R.string.add_habit_unit_title))
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Preview(showSystemUi = true)
@Composable
private fun NumberHabitTypeInputsPreview() {
    NumberHabitTypeInputs(
        onFilledNumbers = {}
    )
}
