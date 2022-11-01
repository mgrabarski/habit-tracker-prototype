package com.mateuszgrabarski.habittracker.features.habits.add.ui.dialog

import android.content.res.Configuration
import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.mateuszgrabarski.habittracker.business.habits.HabitIcon
import com.mateuszgrabarski.habittracker.features.habits.add.ui.model.SelectedIcon
import com.mateuszgrabarski.habittracker.resources.R.drawable.ic_add
import com.mateuszgrabarski.habittracker.resources.R.drawable.ic_habit_icon_meditation

@Composable
fun ChooseHabitIconDialog(
    setShowDialog: (Boolean) -> Unit,
    setValue: (SelectedIcon) -> Unit
) {
    Dialog(
        onDismissRequest = {
            setShowDialog(false)
        }
    ) {
        Box(
            modifier = Modifier
                .background(color = Color.White)
        ) {
            Column(
                modifier = Modifier
                    .padding(20.dp)
            ) {
                HabitIcon.values().forEach {
                    Icon(
                        modifier = Modifier.clickable {
                            setValue(
                                SelectedIcon(
                                    icon = HabitIcon.Water,
                                    color = "some color"
                                )
                            )
                        },
                        painter = painterResource(id = it.iconId),
                        contentDescription = "",
                        tint = Color.Black
                    )
                }
            }
        }
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO, showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Preview(showSystemUi = true)
@Composable
private fun ChooseHabitIconDialogPreview() {
    ChooseHabitIconDialog(
        setShowDialog = {},
        setValue = {}
    )
}
