package com.mateuszgrabarski.habittracker.resources.ui.components

import android.content.res.Configuration
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.mateuszgrabarski.habittracker.resources.R
import com.mateuszgrabarski.habittracker.resources.ui.theme.TopAppBarActionButton

@Composable
fun TopAppBarActionButton(
    @DrawableRes icon: Int,
    @StringRes contentDescription: Int,
    onClick: () -> Unit
) {
    IconButton(
        onClick = {
            onClick()
        }
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = stringResource(id = contentDescription),
            tint = MaterialTheme.colors.TopAppBarActionButton
        )
    }
}

@Preview
@Composable
private fun TopAppBarActionButtonLight() {
    TopAppBarActionButton(
        icon = R.drawable.ic_add,
        contentDescription = R.string.add_habit_action,
        onClick = {}
    )
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun TopAppBarActionButtonDark() {
    TopAppBarActionButton(
        icon = R.drawable.ic_add,
        contentDescription = R.string.add_habit_action,
        onClick = {}
    )
}
