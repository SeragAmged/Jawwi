package com.sergio.jawwi.data.remote

import android.location.Location
import android.util.Log
import com.sergio.jawwi.BuildConfig
import com.sergio.jawwi.core.utils.ApiHelper

/**
 * A service object responsible for fetching weather data from the remote API.
 *
 * This service constructs the API URL using the provided location coordinates
 * and retrieves the weather data as a JSON string. It handles API key authentication
 * and supports configurable unit groups and icon sets.
 */
object WeatherApiService {
    /**
     * The base URL of the weather API, retrieved from the build configuration.
     */
    const val BASE_URL = BuildConfig.BASE_URL

    /**
     * The API key for authenticating requests, retrieved from the build configuration.
     */
    const val API_KEY = BuildConfig.API_TOKEN

    /**
     * The unit group for weather data (e.g., "uk" for UK-specific units).
     * Determines the measurement units used in the API response.
     */
    const val UNIT_GROUP = "uk"

    /**
     * The icon set to use for weather conditions.
     * Specifies the style of weather icons returned by the API.
     */
    const val ICON_SET = "icons2"

    /**
     * Fetches weather data from the API for the given location.
     *
     * Constructs the API URL using the provided location's latitude and longitude,
     * along with the unit group and icon set. Sends an HTTP GET request to retrieve
     * the weather data as a JSON string.
     *
     * @param location A [Location] object containing the latitude and longitude of the desired location.
     * @return A JSON string containing the weather data.
     * @throws Exception If an error occurs during the API request, such as a network failure or invalid response.
     */
    fun getWeatherData(location: Location): String {
        try {
            val url =
                "$BASE_URL/${location.latitude}%2C${location.longitude}?unitGroup=$UNIT_GROUP&iconSet=$ICON_SET&key=$API_KEY"
            Log.d("WeatherApiService", "Fetching weather data from: $url")

            return ApiHelper.httpGet(url)

        } catch (e: Exception) {
            Log.e("WeatherApiService", "Error fetching weather data: ${e.message}")
            throw e
        }
    }
}
