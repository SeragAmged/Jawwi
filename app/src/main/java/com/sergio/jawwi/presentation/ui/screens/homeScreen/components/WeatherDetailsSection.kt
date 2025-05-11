package com.sergio.jawwi.presentation.ui.screens.homeScreen.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sergio.jawwi.core.theme.LocalWeatherTheme
import com.sergio.jawwi.data.models.WeatherDataModel
import com.sergio.jawwi.presentation.ui.components.ExpandableCard
import com.sergio.jawwi.presentation.ui.components.WeatherDetailsList

/**
 * A composable that displays a section with detailed weather information.
 * 
 * This component shows various weather details like humidity, wind speed, UV index,
 * and more in an expandable card format. Users can expand or collapse the card to
 * show or hide the detailed information.
 * 
 * The section includes:
 * - A header with the title "Weather Details" and an expandable arrow
 * - A list of weather detail items when expanded
 * - Animation for the expand/collapse arrow rotation
 *
 * @param weatherData The weather data model containing all the detailed weather information
 */
@Composable
fun WeatherDetailsSection(
    weatherData: WeatherDataModel
) {
    ExpandableCard(
        modifier = Modifier.testTag("weather_details_section")
    ) { expanded ->
        val rotation by animateFloatAsState(if (expanded) 180f else 0f)
        Column(modifier = Modifier.padding(16.dp)) {
            Row {
                Text(
                    text = "Weather Details",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = LocalWeatherTheme.current.textColor,
                    modifier = Modifier
                        .testTag("weather_details_title")
                        .padding(bottom = 8.dp)
                )
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    imageVector = Icons.Filled.KeyboardArrowDown,
                    contentDescription = "Expand/Collapse",
                    tint = LocalWeatherTheme.current.textColor,
                    modifier = Modifier
                        .padding(bottom = 8.dp)
                        .rotate(rotation)
                )
            }
            WeatherDetailsList(
                source = weatherData.currentConditions,
                expanded = expanded
            )
        }
    }
}
