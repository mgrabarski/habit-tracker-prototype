package com.mateuszgrabarski.habittracker.features.habits.add.ui.screen.base

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mateuszgrabarski.habittracker.features.habits.add.ui.dialog.ChooseTimeDialog
import com.mateuszgrabarski.habittracker.features.habits.add.application.model.FilledHabitTypeInputs
import com.mateuszgrabarski.habittracker.features.habits.add.application.model.TimeInputs
import com.mateuszgrabarski.habittracker.resources.R

@Composable
fun TimerHabitTypeInputs(
    onPickerTime: (FilledHabitTypeInputs) -> Unit
) {
    var time by remember { mutableStateOf("") }

    var showDialog by remember { mutableStateOf(false) }

    if (showDialog) {
        ChooseTimeDialog(
            onSelectedTime = {
                time = it.displayValues
                showDialog = false
                onPickerTime(
                    TimeInputs(
                        time = it
                    )
                )
            }
        )
    }

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
                    .fillMaxWidth()
                    .clickable {
                        showDialog = true
                    },
                value = time,
                readOnly = true,
                enabled = false,
                onValueChange = {
                    time = it
                },
                label = {
                    Text(text = stringResource(id = R.string.add_habit_time_title))
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Preview(showSystemUi = true)
@Composable
private fun TimerHabitTypeInputsPreview() {
    TimerHabitTypeInputs(
        onPickerTime = {}
    )
}
