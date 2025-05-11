package com.sergio.jawwi.presentation.ui.screens.homeScreen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.sergio.jawwi.core.theme.LocalWeatherTheme
import com.sergio.jawwi.presentation.ui.components.ExpandableCard

/**
 * A composable that displays an expandable forecast title with an icon.
 * 
 * This component is used as a tab in the hourly forecast section to switch between
 * different types of forecasts (temperature, humidity, wind). It shows an icon
 * when collapsed and both an icon and title when expanded.
 * 
 * The component uses an ExpandableCard to handle the expansion/collapse behavior
 * and triggers the provided callback when its state changes.
 *
 * @param icon Resource ID of the icon to display
 * @param title Text to display when the component is expanded
 * @param expandedState MutableState that controls whether the component is expanded
 * @param onExpanded Callback function triggered when the expanded state changes
 */
@Composable
fun ExpandableForecastTitle(
    icon: Int,
    title: String,
    expandedState: MutableState<Boolean>,
    onExpanded: (Boolean) -> Unit,
) {
    ExpandableCard(
        expandedState = expandedState,
        onExpanded = onExpanded,
    ) { expanded ->
        Row(
            modifier = Modifier.padding(  8.dp),
            horizontalArrangement = Arrangement.spacedBy(2.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(icon),
                contentDescription = null,
                tint = LocalWeatherTheme.current.textColor,
                modifier = Modifier
                    .size(24.dp)
            )
            if (expanded)
                Text(
                    text = title,
                    style = MaterialTheme.typography.labelMedium,
                    color = LocalWeatherTheme.current.textColor,
                )
        }
    }
}
