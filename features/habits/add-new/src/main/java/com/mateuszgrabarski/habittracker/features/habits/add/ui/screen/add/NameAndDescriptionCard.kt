package com.mateuszgrabarski.habittracker.features.habits.add.ui.screen.add

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
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.mateuszgrabarski.habittracker.resources.R

@Composable
fun NameAndDescriptionCard(
    habitName: String,
    description: String,
    onHabitNameChange: (String) -> Unit,
    onDescriptionChange: (String) -> Unit
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
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth(),
                value = habitName,
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
                onValueChange = {
                    onHabitNameChange(it)
                },
                label = {
                    Text(text = stringResource(id = R.string.add_habit_habit_name))
                }
            )
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth(),
                value = description,
                onValueChange = {
                    onDescriptionChange(it)
                },
                label = {
                    Text(text = stringResource(id = R.string.add_habit_habit_description))
                }
            )
        }
    }
}
