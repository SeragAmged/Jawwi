package com.sergio.jawwi.presentation.ui.screens.homeScreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

/**
 * A composable that displays a vertical bar representing humidity levels.
 * 
 * This component visualizes humidity as a vertical bar where the fill height
 * corresponds to the humidity percentage. The bar has a light gray background
 * with a blue fill that rises from the bottom based on the humidity value.
 * 
 * It's used within the HourlyHumidityForecastItem to provide a visual
 * representation of humidity levels throughout the day.
 *
 * @param humidity The humidity percentage value (0-100)
 * @param modifier Optional modifier for customizing the layout
 */
@Composable
fun VerticalHumidityBar(humidity: Int, modifier: Modifier = Modifier) {


    Box(
        modifier = modifier
            .height(150.dp)
            .width(80.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(Color.LightGray),
        contentAlignment = Alignment.BottomCenter
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(humidity / 100f)
                .background(Color(0xFF1CA3EC))
        )
    }
}
