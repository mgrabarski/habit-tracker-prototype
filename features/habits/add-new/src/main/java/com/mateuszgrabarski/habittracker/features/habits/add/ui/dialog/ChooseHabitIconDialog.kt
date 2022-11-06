package com.mateuszgrabarski.habittracker.features.habits.add.ui.dialog

import android.content.res.Configuration
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.lifecycle.ViewModel
import com.mateuszgrabarski.habittracker.business.habits.HabitIcon
import com.mateuszgrabarski.habittracker.features.habits.add.const.NUMBER_OF_COLORS_IN_ROW
import com.mateuszgrabarski.habittracker.features.habits.add.const.NUMBER_OF_ICONS_IN_ROW
import com.mateuszgrabarski.habittracker.features.habits.add.application.model.SelectedIcon
import com.mateuszgrabarski.habittracker.resources.ui.theme.availableColors
import org.koin.androidx.compose.getViewModel

@Composable
fun ChooseHabitIconDialog(
    setShowDialog: (Boolean) -> Unit,
    iconReady: (SelectedIcon) -> Unit
) {
    val viewModel = getViewModel<ChooseHabitIconDialogViewModel>()

    Dialog(
        onDismissRequest = {
            setShowDialog(false)
        }
    ) {
        Box(
            modifier = Modifier
                .height(height = 350.dp)
                .background(color = Color.White),
            contentAlignment = Alignment.Center
        ) {
            if (viewModel.selectedIcon == null) {
                SelectIconContent(viewModel = viewModel)
            } else {
                SelectColorContent(viewModel = viewModel, iconReady = iconReady)
            }
        }
    }
}

@Composable
private fun SelectIconContent(
    viewModel: ChooseHabitIconDialogViewModel
) {
    Column(
        modifier = Modifier
            .padding(20.dp)
    ) {
        HabitIcon.values()
            .toList()
            .chunked(size = NUMBER_OF_ICONS_IN_ROW)
            .forEach { row ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(all = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    row.forEach {
                        HabitIconToSelect(
                            viewModel = viewModel,
                            icon = it
                        )
                    }
                }
            }
    }
}

@Composable
private fun SelectColorContent(
    viewModel: ChooseHabitIconDialogViewModel,
    iconReady: (SelectedIcon) -> Unit
) {
    Column(
        modifier = Modifier
            .padding(20.dp)
            .verticalScroll(state = rememberScrollState())
    ) {
        availableColors
            .chunked(size = NUMBER_OF_COLORS_IN_ROW)
            .forEach { row ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(all = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    row.forEach {
                        Canvas(
                            modifier = Modifier
                                .size(size = 30.dp)
                                .clickable {
                                    viewModel.updateSelectedColor(it.toArgb())
                                    iconReady(viewModel.toSelectedIcon())
                                    viewModel.reset()
                                }
                        ) {
                            drawCircle(color = it)
                        }
                    }
                }
            }
    }
}

@Composable
private fun HabitIconToSelect(
    viewModel: ChooseHabitIconDialogViewModel,
    icon: HabitIcon
) {
    Icon(
        modifier = Modifier
            .size(size = 30.dp)
            .clickable {
                viewModel.updateSelectedIcon(icon = icon)
            },
        painter = painterResource(id = icon.iconId),
        contentDescription = "",
        tint = Color.Black
    )
}

class ChooseHabitIconDialogViewModel : ViewModel() {

    var selectedIcon by mutableStateOf<HabitIcon?>(null)
        private set

    var selectedColor by mutableStateOf(0)
        private set

    fun updateSelectedIcon(icon: HabitIcon) {
        selectedIcon = icon
    }

    fun updateSelectedColor(color: Int) {
        selectedColor = color
    }

    fun toSelectedIcon(): SelectedIcon {
        val icon = selectedIcon ?: throw IllegalArgumentException("Icon was not selected")
        return SelectedIcon(
            icon = icon,
            color = selectedColor
        )
    }

    fun reset() {
        selectedIcon = null
        selectedColor = 0
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO, showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Preview(showSystemUi = true)
@Composable
private fun ChooseHabitIconDialogPreview() {
    ChooseHabitIconDialog(
        setShowDialog = {},
        iconReady = {}
    )
}
