package com.mateuszgrabarski.habittracker.features.habits.add.ui.dialog

import android.app.TimePickerDialog
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.mateuszgrabarski.habittracker.features.habits.add.application.model.SelectedTime

@Composable
fun ChooseTimeDialog(
    hourOfDay: Int = 0,
    minutes: Int = 0,
    onSelectedTime: (SelectedTime) -> Unit
) {
    TimePickerDialog(
        LocalContext.current,
        { _, hour: Int, minute: Int ->
            onSelectedTime(
                SelectedTime(
                    hours = hour,
                    minutes = minute
                )
            )
        },
        hourOfDay,
        minutes,
        true
    ).show()
}
