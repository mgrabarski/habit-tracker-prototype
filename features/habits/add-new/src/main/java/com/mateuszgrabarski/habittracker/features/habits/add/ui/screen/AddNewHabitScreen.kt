package com.mateuszgrabarski.habittracker.features.habits.add.ui.screen

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mateuszgrabarski.habittracker.business.habits.HabitType
import com.mateuszgrabarski.habittracker.features.habits.add.ui.AddNewHabitViewModel
import com.mateuszgrabarski.habittracker.features.habits.add.ui.dialog.ChooseHabitIconDialog
import com.mateuszgrabarski.habittracker.features.habits.add.ui.model.SelectedIcon
import com.mateuszgrabarski.habittracker.resources.R.drawable.ic_habit_icon_not_selected
import com.mateuszgrabarski.habittracker.resources.R.string.add_habit_choose_icon_title
import com.mateuszgrabarski.habittracker.resources.R.string.add_habit_choose_type_title
import com.mateuszgrabarski.habittracker.resources.R.string.add_habit_habit_description
import com.mateuszgrabarski.habittracker.resources.R.string.add_habit_habit_name
import com.mateuszgrabarski.habittracker.resources.R.string.add_habit_next_btn
import com.mateuszgrabarski.habittracker.resources.R.string.add_habit_select_icon
import com.mateuszgrabarski.habittracker.resources.ui.components.spinner.SelectableSpinner
import com.mateuszgrabarski.habittracker.resources.ui.theme.BorderColor
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

@Composable
private fun NameAndDescriptionCard(
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
                onValueChange = {
                    onHabitNameChange(it)
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
                    onDescriptionChange(it)
                },
                label = {
                    Text(text = stringResource(id = add_habit_habit_description))
                }
            )
        }
    }
}

@Composable
private fun ChooseIconCard(
    showDialog: () -> Unit,
    selectedIcon: SelectedIcon?
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 8.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = stringResource(id = add_habit_choose_icon_title))

            Spacer(modifier = Modifier.height(height = 8.dp))

            Box(
                modifier = Modifier
                    .border(
                        width = 2.dp,
                        color = MaterialTheme.colors.BorderColor,
                        shape = MaterialTheme.shapes.medium
                    )
                    .clickable {
                        showDialog()
                    }
            ) {
                if (selectedIcon == null) {
                    Icon(
                        modifier = Modifier.size(size = 120.dp),
                        painter = painterResource(id = ic_habit_icon_not_selected),
                        contentDescription = stringResource(id = add_habit_select_icon)
                    )
                } else {
                    Icon(
                        modifier = Modifier
                            .size(size = 120.dp)
                            .padding(all = 8.dp),
                        painter = painterResource(id = selectedIcon.icon.iconId),
                        contentDescription = null,
                        tint = Color(selectedIcon.color)
                    )
                }
            }
        }
    }
}

@Composable
private fun HabitTypeCard(
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
                title = add_habit_choose_type_title,
                notSelectedOption = HabitType.getNotSelectableType(),
                options = HabitType.getSelectableTypes(),
                selectedOption = viewModel.habitType
            ) {
                viewModel.updateHabitType(type = it as HabitType)
            }

        }
    }
    when (viewModel.habitType) {
        HabitType.Number -> {
            NumberHabitTypeInputs()
        }
        HabitType.Timer -> {
            TimerHabitTypeInputs()
        }
        HabitType.YesOrNo -> {
        }
        else -> {
        }
    }
}

@Composable
private fun NumberHabitTypeInputs() {
    var unit by remember { mutableStateOf("") }
    var goal by remember { mutableStateOf("") }
    var number by remember { mutableStateOf("") }

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
            Text(text = "Fill inputs:")
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth(),
                value = unit,
                onValueChange = {
                    unit = it
                },
                label = {
                    Text(text = "Unit")
                }
            )
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth(),
                value = goal,
                onValueChange = {
                    goal = it
                },
                label = {
                    Text(text = "Goal")
                }
            )
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth(),
                value = number,
                onValueChange = {
                    number = it
                },
                label = {
                    Text(text = "Number")
                }
            )
        }
    }
}

@Composable
private fun TimerHabitTypeInputs() {
    var time by remember { mutableStateOf("") }

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
            Text(text = "Fill inputs:")
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth(),
                value = time,
                onValueChange = {
                    time = it
                },
                label = {
                    Text(text = "Number")
                }
            )
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
