package com.sergio.jawwi.data.repository

import android.content.Context
import android.location.Location
import android.util.Log
import com.sergio.jawwi.core.exceptions.NoInternetException
import com.sergio.jawwi.core.utils.JsonParserHelper
import com.sergio.jawwi.core.utils.LocationHelper
import com.sergio.jawwi.core.utils.NetworkStatuesHelper
import com.sergio.jawwi.data.local.SharedPrefManager
import com.sergio.jawwi.data.models.WeatherDataModel
import com.sergio.jawwi.data.remote.WeatherApiService


/**
 * Repository class that manages weather-related data operations, including location services
 * and weather data fetching from both network and local cache.
 *
 * This class handles fetching the current location, retrieving weather data from the API,
 * and saving data to shared preferences for offline access.
 *
 * @property context Application context required for accessing system services and shared preferences.
 */
class WeatherRepository(private val context: Context) {

    /**
     * Retrieves the current device location using [LocationHelper].
     * Falls back to cached location if the current location fetch fails.
     *
     * - Saves the fetched location to the cache for future use.
     * - If no cached location is available, invokes [onFailure] with an exception.
     *
     * @param onSuccess Callback invoked with the location as a [Location] object.
     * @param onFailure Callback invoked with an [Exception] when location fetch fails.
     */
    fun getCurrentLocation(
        onSuccess: (Location) -> Unit, onFailure: (Exception) -> Unit
    ) {
        val locationHelper = LocationHelper(context)
        locationHelper.getCurrentLocation(onLocationFetched = { location ->
//            val location = Pair(lat, lon)
            Log.d("WeatherRepository", "Latitude: ${location.latitude}, Longitude: ${location.longitude}")
            SharedPrefManager.saveLocationToCache(context, location)
            onSuccess(location)
        }, onError = { error ->
            Log.e("WeatherRepository", "Error fetching location: $error")
            val cached = SharedPrefManager.getCachedLocation(context)
            if (cached != null) {
                Log.e("WeatherRepository", "Using cached location: $cached")
                onSuccess(cached)
            } else {
                onFailure(IllegalArgumentException(error))
            }
        })
    }

    /**
     * Fetches weather data for the specified location.
     *
     * - If the network is available, fetches fresh data from the API and saves it to the cache.
     * - If the network is unavailable, retrieves weather data from the cache.
     * - Throws a [NoInternetException] if no cached data exists and the network is unavailable.
     *
     * @param location The [Location] object containing latitude and longitude.
     * @return A [Pair] containing the [WeatherDataModel] and a boolean indicating whether the data is fresh (true) or from cache (false).
     * @throws NoInternetException If no internet connection is available and no cached data exists.
     */
    fun fetchWeatherData(location: Location): Pair<WeatherDataModel?, Boolean> {
        return if (NetworkStatuesHelper.isNetworkAvailable(context)) {
            Log.d("WeatherRepository", "Network is available")

            fetchWeatherDataFromApi(location) to true
        } else {
            Log.d("WeatherRepository", "Network is not available")
            val cachedWeatherData = SharedPrefManager.getWeatherDataFromCache(context)
            if (cachedWeatherData != null) {


                fetchWeatherDataFromCache() to false

            } else {
                throw NoInternetException("No internet connection")
            }
        }
    }

    /**
     * Fetches fresh weather data from the API for the specified location and saves it to the cache.
     *
     * - Parses the API response into a [WeatherDataModel].
     * - Saves the raw API response to the cache for offline access.
     *
     * @param location The [Location] object containing latitude and longitude.
     * @return A [WeatherDataModel] instance containing the fetched weather data, or `null` if parsing fails.
     */
    private fun fetchWeatherDataFromApi(location: Location): WeatherDataModel? {
        WeatherApiService.getWeatherData(location).let { weatherModelResponse ->

            try {
                SharedPrefManager.saveWeatherDataToCache(context, weatherModelResponse)

                return WeatherDataModel.fromJson(
                    JsonParserHelper.parseJsonString(
                        weatherModelResponse
                    )
                )
            } catch (e: Exception) {
                Log.e("WeatherRepository", "Error parsing weather data: ${e.message}")
                return null
            }
        }
    }

    /**
     * Retrieves and parses weather data from the local cache.
     *
     * - Parses the cached JSON string into a [WeatherDataModel].
     * - Returns `null` if no cached data exists or if parsing fails.
     *
     * @return A [WeatherDataModel] instance containing the cached weather data, or `null` if no data is cached.
     */
    fun fetchWeatherDataFromCache(): WeatherDataModel? {
        val cachedWeatherData = SharedPrefManager.getWeatherDataFromCache(context)
        return if (cachedWeatherData != null) {

            WeatherDataModel.fromJson(JsonParserHelper.parseJsonString(cachedWeatherData))
        } else {
            null
        }
    }

}
