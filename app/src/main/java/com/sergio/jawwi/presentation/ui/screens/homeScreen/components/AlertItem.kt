package com.sergio.jawwi.presentation.ui.screens.homeScreen.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sergio.jawwi.core.theme.LocalWeatherTheme
import com.sergio.jawwi.data.models.AlertDataModel

/**
 * A composable that displays an individual weather alert item.
 * 
 * This component renders a single weather alert with its event title and description.
 * It's used within the AlertsSection to display each alert in a consistent format.
 * 
 * The alert includes:
 * - A warning emoji and the event title (e.g., "Flood Warning", "Severe Thunderstorm")
 * - The detailed description of the alert
 *
 * @param alert The AlertDataModel containing the alert information to display
 */
@Composable
fun AlertItem(alert: AlertDataModel) {
    Column {
        Text(
            text = "⚠\uFE0F ${alert.event}",
            style = MaterialTheme.typography.labelLarge,
            color = LocalWeatherTheme.current.textColor
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = alert.description,
            style = MaterialTheme.typography.bodyLarge,
            color = LocalWeatherTheme.current.textColor.copy(alpha = 0.8f),
        )
    }
}
