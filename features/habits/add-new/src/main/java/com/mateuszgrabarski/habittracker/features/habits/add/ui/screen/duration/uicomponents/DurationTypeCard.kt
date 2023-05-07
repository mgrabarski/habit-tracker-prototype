package com.mateuszgrabarski.habittracker.features.habits.add.ui.screen.duration.uicomponents

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.Card
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mateuszgrabarski.habittracker.business.data.models.habits.options.HabitDuration
import com.mateuszgrabarski.habittracker.resources.R

@Composable
fun DurationTypeCard(
    selectedDuration: HabitDuration,
    updateSelectedDuration: (HabitDuration) -> Unit
) {
    Card(
        modifier = Modifier
            .padding(all = 8.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 8.dp)
        ) {
            Text(text = stringResource(id = R.string.add_habit_duration_title))

            HabitDuration.getSelectableTypes()
                .forEach {
                    Row(
                        modifier = Modifier
                            .selectable(
                                selected = selectedDuration == it,
                                onClick = {
                                    updateSelectedDuration(it)
                                },
                                role = Role.RadioButton
                            )
                            .padding(all = 8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = selectedDuration == it,
                            onClick = null
                        )
                        Text(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 8.dp),
                            text = stringResource(id = it.stringId)
                        )
                    }
                }
        }
    }
}

@Preview(showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Preview(showSystemUi = true)
@Composable
private fun DurationTypeCardPreview() {
    DurationTypeCard(
        selectedDuration = HabitDuration.EveryDay,
        updateSelectedDuration = {}
    )
}
