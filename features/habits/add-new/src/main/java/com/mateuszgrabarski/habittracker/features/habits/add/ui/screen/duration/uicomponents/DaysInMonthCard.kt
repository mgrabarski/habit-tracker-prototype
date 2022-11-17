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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mateuszgrabarski.habittracker.features.habits.add.ui.screen.duration.model.month.MonthDay
import com.mateuszgrabarski.habittracker.resources.R

@Composable
fun DaysInMonthCard(
    monthDays: List<MonthDay>,
    updateSelectedState: (MonthDay) -> Unit
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
            monthDays
                .chunked(size = 7)
                .forEach { numbers ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 8.dp, bottom = 8.dp),
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        numbers.forEach {
                            if (it.selected) {
                                SelectedDay(
                                    updateSelectedState = updateSelectedState,
                                    day = it
                                )
                            } else {
                                NotSelectedDay(
                                    updateSelectedState = updateSelectedState,
                                    day = it
                                )
                            }
                        }
                    }
                }
            Text(text = stringResource(id = R.string.add_habit_duration_select_info))
        }
    }
}

@Composable
private fun SelectedDay(
    updateSelectedState: (MonthDay) -> Unit,
    day: MonthDay
) {
    Box(
        modifier = Modifier
            .size(size = 30.dp)
            .clip(shape = MaterialTheme.shapes.medium)
            .background(color = MaterialTheme.colors.primary)
            .clickable(
                interactionSource = MutableInteractionSource(),
                indication = null
            ) {
                updateSelectedState(day)
            },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "${day.dayNumber}",
            color = Color.White
        )
    }
}

@Composable
private fun NotSelectedDay(
    updateSelectedState: (MonthDay) -> Unit,
    day: MonthDay
) {
    Box(
        modifier = Modifier
            .size(size = 30.dp)
            .clickable(
                interactionSource = MutableInteractionSource(),
                indication = null
            ) {
                updateSelectedState(day)
            },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "${day.dayNumber}",
            color = Color.White
        )
    }
}

@Preview(showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Preview(showSystemUi = true)
@Composable
private fun DaysInMonthCardPreview() {
    DaysInMonthCard(
        monthDays = MonthDay.generateNotSelectedDays().toMutableList().apply {
            this[5] = this[5].copy(selected = true)
        },
        updateSelectedState = {}
    )
}
