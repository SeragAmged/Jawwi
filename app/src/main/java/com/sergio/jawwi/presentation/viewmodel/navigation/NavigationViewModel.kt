package com.sergio.jawwi.presentation.viewmodel.navigation

import android.app.Application
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel

/**
 * ViewModel responsible for managing navigation state in the application.
 * Keeps track of current and previous screens for navigation purposes.
 *
 * @property application The Android Application instance.
 */
class NavigationViewModel(application: Application) : AndroidViewModel(application) {
    /**
     * Current screen state. Initialized with Home screen.
     * Private mutable state that can only be modified within this ViewModel.
     */
    private var _currentScreen = mutableStateOf<Screen>(Screen.Home)

    /**
     * Public immutable state of the current screen that can be observed by UI components.
     */
    val currentScreen = _currentScreen

    /**
     * Previous screen state. Null when no previous screen exists.
     * Private mutable state that can only be modified within this ViewModel.
     */
    private var _previousScreen = mutableStateOf<Screen?>(null)

    /**
     * Public immutable state of the previous screen that can be observed by UI components.
     */
    val previousScreen = _previousScreen

    /**
     * Indicates whether the current screen is Next5Days screen,
     * which means the user can navigate back.
     */
    val isBack: Boolean
        get() = currentScreen.value == Screen.NextWeekForecast

    /**
     * Navigates to the NextWeekForecast screen.
     * Stores the current screen as previous screen before updating current screen.
     */
    fun navigateToNextWeekForecastScreen() {
        _previousScreen.value = _currentScreen.value
        _currentScreen.value = Screen.NextWeekForecast
    }

    /**
     * Navigates back to the Home screen.
     * Stores the current screen as previous screen before updating current screen.
     */
    fun navigateBack() {
        _previousScreen.value = _currentScreen.value
        _currentScreen.value = Screen.Home
    }
}
