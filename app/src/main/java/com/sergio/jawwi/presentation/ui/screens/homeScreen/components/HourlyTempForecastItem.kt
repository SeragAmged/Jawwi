package com.sergio.jawwi.presentation.ui.screens.homeScreen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.sergio.jawwi.core.theme.WeatherTheme
import java.time.LocalTime

/**
 * A composable that displays hourly temperature forecast information.
 * 
 * This component is a specialized implementation of HourlyForecastItem that displays
 * temperature data for a specific hour. It shows:
 * - The time at the top
 * - A weather icon in the middle representing the weather condition at that hour
 * - The temperature value at the bottom
 *
 * The component is used in the HourlyForecastSection when the user selects the temperature tab,
 * which is the default view.
 *
 * @param time The local time for this hourly forecast
 * @param temp The temperature value as a formatted string (e.g., "23°")
 * @param icon The icon identifier string that determines which weather icon to display
 */
@Composable
fun HourlyTempForecastItem(
    time: LocalTime, temp: String, icon: String?
) {
    HourlyForecastItem(
        time = time,
        valueWithNotation = temp,

        ) { _ ->
        Image(
            painterResource(WeatherTheme.fromIcon(icon).icon),
            contentDescription = null,
            modifier = Modifier.padding(8.dp)
        )
    }
}
