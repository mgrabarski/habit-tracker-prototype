package com.mateuszgrabarski.habittracker.ui.screens.bottombar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.mateuszgrabarski.habittracker.ui.screens.bottombar.destinations.FullScreenViewDestination
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@RootNavGraph(start = true)
@Destination
@Composable
fun HabitsScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Red)
    )
}

@Destination
@Composable
fun StatsScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Green)
    )
}

@Destination
@Composable
fun NotesScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Blue)
    )
}

@Destination
@Composable
fun TaskScreen(
    navigator: DestinationsNavigator
) {
    Column(modifier = Modifier.fillMaxSize()) {
        Button(onClick = {
            navigator.navigate(FullScreenViewDestination)
        }) {
            Text(text = "move to some full screen view")
        }
    }
}

@Destination
@Composable
fun FullScreenView() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black)
    )
}
