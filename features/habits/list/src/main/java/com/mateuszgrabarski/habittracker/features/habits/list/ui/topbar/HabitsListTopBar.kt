package com.mateuszgrabarski.habittracker.features.habits.list.ui.topbar

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun HabitsListTopBar(
    navigateToAddNewHabit: () -> Unit
) {
    TopAppBar(
        title = {
            Text(text = "Habits list")
        },
        actions = {
            TopAppBarActionButton(
                imageVector = Icons.Outlined.Add,
                description = "Add"
            ) {
                navigateToAddNewHabit()
            }
        }
    )
}

@Composable
fun TopAppBarActionButton(
    imageVector: ImageVector,
    description: String,
    onClick: () -> Unit
) {
    IconButton(onClick = {
        onClick()
    }) {
        Icon(imageVector = imageVector, contentDescription = description)
    }
}
