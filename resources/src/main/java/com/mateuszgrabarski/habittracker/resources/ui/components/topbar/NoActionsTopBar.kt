package com.mateuszgrabarski.habittracker.resources.ui.components.topbar

import androidx.annotation.StringRes
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.mateuszgrabarski.habittracker.resources.ui.theme.topBarBackground
import com.mateuszgrabarski.habittracker.resources.ui.theme.topBarContent

@Composable
fun NoActionsTopBar(
    @StringRes title: Int
) {
    TopAppBar(
        backgroundColor = MaterialTheme.colors.topBarBackground,
        contentColor = MaterialTheme.colors.topBarContent,
        title = {
            Text(text = stringResource(id = title))
        }
    )
}
