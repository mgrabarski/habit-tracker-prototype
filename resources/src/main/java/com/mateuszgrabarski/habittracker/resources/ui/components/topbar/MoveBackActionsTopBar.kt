package com.mateuszgrabarski.habittracker.resources.ui.components.topbar

import androidx.annotation.StringRes
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.mateuszgrabarski.habittracker.resources.R
import com.mateuszgrabarski.habittracker.resources.ui.theme.topBarBackground
import com.mateuszgrabarski.habittracker.resources.ui.theme.topBarContent

@Composable
fun MoveBackActionsTopBar(
    @StringRes title: Int,
    navigateBack: () -> Unit
) {
    TopAppBar(
        backgroundColor = MaterialTheme.colors.topBarBackground,
        contentColor = MaterialTheme.colors.topBarContent,
        title = {
            Text(text = stringResource(id = title))
        },
        navigationIcon = {
            IconButton(
                onClick = { navigateBack() }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_arrow_back),
                    contentDescription = stringResource(id = R.string.top_bar_back_action)
                )
            }
        }
    )
}
