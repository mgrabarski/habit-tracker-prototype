package com.mateuszgrabarski.habittracker.features.habits.add.ui.screen

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mateuszgrabarski.habittracker.business.habits.HabitType
import com.mateuszgrabarski.habittracker.resources.R.drawable.ic_habit_icon_not_selected
import com.mateuszgrabarski.habittracker.resources.R.string.add_habit_habit_description
import com.mateuszgrabarski.habittracker.resources.R.string.add_habit_habit_name
import com.mateuszgrabarski.habittracker.resources.R.string.add_habit_next_btn
import com.mateuszgrabarski.habittracker.resources.R.string.add_habit_select_icon
import com.mateuszgrabarski.habittracker.resources.R.string.habit_type_check_list
import com.mateuszgrabarski.habittracker.resources.ui.components.spinner.SelectableSpinner
import com.mateuszgrabarski.habittracker.resources.ui.theme.BorderColor

@Composable
fun AddNewHabitScreen(
    onMoveToDurationSet: () -> Unit
) {
    val scrollState = rememberScrollState()
    var habitName by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .background(color = MaterialTheme.colors.background)
            .fillMaxSize()
            .padding(all = 8.dp)
            .verticalScroll(
                state = scrollState
            )
    ) {
        Text(text = "Choose icon")
        Box(
            modifier = Modifier
                .border(
                    width = 2.dp,
                    color = MaterialTheme.colors.BorderColor,
                    shape = MaterialTheme.shapes.medium
                )
                .clickable {
                }
        ) {
            Icon(
                painter = painterResource(id = ic_habit_icon_not_selected),
                contentDescription = stringResource(id = add_habit_select_icon)
            )
        }
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = habitName,
            onValueChange = {
                habitName = it
            },
            label = {
                Text(text = stringResource(id = add_habit_habit_name))
            }
        )
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = description,
            onValueChange = {
                description = it
            },
            label = {
                Text(text = stringResource(id = add_habit_habit_description))
            }
        )
        var selectedOptionText by remember { mutableStateOf(HabitType.getNotSelectableType()) }
        SelectableSpinner(
            title = habit_type_check_list,
            notSelectedOption = HabitType.getNotSelectableType(),
            options = HabitType.getSelectableTypes(),
            selectedOption = selectedOptionText
        ) {
            selectedOptionText = it as HabitType
        }

        when (selectedOptionText) {
            HabitType.Number -> {
                Column(modifier = Modifier.fillMaxWidth()) {
                    Text(text = "Unit")
                    Text(text = "Goal")
                    Text(text = "Number")
                }
            }
            HabitType.Timer -> {
                Column(modifier = Modifier.fillMaxWidth()) {
                    Text(text = "Time")
                }
            }
            HabitType.CheckList -> {
                Column(modifier = Modifier.fillMaxWidth()) {
                    Text(text = "TODO list")
                }
            }
            HabitType.YesOrNo -> Unit
            else -> Unit
        }

        Button(
            modifier = Modifier
                .fillMaxWidth(),
            onClick = {
                onMoveToDurationSet()
            }
        ) {
            Text(text = stringResource(id = add_habit_next_btn))
        }
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO, showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Preview(showSystemUi = true)
@Composable
private fun AddNewHabitScreenPreview() {
    AddNewHabitScreen(onMoveToDurationSet = {})
}
