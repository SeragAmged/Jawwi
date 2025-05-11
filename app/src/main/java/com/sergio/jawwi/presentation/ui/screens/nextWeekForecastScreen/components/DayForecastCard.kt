package com.sergio.jawwi.presentation.ui.screens.nextWeekForecastScreen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.sergio.jawwi.core.theme.LocalWeatherTheme
import com.sergio.jawwi.core.utils.DateFormatter
import com.sergio.jawwi.data.models.WeatherForecastDataModel
import com.sergio.jawwi.presentation.ui.components.ExpandableCard
import com.sergio.jawwi.presentation.ui.components.WeatherDetailsList
import java.time.LocalDate

/**
 * A composable function that displays a card for a single day's weather forecast.
 *
 * @param day The weather forecast data for the day.
 * @param expandedState An optional external state to control the expanded state of the card.
 * @param onExpanded A callback function triggered when the card is expanded or collapsed.
 */
@Composable
fun DayForecastCard(
    day: WeatherForecastDataModel,
    expandedState: MutableState<Boolean>? = null, // Optional external state
    onExpanded: (Boolean) -> Unit = {},
) {
    ExpandableCard(
        modifier = Modifier.testTag("day_forecast_card"),
        expandedState = expandedState,
        onExpanded = onExpanded,

        ) { expanded ->
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            // Header: Date and Conditions
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    // Weather Icon

                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .background(
                                LocalWeatherTheme.current.textColor.copy(alpha = 0.3f),
                                shape = RoundedCornerShape(8.dp)
                            )
                    ) {
                        Image(
                            painter = painterResource(id = LocalWeatherTheme.current.icon), // Replace with actual icon
                            contentDescription = null,
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(4.dp),

                            )
                    }
                    Column {
                        Text(
//                            text = (day.datetime as LocalDate).dayOfWeek.getDisplayName(
//                                TextStyle.FULL,
//                                Locale.getDefault()
//                            ),
                            text = DateFormatter.formatDateEMD((day.datetime as LocalDate)),
                            style = MaterialTheme.typography.titleMedium,
                            color = LocalWeatherTheme.current.textColor
                        )
                        Text(
                            text = day.conditions ?: "",
                            style = MaterialTheme.typography.bodyMedium,
                            color = LocalWeatherTheme.current.textColor.copy(alpha = 0.7f)
                        )
                    }
                }
                Column(
                    horizontalAlignment = Alignment.End,

                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "${day.temp}°",
                        style = MaterialTheme.typography.titleLarge,
                        color = LocalWeatherTheme.current.textColor
                    )
                    Text(
                        text = "${day.tempMax}°|${day.tempMin}°",
                        style = MaterialTheme.typography.bodyMedium,
                        color = LocalWeatherTheme.current.textColor.copy(alpha = 0.7f)
                    )
                }
            }

            if (expanded) {
                Spacer(modifier = Modifier.height(16.dp))
                HorizontalDivider(
                    modifier = Modifier.fillMaxWidth(),
                    thickness = 1.dp,
                    color = LocalWeatherTheme.current.textColor.copy(alpha = 0.2f)
                )
                Spacer(modifier = Modifier.height(16.dp))

                WeatherDetailsList(
                    source = day, expanded = true
                )
            }
        }
    }
}


