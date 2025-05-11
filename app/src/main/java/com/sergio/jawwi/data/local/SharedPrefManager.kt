package com.sergio.jawwi.data.local

import android.content.Context
import android.location.Location

/**
 * A singleton object for managing shared preferences in the application.
 *
 * This class provides methods to save and retrieve location and weather data
 * from the shared preferences cache. It ensures that data is persistently stored
 * and can be accessed even when the app is restarted.
 */
object SharedPrefManager {
    private const val PREF_NAME = "jawwi_pref"
    private const val LATITUDE = "lat"
    private const val LONGITUDE = "lon"
    private const val WEATHER_DATA = "weather_data"

    /**
     * Saves the user's location (latitude and longitude) to the shared preferences cache.
     *
     * @param context The application context used to access shared preferences.
     * @param location A [Location] object containing the latitude and longitude.
     */
    fun saveLocationToCache(context: Context, location: Location) {
        val prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        with(prefs.edit()) {
            putFloat(LATITUDE, location.latitude.toFloat())
            putFloat(LONGITUDE, location.longitude.toFloat())
            apply()
        }
    }

    /**
     * Saves weather data as a JSON string to the shared preferences cache.
     *
     * @param context The application context used to access shared preferences.
     * @param weatherData A JSON string representing the weather data.
     */
    fun saveWeatherDataToCache(context: Context, weatherData: String) {
        val prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        with(prefs.edit()) {
            putString(WEATHER_DATA, weatherData)
            apply()
        }
    }

    /**
     * Retrieves the cached weather data from shared preferences.
     *
     * @param context The application context used to access shared preferences.
     * @return A JSON string representing the cached weather data, or `null` if no data is found.
     */
    fun getWeatherDataFromCache(context: Context): String? {
        val prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        return prefs.getString(WEATHER_DATA, null)
    }

    /**
     * Retrieves the cached location (latitude and longitude) from shared preferences.
     *
     * @param context The application context used to access shared preferences.
     * @return A [Location] object containing the cached latitude and longitude, or `null` if no location is found.
     */
    fun getCachedLocation(context: Context): Location? {
        val prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        val lat = prefs.getFloat(LATITUDE, -1f)
        val lon = prefs.getFloat(LONGITUDE, -1f)
        return if (lat != -1f && lon != -1f) Location("gps").apply {
            latitude = lat.toDouble()
            longitude = lon.toDouble()
        } else null
    }
}
