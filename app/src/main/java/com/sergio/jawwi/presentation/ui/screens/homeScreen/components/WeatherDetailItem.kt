package com.sergio.jawwi.presentation.ui.screens.homeScreen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sergio.jawwi.core.theme.LocalWeatherTheme

/**
 * A composable that displays a single weather detail item.
 * 
 * This component shows a specific weather detail with an icon, value, and title.
 * It's used in the WeatherDetailsSection to display various weather metrics like
 * humidity, wind speed, UV index, etc. in a consistent format.
 * 
 * The layout consists of:
 * - An icon at the top
 * - The value in the middle with medium font weight
 * - The title at the bottom with lighter color
 *
 * @param detailField The WeatherDetailField data class containing the icon, title, and value
 * @param modifier Optional modifier for customizing the layout
 */
@Composable
fun WeatherDetailItem(
    detailField: WeatherDetailField, modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Image(
            painter = painterResource(id = detailField.icon),
            contentDescription = detailField.title,
            modifier = Modifier.size(24.dp),
            colorFilter = ColorFilter.tint(LocalWeatherTheme.current.textColor)


        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = detailField.field,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            color = LocalWeatherTheme.current.textColor
        )

        Text(
            text = detailField.title, fontSize = 12.sp, color = LocalWeatherTheme.current.textColor.copy(alpha = 0.7f)
        )
    }
}

/**
 * Data class representing a weather detail field.
 * 
 * This class encapsulates the information needed to display a single weather detail:
 * 
 * @param icon Resource ID of the icon to display
 * @param title The title/label of the weather detail (e.g., "Humidity", "Wind")
 * @param field The actual value of the weather detail (e.g., "65%", "10 km/h")
 */
data class WeatherDetailField(
    val icon: Int,
    val title: String,
    val field: String,
)