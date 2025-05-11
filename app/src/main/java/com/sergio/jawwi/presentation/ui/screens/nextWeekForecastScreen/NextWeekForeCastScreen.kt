package com.sergio.jawwi.presentation.ui.screens.nextWeekForecastScreen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import com.sergio.jawwi.core.DummyData
import com.sergio.jawwi.core.theme.LocalWeatherTheme
import com.sergio.jawwi.data.models.WeatherDataModel
import com.sergio.jawwi.presentation.ui.screens.nextWeekForecastScreen.components.NextWeekForecastList
import com.sergio.jawwi.presentation.ui.screens.nextWeekForecastScreen.components.NextWeekForecastScreenTopBar


/**
 * A preview function for the Next Week Forecast screen.
 */
@Preview(
    showBackground = true,
    showSystemUi = true,
)
@Composable
fun NextWeekForecastScreenPreview() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(LocalWeatherTheme.current.gradient)

            )

    ) {
        NextWeekForecastScreen(DummyData.dummyWeatherDataModel.let { weatherData ->
            weatherData.copy(
                days = List(10) { weatherData.days }.flatten()
            )
        }, onBack = {})
    }
}


/**
 * A composable function that displays the Next Week Forecast screen.
 *
 * @param weatherData The weather data model containing forecast information.
 * @param onBack A lambda function to handle the back navigation action.
 */
@SuppressLint("UnrememberedMutableState")
@Composable
fun NextWeekForecastScreen(
    weatherData: WeatherDataModel?, onBack: () -> Unit
) {
    val days = weatherData?.days?.subList(0, minOf(7, weatherData.days.size)) ?: emptyList()


    Scaffold(

        topBar = { NextWeekForecastScreenTopBar(onBack) },

        ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(LocalWeatherTheme.current.gradient)

                )
                .padding(padding)

        ) {
            NextWeekForecastList(days)
        }
    }
}




