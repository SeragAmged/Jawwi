package com.sergio.jawwi.presentation.ui.screens.homeScreen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.sergio.jawwi.R
import com.sergio.jawwi.core.theme.LocalWeatherTheme
import java.time.LocalTime

/**
 * A composable that displays hourly wind forecast information.
 * 
 * This component is a specialized implementation of HourlyForecastItem that displays
 * wind data for a specific hour. It shows:
 * - The time at the top
 * - A directional arrow in the middle that rotates to indicate wind direction
 * - The wind speed value at the bottom
 *
 * The component is used in the HourlyForecastSection when the user selects the wind tab.
 * The arrow's rotation is determined by the wind direction in degrees.
 *
 * @param windSpeed The wind speed in km/h
 * @param windDirection The wind direction in degrees (0-360)
 * @param time The local time for this hourly forecast
 */
@Composable
fun HourlyWindForecastItem(windSpeed: Int, windDirection: Int, time: LocalTime) {

    HourlyForecastItem(
        time = time,
        valueWithNotation = "$windSpeed km/h",
        direction = windDirection,
    ) { direction ->
        Image(
            painter = painterResource(id = R.drawable.wind_arrow_filled_ic), // Replace with your arrow icon
            contentDescription = null,
            colorFilter = ColorFilter.tint(LocalWeatherTheme.current.textColor),
            modifier = Modifier
                .size(24.dp)
                .fillMaxHeight(.5f)
                .fillMaxWidth(1f)
                .graphicsLayer(rotationZ = windDirection.toFloat())
        )
    }
}
