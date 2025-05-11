package com.sergio.jawwi.presentation.ui.screens.homeScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import com.sergio.jawwi.core.theme.LocalWeatherTheme
import com.sergio.jawwi.presentation.ui.components.LoadingIndicator
import com.sergio.jawwi.presentation.ui.components.RequestLocationPermission
import com.sergio.jawwi.presentation.ui.screens.homeScreen.components.HomeScreenBody
import com.sergio.jawwi.presentation.ui.screens.homeScreen.components.HomeScreenErrorBody
import com.sergio.jawwi.presentation.viewmodel.weather.ErrorType
import com.sergio.jawwi.presentation.viewmodel.weather.State
import com.sergio.jawwi.presentation.viewmodel.weather.WeatherViewModel

@Composable
fun HomeScreen(
    viewModel: WeatherViewModel,
    goToNext5Days: () -> Unit,
) {


    if (viewModel.state !is State.DataLoaded) RequestLocationPermission(
        onPermissionGranted = { viewModel.loadWeatherData() },
        onPermissionDenied = {
            viewModel.state =
                State.Error("Location permission denied", ErrorType.LocationPermissionDenied)
        },
    )
    Scaffold { padding ->
        Box(
            Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(LocalWeatherTheme.current.gradient)
                )
                .padding(padding)

        ) {
            when (viewModel.state) {
                is State.Loading -> LoadingIndicator()

                is State.DataLoaded ->
                    HomeScreenBody(
                        weatherData = (viewModel.state as State.DataLoaded).weatherData,
                        goToNext5Days = goToNext5Days,
                        onRefresh = { viewModel.loadWeatherData(true) }
                    )

                is State.Error ->
                    HomeScreenErrorBody(
                        errorMessage = (viewModel.state as State.Error).message,
                        type = (viewModel.state as State.Error).errorType,
                        onRetry = { viewModel.loadWeatherData() }
                    )

            }
        }
    }
}
