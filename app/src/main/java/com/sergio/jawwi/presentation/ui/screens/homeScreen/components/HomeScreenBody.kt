package com.sergio.jawwi.presentation.ui.screens.homeScreen.components

import android.os.Handler
import android.os.Looper
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sergio.jawwi.core.DummyData

import com.sergio.jawwi.core.theme.LocalWeatherTheme
import com.sergio.jawwi.data.models.WeatherDataModel
import java.util.concurrent.Executors

/**
 * Preview composable for the HomeScreenBody.
 * 
 * This preview shows how the HomeScreenBody will appear with dummy weather data.
 */
@Preview(showBackground = true)
@Composable
fun HomeScreenBodyPreview() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(LocalWeatherTheme.current.gradient)
            )
    ) { HomeScreenBody({}, {}, weatherData = DummyData.dummyWeatherDataModel) }
}

/**
 * The main body composable for the home screen of the weather application.
 * 
 * This composable arranges all the components of the home screen in a scrollable column,
 * including the location display, current weather section, alerts (if any), weather details,
 * hourly forecast, and a button to navigate to the next 5 days forecast.
 * 
 * It also implements a pull-to-refresh functionality that triggers the provided onRefresh callback.
 *
 * @param goToNext5Days Callback function to navigate to the 5-day forecast screen
 * @param onRefresh Callback function triggered when the user pulls to refresh
 * @param weatherData The weather data model containing all weather information to display
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenBody(
    goToNext5Days: () -> Unit,
    onRefresh: () -> Unit,
    weatherData: WeatherDataModel,

    ) {
    var isRefreshing by remember { mutableStateOf(false) }

    val executor = Executors.newSingleThreadExecutor()
    val mainHandler = Handler(Looper.getMainLooper())
    PullToRefreshBox(
        modifier = Modifier.fillMaxSize(),
        isRefreshing = isRefreshing,
        onRefresh = {
            isRefreshing = true
            executor.execute {
                Thread.sleep(2000)
                onRefresh()
                mainHandler.post {
                    isRefreshing = false
                }
            }
        }
    )
    {


        Column(
            modifier = Modifier
                .testTag("home_screen_content")
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 16.dp)
                .padding(bottom = 24.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            LocationTimeZone(weatherData.timezone)

            CurrentWeatherSection(weatherData)

            if (weatherData.alerts.isNotEmpty()) AlertsSection(weatherData)

            WeatherDetailsSection(weatherData)

            HourlyForecastSection(weatherData.days[0].hours)

            Spacer(Modifier.weight(1f))

            NextWeekForecastButton(goToNext5Days)
        }
    }

}