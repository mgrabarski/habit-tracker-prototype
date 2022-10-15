@file:OptIn(ExperimentalMaterialNavigationApi::class)

package com.mateuszgrabarski.habittracker.ui.screens

import android.util.Log
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.plusAssign
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import com.google.accompanist.navigation.material.ModalBottomSheetLayout
import com.google.accompanist.navigation.material.rememberBottomSheetNavigator
import com.mateuszgrabarski.habittracker.resources.R.string.bottomBar1
import com.mateuszgrabarski.habittracker.resources.R.string.bottomBar2
import com.mateuszgrabarski.habittracker.resources.R.string.bottomBar3
import com.mateuszgrabarski.habittracker.resources.R.string.bottomBar4
import com.mateuszgrabarski.habittracker.ui.screens.bottombar.NavGraphs
import com.mateuszgrabarski.habittracker.ui.screens.bottombar.appCurrentDestinationAsState
import com.mateuszgrabarski.habittracker.ui.screens.bottombar.destinations.Destination
import com.mateuszgrabarski.habittracker.ui.screens.bottombar.destinations.HabitsScreenDestination
import com.mateuszgrabarski.habittracker.ui.screens.bottombar.destinations.NotesScreenDestination
import com.mateuszgrabarski.habittracker.ui.screens.bottombar.destinations.StatsScreenDestination
import com.mateuszgrabarski.habittracker.ui.screens.bottombar.destinations.TaskScreenDestination
import com.mateuszgrabarski.habittracker.ui.screens.bottombar.startAppDestination
import com.mateuszgrabarski.habittracker.ui.screens.components.BottomBar
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.rememberNavHostEngine
import com.ramcosta.composedestinations.spec.Route

@Composable
fun HomeScreenView() {
    val engine = rememberNavHostEngine()
    val navController = engine.rememberNavController()

    AppScaffold(
        startRoute = NavGraphs.root.startRoute,
        bottomBar = {
            if (it.shouldShowBottomBar) {
                BottomBar(navController)
            }
        },
        topBar = null,
        navController = navController
    ) {
        DestinationsNavHost(
            engine = engine,
            navController = navController,
            navGraph = NavGraphs.root,
            modifier = Modifier.padding(it),
            startRoute = NavGraphs.root.startRoute
        )
    }
}

@Composable
fun AppScaffold(
    startRoute: Route,
    navController: NavController,
    topBar: @Composable ((Destination, NavBackStackEntry?) -> Unit)?,
    bottomBar: @Composable (Destination) -> Unit,
    content: @Composable (PaddingValues) -> Unit
) {
    val destination = navController.appCurrentDestinationAsState().value
        ?: startRoute.startAppDestination
    val navBackStackEntry = navController.currentBackStackEntry

    navController.backQueue.printStack()

    val bottomSheetNavigator = rememberBottomSheetNavigator()
    navController.navigatorProvider += bottomSheetNavigator

    ModalBottomSheetLayout(
        bottomSheetNavigator = bottomSheetNavigator,
        sheetShape = RoundedCornerShape(16.dp)
    ) {
        Scaffold(
            topBar = { topBar?.invoke(destination, navBackStackEntry) },
            bottomBar = { bottomBar(destination) },
            content = content
        )
    }
}

private fun ArrayDeque<NavBackStackEntry>.printStack() {
    val stack = map { it.destination.route }.toTypedArray().contentToString()
    Log.d("Home", "print: stack = $stack")
}

private val Destination.shouldShowBottomBar
    get() = BottomBarDestination.values().map { it.direction }.contains(this)

enum class BottomBarDestination(
    val direction: Destination,
    val icon: ImageVector,
    @StringRes val label: Int
) {
    Habits(HabitsScreenDestination, Icons.Default.Home, bottomBar1),
    Stats(StatsScreenDestination, Icons.Default.Star, bottomBar2),
    Notes(NotesScreenDestination, Icons.Default.Notifications, bottomBar3),
    Tasks(TaskScreenDestination, Icons.Default.Done, bottomBar4)
}
