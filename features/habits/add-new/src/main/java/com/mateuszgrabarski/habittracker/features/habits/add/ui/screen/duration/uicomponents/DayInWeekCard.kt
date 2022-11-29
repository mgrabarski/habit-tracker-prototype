package com.mateuszgrabarski.habittracker.features.habits.add.ui.screen.duration.uicomponents

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mateuszgrabarski.habittracker.features.habits.add.ui.screen.duration.model.week.WeekDay
import com.mateuszgrabarski.habittracker.resources.R.string.add_habit_duration_select_info

@Composable
fun DayInWeekCard(
    weekDays: List<WeekDay>,
    updateSelectedWeekDay: (WeekDay) -> Unit
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
            weekDays.chunked(size = 4).forEach {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(all = 8.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    it.forEach {
                        if (it.selected) {
                            Box(
                                modifier = Modifier
                                    .size(width = 60.dp, height = 30.dp)
                                    .clip(shape = MaterialTheme.shapes.medium)
                                    .background(color = MaterialTheme.colors.primary)
                                    .clickable(
                                        interactionSource = MutableInteractionSource(),
                                        indication = null
                                    ) {
                                        updateSelectedWeekDay(it)
                                    },
                                contentAlignment = Alignment.Center
                            ) {
                                Text(text = it.day.name)
                            }
                        } else {
                            Box(
                                modifier = Modifier
                                    .size(width = 60.dp, height = 30.dp)
                                    .clickable(
                                        interactionSource = MutableInteractionSource(),
                                        indication = null
                                    ) {
                                        updateSelectedWeekDay(it)
                                    },
                                contentAlignment = Alignment.Center
                            ) {
                                Text(text = it.day.name)
                            }
                        }
                    }
                }
            }
            Text(text = stringResource(id = add_habit_duration_select_info))
        }
    }
}

@Preview(showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Preview(showSystemUi = true)
@Composable
private fun DayInWeekCardPreview() {
    DayInWeekCard(
        weekDays = WeekDay.generateNotSelectedWeekDays().toMutableList().apply {
            this[0] = get(0).copy(selected = true)
        },
        updateSelectedWeekDay = {}
    )
}
