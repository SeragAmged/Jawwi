package com.sergio.jawwi.presentation.ui.screens.nextWeekForecastScreen.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.sergio.jawwi.core.theme.LocalWeatherTheme

/**
 * A composable function that displays the top app bar for the Next Week Forecast screen.
 *
 * @param onBack A lambda function to handle the back navigation action.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NextWeekForecastScreenTopBar(onBack: () -> Unit) {
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Transparent,
            titleContentColor = LocalWeatherTheme.current.textColor,
            navigationIconContentColor = LocalWeatherTheme.current.textColor,

            ),

        title = {
            Text(
                text = "Next week forecast",
                color = LocalWeatherTheme.current.textColor,
                style = MaterialTheme.typography.titleLarge,
            )


        }, navigationIcon = {
            IconButton(
                onClick = onBack,


                ) {
                Icon(
                    Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Back",
                )
            }
        })

}

