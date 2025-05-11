package com.sergio.jawwi.presentation.ui.screens.homeScreen.components

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import java.time.LocalTime

/**
 * A composable that displays hourly humidity forecast information.
 * 
 * This component is a specialized implementation of HourlyForecastItem that displays
 * humidity data for a specific hour. It shows:
 * - The time at the top
 * - A vertical humidity bar in the middle that visually represents the humidity level
 * - The humidity percentage at the bottom
 *
 * The component is used in the HourlyForecastSection when the user selects the humidity tab.
 *
 * @param time The local time for this hourly forecast
 * @param humidity The humidity percentage value (0-100)
 */
@Composable
fun HourlyHumidityForecastItem(
    time: LocalTime, humidity: Int?
) {
    if (humidity == null) return

    HourlyForecastItem(
        time = time,
        valueWithNotation = "${humidity}%",
    ) { _ ->
        VerticalHumidityBar(
            humidity
            = humidity,
            modifier = Modifier
                .fillMaxHeight(.8f)
                .fillMaxWidth(0.5f)
        )

    }
}
