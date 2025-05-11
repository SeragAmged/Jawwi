package com.sergio.jawwi.presentation.ui.screens.homeScreen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.LocationOn
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import com.sergio.jawwi.core.theme.LocalWeatherTheme

/**
 * A composable that displays the timezone location information in the home screen.
 * 
 * This component shows the current timezone of the weather data with a location icon.
 * It's typically displayed at the top of the home screen to provide context about
 * the geographical location of the weather data being displayed.
 *
 * @param timeZoneLocation The timezone location string to display. If null, "Null Location" will be shown.
 */
@Composable
fun LocationTimeZone(timeZoneLocation: String?) {
    Row(
        modifier = Modifier
            .testTag("location_time_zone")
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Location
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Rounded.LocationOn,
                contentDescription = "Location",
                tint = LocalWeatherTheme.current.textColor
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = "Timezone: ${timeZoneLocation ?: "Null Location"}",
                color = LocalWeatherTheme.current.textColor,
                style = MaterialTheme.typography.bodyLarge
            )
            Spacer(modifier = Modifier.width(4.dp))


        }

        // Settings icon
    }
}