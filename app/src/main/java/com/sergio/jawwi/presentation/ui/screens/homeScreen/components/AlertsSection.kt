package com.sergio.jawwi.presentation.ui.screens.homeScreen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.sergio.jawwi.core.theme.LocalWeatherTheme
import com.sergio.jawwi.data.models.AlertDataModel
import com.sergio.jawwi.data.models.WeatherDataModel
import kotlin.collections.forEach

/**
 * A composable that displays weather alerts in a card format.
 * 
 * This component shows a list of active weather alerts with a warning indicator.
 * It's displayed conditionally on the home screen when there are active alerts
 * that users should be aware of (such as severe weather warnings).
 * 
 * The card has a red background to emphasize its importance and includes:
 * - A header with an alert emoji and title
 * - A severe risk indicator showing the current risk level
 * - A list of individual alert items separated by dividers
 *
 * @param weatherData The weather data model containing the alerts to display
 */
@Composable
fun AlertsSection(weatherData: WeatherDataModel) {
    val alerts: List<AlertDataModel> = weatherData.alerts
    Card(
        modifier = Modifier.fillMaxWidth(), colors = CardDefaults.cardColors(
            containerColor = Color(0xFFFF4B4B).copy(alpha = 0.2f)
        ), shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "\uD83D\uDEA8 Weather Alerts",
                    style =  MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = LocalWeatherTheme.current.textColor,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                SeverRiskIndicator(weatherData.currentConditions.severeRisk)
            }

            alerts.forEach { alert ->
                AlertItem(alert)
                if (alert != alerts.last()) {
                    HorizontalDivider(
                        color = LocalWeatherTheme.current.textColor.copy(alpha = 0.2f),
                        thickness = 1.dp,
                        modifier = Modifier.padding(vertical = 8.dp)
                    )
                }
            }
        }
    }
}
