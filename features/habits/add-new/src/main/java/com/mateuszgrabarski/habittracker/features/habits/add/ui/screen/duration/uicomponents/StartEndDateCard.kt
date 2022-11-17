package com.mateuszgrabarski.habittracker.features.habits.add.ui.screen.duration.uicomponents

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mateuszgrabarski.habittracker.resources.R

@Composable
fun StartEndDateCard(
    startDate: String,
    endDate: String,
    showStartDateDialog: () -> Unit,
    showEndDateDialog: () -> Unit
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
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        showStartDateDialog()
                    },
                value = startDate,
                readOnly = true,
                enabled = false,
                onValueChange = {

                },
                label = {
                    Text(text = stringResource(id = R.string.add_habit_duration_start_date_title))
                }
            )
            Spacer(modifier = Modifier.height(height = 8.dp))
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        showEndDateDialog()
                    },
                value = endDate,
                readOnly = true,
                enabled = false,
                onValueChange = {

                },
                label = {
                    Text(text = stringResource(id = R.string.add_habit_duration_end_date_title))
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Preview(showSystemUi = true)
@Composable
private fun StartEndDateCardPreview() {
    StartEndDateCard(
        startDate = "start",
        endDate = "end",
        showStartDateDialog = {},
        showEndDateDialog = {}
    )
}
