package com.sergio.jawwi.presentation.ui.screens.homeScreen.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.sergio.jawwi.core.theme.LocalWeatherTheme

/**
 * A composable that displays a button to navigate to the next week's forecast.
 *
 * This component is displayed at the bottom of the home screen and provides
 * a way for users to navigate to a more detailed view showing the weather
 * forecast for the upcoming week.
 *
 * The button spans the full width of the screen with a semi-transparent
 * background and rounded corners for a modern look.
 *
 * @param goToNext5Days Callback function that will be triggered when the button is clicked,
 *                      typically navigating to the 5-day/next week forecast screen
 */
@Composable
fun NextWeekForecastButton(
    goToNext5Days: () -> Unit,
) {
    Button(
        colors =ButtonDefaults.buttonColors(Color.White.copy(alpha = 0.2f)),
        modifier = Modifier
            .clip(RoundedCornerShape(16.dp))
            .fillMaxWidth()
,
        onClick = { goToNext5Days() },
    ) {

        Text(

            text = "Next Week Forecast",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            color = LocalWeatherTheme.current.textColor,
            modifier = Modifier.padding(vertical = 8.dp)

        )
    }
}
