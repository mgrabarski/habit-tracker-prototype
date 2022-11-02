package com.mateuszgrabarski.habittracker.features.habits.add.ui.screen

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
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
import com.mateuszgrabarski.habittracker.features.habits.add.ui.AddNewHabitViewModel
import com.mateuszgrabarski.habittracker.features.habits.add.ui.dialog.ChooseHabitIconDialog
import com.mateuszgrabarski.habittracker.features.habits.add.ui.screen.add.ChooseIconCard
import com.mateuszgrabarski.habittracker.features.habits.add.ui.screen.add.HabitTypeCard
import com.mateuszgrabarski.habittracker.features.habits.add.ui.screen.add.NameAndDescriptionCard
import com.mateuszgrabarski.habittracker.resources.R.string.add_habit_next_btn
import org.koin.androidx.compose.getViewModel

@Composable
fun AddNewHabitScreen(
    onMoveToDurationSet: () -> Unit
) {
    val viewModel = getViewModel<AddNewHabitViewModel>()

    var showDialog by remember { mutableStateOf(false) }

    if (showDialog)
        ChooseHabitIconDialog(
            setShowDialog = {
                showDialog = it
            }, iconReady = {
                viewModel.updateSelectedIcon(
                    icon = it
                )
                showDialog = false
            }
        )

    Column(
        modifier = Modifier
            .background(color = MaterialTheme.colors.background)
            .fillMaxSize()
            .padding(all = 8.dp)
            .verticalScroll(
                state = rememberScrollState()
            )
    ) {
        ChooseIconCard(
            selectedIcon = viewModel.selectedIcon,
            showDialog = {
                showDialog = true
            }
        )
        NameAndDescriptionCard(
            habitName = viewModel.habitName,
            description = viewModel.habitDescription,
            onHabitNameChange = {
                viewModel.updateHabitName(name = it)
            },
            onDescriptionChange = {
                viewModel.updateHabitDescription(description = it)
            }
        )
        HabitTypeCard(
            viewModel = viewModel
        )
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp, end = 8.dp),
            onClick = {
                onMoveToDurationSet()
            },
            enabled = viewModel.nextButtonEnabled
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
