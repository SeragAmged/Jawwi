package com.sergio.jawwi.presentation.ui.screens.nextWeekForecastScreen.components

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import com.sergio.jawwi.data.models.WeatherForecastDataModel

/**
 * A composable function that displays a list of weather forecast cards for the next week.
 *
 * @param days A list of weather forecast data models for the upcoming days.
 */
@SuppressLint("UnrememberedMutableState")
@Composable
fun NextWeekForecastList(
    days: List<WeatherForecastDataModel>,

    ) {
    var expandedIndex by rememberSaveable { mutableIntStateOf(0) }
    LazyColumn(
        modifier = Modifier.testTag("next_week_forecast_list")
            .padding(horizontal = 16.dp)
            .background(Color.Transparent),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        items(days.size) { index ->
            DayForecastCard(
                days[index],
                expandedState = mutableStateOf(index == expandedIndex),
                onExpanded = { isExpanded ->
                    expandedIndex = if (isExpanded) index else -1 // Collapse all cards

                })
        }
    }
}

