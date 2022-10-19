package com.mateuszgrabarski.habittracker.features.habits.list.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun HabitsListScreen() {
    Column {
        Text(text = "here will be list of habits")
    }
}

@Preview
@Composable
private fun HabitsListScreenPreview() {
    HabitsListScreen()
}
