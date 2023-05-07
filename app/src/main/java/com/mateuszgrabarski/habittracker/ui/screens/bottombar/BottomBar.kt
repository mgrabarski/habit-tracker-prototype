package com.mateuszgrabarski.habittracker.ui.screens.bottombar

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.mateuszgrabarski.habittracker.resources.ui.theme.bottomBarBackground
import com.mateuszgrabarski.habittracker.resources.ui.theme.bottomBarContent

@Composable
fun BottomBar(
    navController: NavController
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    BottomNavigation(
        backgroundColor = MaterialTheme.colors.bottomBarBackground,
        contentColor = MaterialTheme.colors.bottomBarContent
    ) {
        BottomBarDestination.values().forEach { destination ->
            BottomNavigationItem(
                selected = currentDestination?.hierarchy?.any {
                    it.route == destination.direction.route
                } == true,
                onClick = {
                    navController.navigate(route = destination.direction.route) {
                        popUpTo(id = navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    Icon(
                        painter = painterResource(id = destination.icon),
                        contentDescription = stringResource(id = destination.label)
                    )
                },
                label = {
                    Text(text = stringResource(id = destination.label))
                }
            )
        }
    }
}
