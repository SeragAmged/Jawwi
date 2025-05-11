package com.sergio.jawwi.presentation.ui.screens.homeScreen.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

/**
 * A composable that displays the severe risk level indicator.
 * 
 * This component shows the current severe weather risk level with appropriate
 * color coding based on the severity:
 * - Low risk (< 30): Green
 * - Moderate risk (30-70): Yellow/Amber
 * - High risk (> 70): Red
 * - Unknown risk (null): Gray
 *
 * It's typically displayed in the AlertsSection header to provide a quick
 * visual indication of the overall weather risk level.
 *
 * @param severRisk The severe risk value as an integer from 0-100, or null if unknown
 */
@Composable
fun SeverRiskIndicator(severRisk: Int?) {

    val severity = when {
        ((severRisk ?: 0) < 30) -> "Low" to Color(0xFF38F33A)
        (severRisk ?: 0) in (30..70) -> "Moderate" to Color(0xFFFFC107)
        (severRisk ?: 0) > 70 -> "High" to Color(0xFFD32F2F)
        else -> "Unknown" to Color.Gray
    }
    Text(
        text = "${severity.first} Risk",
        style = MaterialTheme.typography.labelLarge,
        color = severity.second
    )
}