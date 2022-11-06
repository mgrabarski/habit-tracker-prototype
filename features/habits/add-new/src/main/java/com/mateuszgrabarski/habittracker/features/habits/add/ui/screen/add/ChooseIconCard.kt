package com.mateuszgrabarski.habittracker.features.habits.add.ui.screen.add

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.mateuszgrabarski.habittracker.features.habits.add.application.model.SelectedIcon
import com.mateuszgrabarski.habittracker.resources.R
import com.mateuszgrabarski.habittracker.resources.ui.theme.BorderColor

@Composable
fun ChooseIconCard(
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
            Text(text = stringResource(id = R.string.add_habit_choose_icon_title))

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
                        painter = painterResource(id = R.drawable.ic_habit_icon_not_selected),
                        contentDescription = stringResource(id = R.string.add_habit_select_icon)
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
