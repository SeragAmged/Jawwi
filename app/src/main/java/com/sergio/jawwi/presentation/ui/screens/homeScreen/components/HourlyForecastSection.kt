package com.sergio.jawwi.presentation.ui.screens.homeScreen.components

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sergio.jawwi.R
import com.sergio.jawwi.core.theme.LocalWeatherTheme
import com.sergio.jawwi.data.models.WeatherForecastDataModel
import com.sergio.jawwi.presentation.ui.components.ExpandableCard
import java.time.LocalTime

/**
 * A composable that displays the hourly weather forecast section.
 *
 * This component provides a horizontally scrollable list of hourly weather forecasts
 * with tabs to switch between different types of forecasts (temperature, humidity, wind).
 * It's displayed as an expandable card that can be collapsed to save space.
 *
 * The component handles state management for the selected forecast type and renders
 * the appropriate forecast items based on the selection.
 *
 * @param hours List of hourly weather forecast data models to display
 * @param modifier Optional modifier for customizing the layout
 */
@SuppressLint("UnrememberedMutableState")
@Composable
fun HourlyForecastSection(hours: List<WeatherForecastDataModel>?, modifier: Modifier = Modifier) {
    if (hours == null) return

    var selectedType by rememberSaveable { mutableIntStateOf(0) }
    val listState = rememberLazyListState()


    val startIndex =
        hours.indexOfFirst { (it.datetime as? LocalTime)?.hour == LocalTime.now().hour }

    LaunchedEffect(startIndex) { listState.scrollToItem(startIndex) }

    ExpandableCard(
        modifier = modifier,
    ) { expanded ->
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(16.dp)
        ) {
            Text(
                text = "Hourly Forecast",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = LocalWeatherTheme.current.textColor,
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 12.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                ExpandableForecastTitle(
                    icon = R.drawable.temp_ic,
                    title = "Temperature",
                    expandedState = mutableStateOf(selectedType == 0),
                    onExpanded = { selectedType = 0 }
                )
                ExpandableForecastTitle(
                    icon = R.drawable.humidity_ic,
                    title = "Humidity",
                    expandedState = mutableStateOf(selectedType == 1),
                    onExpanded = { selectedType = 1 }
                )
                ExpandableForecastTitle(
                    icon = R.drawable.wind_ic,
                    title = "Wind",
                    expandedState = mutableStateOf(selectedType == 2),
                    onExpanded = { selectedType = 2 }
                )
            }

            LazyRow(
                state = listState,
                modifier = Modifier.fillMaxHeight(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)

            ) {
                items(hours.size) {
                    when (selectedType) {
                        0 -> HourlyTempForecastItem(
                            time = hours[it].datetime as LocalTime,
                            temp = "${hours[it].temp}°",
                            icon = hours[it].icon,
                        )

                        1 -> HourlyHumidityForecastItem(
                            time = hours[it].datetime as LocalTime,
                            humidity = hours[it].humidity,
                        )

                        2 -> HourlyWindForecastItem(
                            time = hours[it].datetime as LocalTime,
                            windSpeed = hours[it].windSpeed ?: 0,
                            windDirection = hours[it].windDir?.toInt() ?: 0
                        )
                    }

                }
            }
        }
    }
}
