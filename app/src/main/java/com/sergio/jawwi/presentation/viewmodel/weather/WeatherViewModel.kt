package com.sergio.jawwi.presentation.viewmodel.weather

import android.app.Application
import android.location.Location
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import com.sergio.jawwi.core.exceptions.NoInternetException
import com.sergio.jawwi.data.models.WeatherDataModel
import com.sergio.jawwi.data.repository.WeatherRepository
import java.util.concurrent.Executors

/**
 * ViewModel responsible for managing weather-related data and UI state.
 * Handles fetching the current location, retrieving weather data, and updating the UI state.
 *
 * @property weatherRepository Repository instance for weather data operations.
 * @property state Current UI state (Loading, Error, or DataLoaded).
 * @property weatherData Current weather data, initially loaded from cache.
 * @property location Current location as a [Location] object.
 */
class WeatherViewModel(application: Application) : AndroidViewModel(application) {

    private val weatherRepository = WeatherRepository(application.applicationContext)

    /**
     * Represents the current state of the UI.
     * Can be one of Loading, Error, or DataLoaded.
     */
    var state by mutableStateOf<State>(State.Loading)

    /**
     * Holds the current weather data, fetched from the repository or cache.
     */
    var weatherData by mutableStateOf<WeatherDataModel?>(weatherRepository.fetchWeatherDataFromCache())

    /**
     * Stores the current location as a [Location] object.
     */
    var location: Location? = null

    /**
     * Loads weather data by first fetching the current location and then retrieving weather data for that location.
     *
     * - If [isRefresh] is false, sets the state to Loading to show a loading indicator.
     * - On successful location fetch, calls [loadWeatherFromLocation].
     * - On failure, updates the state to Error with an appropriate message and error type.
     *
     * @param isRefresh Indicates whether this is a refresh operation.
     */
    fun loadWeatherData(isRefresh: Boolean = false) {
        if (!isRefresh)
            state = State.Loading

        weatherRepository.getCurrentLocation(
            onSuccess = { loc ->
                Log.d("WeatherViewModel", "Location fetched: $loc")
                location = loc
                loadWeatherFromLocation(loc)
            },
            onFailure = { ex ->
                val msg = ex.message ?: "Unknown error"
                state = when (ex) {
                    is SecurityException -> {
                        State.Error(
                            "Location permission denied: $msg",
                            ErrorType.LocationPermissionDenied
                        )
                    }

                    is IllegalArgumentException -> {
                        State.Error("Location provider disabled: $msg", ErrorType.LocationDisabled)
                    }

                    else -> {
                        State.Error("Location error: $msg", ErrorType.DataError)
                    }
                }
            }
        )
    }

    private val executor = Executors.newSingleThreadExecutor()
    private val mainHandler = Handler(Looper.getMainLooper())

    /**
     * Loads weather data for the specified location.
     *
     * - Executes asynchronously to avoid blocking the main thread.
     * - Fetches weather data from the repository.
     * - Updates [weatherData] with the fetched data.
     * - Updates the state to DataLoaded on success.
     * - Updates the state to Error with an appropriate message and error type on failure.
     * - Displays a toast message if cached data is used due to no internet connection.
     *
     * @param location A [Location] object containing the latitude and longitude.
     */
    private fun loadWeatherFromLocation(location: Location) {
        executor.execute {
            val result: Pair<Boolean, Boolean> = try {
                val fetchResult =
                    weatherRepository.fetchWeatherData(location)
                weatherData = fetchResult.first
                true to fetchResult.second
            } catch (e: NoInternetException) {
                val errorMessage = "No internet: ${e.message}"
                Log.e("WeatherViewModel", errorMessage)
                state = State.Error(errorMessage, ErrorType.NoInternet)
                false to false
            } catch (e: Exception) {
                val errorMessage = "Error loading weather data: ${e.message}"
                Log.e("WeatherViewModel", errorMessage)
                state = State.Error(errorMessage, ErrorType.DataError)
                false to false
            }

            mainHandler.post {
                if (result.first) {
                    state = State.DataLoaded(weatherData!!)
                    if (!result.second) {
                        Toast.makeText(
                            getApplication<Application>().applicationContext,
                            "No internet connection, loading cached data",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
            }
        }
    }
}
