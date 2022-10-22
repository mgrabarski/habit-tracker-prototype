@file:OptIn(ExperimentalMaterialNavigationApi::class)

package com.mateuszgrabarski.habittracker.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.plusAssign
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import com.google.accompanist.navigation.material.ModalBottomSheetLayout
import com.google.accompanist.navigation.material.rememberBottomSheetNavigator
import com.mateuszgrabarski.habittracker.ui.screens.bottombar.BottomBar
import com.mateuszgrabarski.habittracker.ui.screens.bottombar.BottomBarDestination
import com.mateuszgrabarski.habittracker.ui.screens.destinations.Destination
import com.mateuszgrabarski.habittracker.ui.screens.topbar.TopBarSelection
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
        topBar = { destination, _ ->
            TopBarSelection(
                destination = destination,
                navController = navController
            )
        },
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
