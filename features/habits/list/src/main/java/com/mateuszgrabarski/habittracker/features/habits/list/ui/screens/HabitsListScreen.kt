package com.mateuszgrabarski.habittracker.features.habits.list.ui.screens

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.content.res.Configuration.UI_MODE_TYPE_NORMAL
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import com.mateuszgrabarski.habittracker.business.services.cache.HabitCacheDataSource
import com.mateuszgrabarski.habittracker.business.usecases.UseCaseWithResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.koin.androidx.compose.getViewModel

@Composable
fun HabitsListScreen() {
    val viewModel = getViewModel<HabitsListScreenViewModel>()
    val habits = viewModel.habits.collectAsState(initial = emptyList())

    HabitsListScreenContent(
        habits = habits.value
    )
}

@Composable
fun HabitsListScreenContent(
    habits: List<HabitUi>
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ) {
        items(items = habits) { habit ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(text = habit.name)
            }
        }
    }
}

class HabitsListScreenViewModel(
    loadHabitsList: LoadHabitsList
) : ViewModel() {

    val habits = (loadHabitsList.load() as UseCaseWithResult.Success).value
}

interface LoadHabitsList {

    fun load(): UseCaseWithResult<Flow<List<HabitUi>>>
}

class LoadHabitsListImpl(
    private val dataSource: HabitCacheDataSource
) : LoadHabitsList {
    override fun load(): UseCaseWithResult<Flow<List<HabitUi>>> =
        UseCaseWithResult.Success(
            value = dataSource.loadAll().map { habits ->
                habits.map {
                    HabitUi(
                        name = it.name
                    )
                }
            }
        )
}

data class HabitUi(
    val name: String
)

@Preview(showBackground = true)
@Composable
private fun HabitsListScreenPreview() {
    HabitsListScreenContent(
        habits = listOf(
            HabitUi(name = "Habit 1"),
            HabitUi(name = "Habit 2"),
            HabitUi(name = "Habit 3")
        )
    )
}
