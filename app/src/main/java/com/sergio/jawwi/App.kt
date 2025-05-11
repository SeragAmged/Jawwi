package com.sergio.jawwi


import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.runtime.Composable
import com.sergio.jawwi.core.theme.JawwiTheme
import com.sergio.jawwi.core.theme.WeatherTheme
import com.sergio.jawwi.presentation.ui.screens.homeScreen.HomeScreen
import com.sergio.jawwi.presentation.ui.screens.nextWeekForecastScreen.NextWeekForecastScreen
import com.sergio.jawwi.presentation.viewmodel.navigation.NavigationViewModel
import com.sergio.jawwi.presentation.viewmodel.navigation.Screen
import com.sergio.jawwi.presentation.viewmodel.weather.WeatherViewModel

@Composable
fun App(weatherViewModel: WeatherViewModel, navigationViewModel: NavigationViewModel) {
    BackHandler(enabled = navigationViewModel.currentScreen.value == Screen.NextWeekForecast) {
        navigationViewModel.navigateBack()
    }

    JawwiTheme(

        weatherTheme = WeatherTheme.fromIcon(weatherViewModel.weatherData?.currentConditions?.icon)
    ) {
        AnimatedContent(
            targetState = navigationViewModel.currentScreen.value, transitionSpec = {
                slideInHorizontally { it * (if (navigationViewModel.isBack) 1 else -1) } + fadeIn() togetherWith slideOutHorizontally { it * (if (navigationViewModel.isBack) -1 else 1) }
            }) { screen ->
            when (screen) {
                Screen.Home -> HomeScreen(weatherViewModel) { navigationViewModel.navigateToNextWeekForecastScreen() }
                Screen.NextWeekForecast -> NextWeekForecastScreen(weatherViewModel.weatherData) { navigationViewModel.navigateBack() }
            }
        }
    }
}

//OLD IMPLEMENTATION
//    val context = LocalContext.currentlocatio
//    val weatherViewModel = rememberSaveable(
//        saver = Saver(
//            save = {
//                with(it) {
//                    listOf(
//                        state.value.ordinal,
//                        weatherRepository.latitude,
//                        weatherRepository.longitude,
//                        weatherRepository.weatherModel
//                    )
//                }
//            },
//            restore = { saved ->
//                WeatherViewModel.kt(context.applicationContext).apply {
//                    state.value = State.entries.toTypedArray()[saved[0] as Int]
//                    weatherRepository.latitude = saved[1] as Double
//                    weatherRepository.longitude = saved[2] as Double
//                    weatherRepository.weatherModel = saved[3] as WeatherDataModel
//                }
//            }
//        )
//    ) {
//        WeatherViewModel.kt(context.applicationContext)
//    }
//    var currentScreen by rememberSaveable { mutableStateOf(Screen.Home) }
//    var previousScreen by remember { mutableStateOf<Screen?>(null) }
//    val isBack = remember(currentScreen, previousScreen) { currentScreen == Screen.Next5Days }
//
//    val navigateToNextWeekForecastScreen = {
//        previousScreen = currentScreen
//        currentScreen = Screen.Next5Days
//    }
//    val navigateBackToHome = {
//        previousScreen = currentScreen
//        currentScreen = Screen.Home
//    }
