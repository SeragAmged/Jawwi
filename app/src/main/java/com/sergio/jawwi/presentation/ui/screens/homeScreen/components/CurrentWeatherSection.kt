package com.sergio.jawwi.presentation.ui.screens.homeScreen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.sergio.jawwi.core.theme.LocalWeatherTheme
import com.sergio.jawwi.core.utils.DateFormatter
import com.sergio.jawwi.data.models.WeatherDataModel
import com.sergio.jawwi.data.models.WeatherForecastDataModel
import java.time.LocalDate
import java.time.LocalTime

/**
 * A composable that displays the current weather information section.
 * 
 * This component shows detailed information about the current weather conditions including:
 * - Current date and time
 * - Current temperature with weather icon
 * - Weather condition description
 * - "Feels like" temperature
 * - High and low temperatures for the day
 * - Weather description (if available)
 *
 * It's typically the most prominent section on the home screen, providing the user with
 * an immediate overview of current weather conditions.
 *
 * @param weatherData The weather data model containing all weather information to display
 */
@Composable
fun CurrentWeatherSection(weatherData: WeatherDataModel) {
    val currentConditions: WeatherForecastDataModel = weatherData.currentConditions
    Column(
        modifier = Modifier.testTag("current_weather_section"),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Center,
    ) {

        // Date and time
        Text(
            modifier = Modifier.testTag("current_date_time"),
            text = "${DateFormatter.formatTime(currentConditions.datetime as LocalTime)}\n${
                DateFormatter.formatDateEMD(
                    weatherData.days[0].datetime as LocalDate
                )
            }",
            style = MaterialTheme.typography.labelMedium,
            color = LocalWeatherTheme.current.textColor.copy(alpha = 0.8f),
        )

        // Temperature & Weather Icon
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically

        ) {

            Text(
                text = "${currentConditions.temp}°",
                style = MaterialTheme.typography.displayLarge,
                color = LocalWeatherTheme.current.textColor,
                fontWeight = FontWeight.Bold,
            )
            Image(
                painter = painterResource(id = LocalWeatherTheme.current.icon),
                contentDescription = currentConditions.icon,
                modifier = Modifier
                    .size(72.dp)
                    .align(Alignment.Top),
            )


            Spacer(modifier = Modifier.weight(1f))
            // Weather condition & Feels Like
            Column(
                horizontalAlignment = Alignment.End
            ) {
                if (currentConditions.conditions != null) Text(
                    text = currentConditions.conditions,
                    style = MaterialTheme.typography.bodyLarge,
                    color = LocalWeatherTheme.current.textColor,
                    textAlign = TextAlign.Center,
                )
                Text(
                    text = "Feels Like ${currentConditions.feelsLike}°",
                    style = MaterialTheme.typography.labelLarge,
                    color = LocalWeatherTheme.current.textColor.copy(alpha = 0.8f),
                    textAlign = TextAlign.Center,

                    )
            }

        }
        // High/Low temperature
        Text(
            modifier = Modifier.testTag("temperature_range"),
            text = "H: ${weatherData.days[0].tempMax}° L: ${weatherData.days[0].tempMin}°",
            style = MaterialTheme.typography.labelLarge,
            color = LocalWeatherTheme.current.textColor.copy(alpha = 0.8f),
        )
        if (weatherData.description != null) {
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = weatherData.description,
                style = MaterialTheme.typography.labelMedium,
                color = LocalWeatherTheme.current.textColor,
            )
        }

    }
}