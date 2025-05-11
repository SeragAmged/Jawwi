package com.sergio.jawwi.presentation.ui.screens.homeScreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sergio.jawwi.core.theme.LocalWeatherTheme
import com.sergio.jawwi.core.utils.DateFormatter
import java.time.LocalTime

/**
 * A reusable composable that serves as the base for all hourly forecast items.
 * 
 * This component provides a standardized layout for displaying hourly weather data,
 * including a time header, a customizable content area, and a value display at the bottom.
 * It's used as the foundation for specialized hourly forecast items like temperature,
 * humidity, and wind speed.
 *
 * @param time The local time to display at the top of the item
 * @param valueWithNotation The value to display at the bottom of the item (e.g., "23°", "45%", "10 km/h")
 * @param direction An optional direction value in degrees, used primarily for wind direction
 * @param content A composable lambda that defines the custom content to display in the middle section.
 *                This allows different types of hourly forecasts to customize their visualization
 *                while maintaining a consistent overall layout.
 */
@Composable
fun HourlyForecastItem(
    time: LocalTime,
    valueWithNotation: String,
    direction: Int? = null,
    content: @Composable (Int?) -> Unit
) {

    Column(
        modifier = Modifier
            .height(150.dp)
            .width(80.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color.White.copy(alpha = 0.2f))
            .padding(vertical = 4.dp)
            .fillMaxWidth(),

        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = DateFormatter.formatTime(time, true),

            fontSize = 14.sp,
            color = LocalWeatherTheme.current.textColor
        )

        content(direction)
        Text(
            text = valueWithNotation,


            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            color = LocalWeatherTheme.current.textColor
        )

    }

}
