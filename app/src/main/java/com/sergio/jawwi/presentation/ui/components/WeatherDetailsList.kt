package com.sergio.jawwi.presentation.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sergio.jawwi.R
import com.sergio.jawwi.core.utils.DateFormatter
import com.sergio.jawwi.data.models.WeatherForecastDataModel
import com.sergio.jawwi.presentation.ui.screens.homeScreen.components.WeatherDetailField
import com.sergio.jawwi.presentation.ui.screens.homeScreen.components.WeatherDetailItem

/**
 * A composable function that displays a list of weather details in a grid layout.
 *
 * The list adapts based on the expanded state:
 * - If expanded, all weather details are shown.
 * - If collapsed, only the first three weather details are displayed.
 *
 * @param source The source of weather data, represented as [WeatherForecastDataModel].
 * @param expanded A boolean indicating whether the list is expanded or collapsed.
 */
@Composable
fun WeatherDetailsList(source: WeatherForecastDataModel, expanded: Boolean) {
    val fields = listOf(
        WeatherDetailField(
            R.drawable.wind_ic, "Wind", "${source.windSpeed} km/h"
        ),
        WeatherDetailField(
            R.drawable.humidity_ic, "Humidity", "${source.humidity}%"
        ),
        WeatherDetailField(
            R.drawable.visibility_ic,
            "Visibility",
            "${source.visibilityKm} km"
        ),
        WeatherDetailField(
            R.drawable.precip_ic,
            "Precipitation",
            "${source.precipitationProb}%"
        ),
        WeatherDetailField(
            R.drawable.cloud_ic,
            "Cloud cover",
            "${source.cloudCoverPercentage}%"
        ),
        WeatherDetailField(
            R.drawable.pressure_ic, "Pressure", "${source.pressure} hPa"
        ),
        WeatherDetailField(
            R.drawable.glasses_ic, "UV Index", "${source.uvIndex}"
        ),
        WeatherDetailField(
            R.drawable.sunrise_ic,
            "Sunrise",
            if (source.sunrise == null) "N/A" else DateFormatter.formatTime(
                source.sunrise
            ).toString()
        ),
        WeatherDetailField(
            R.drawable.sunset_ic,
            "Sunset",
            if (source.sunset == null) "N/A" else DateFormatter.formatTime(
                source.sunset
            ).toString()
        ),
    )
    val itemsToShow = if (expanded) fields else fields.take(3)

    itemsToShow.chunked(3).forEach {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            it.forEach {
                WeatherDetailItem(it, modifier = Modifier.weight(1f))
            }
            // Fill remaining columns with empty space
            repeat(3 - it.size) {
                Spacer(modifier = Modifier.weight(1f))
            }
        }
    }
}
