package com.sergio.jawwi.core.utils

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Looper
import androidx.annotation.RequiresPermission
import androidx.core.app.ActivityCompat

/**
 * A helper class to manage location-related operations, such as fetching the current location.
 *
 * This class provides methods to fetch the device's current location using the GPS provider.
 * It handles permission checks, provider availability, and fallback mechanisms for fetching
 * the last known location or requesting location updates.
 *
 * @param context The application context used to access system services.
 */
class LocationHelper(private val context: Context) {

    private val locationManager =
        context.getSystemService(Context.LOCATION_SERVICE) as LocationManager

    /**
     * Fetches the current location of the device.
     *
     * - Checks if location permissions are granted. If not, invokes [onError] with an appropriate message.
     * - Verifies if the GPS provider is enabled. If not, invokes [onError] with an appropriate message.
     * - Attempts to fetch the last known location. If available, invokes [onLocationFetched].
     * - If the last known location is unavailable, requests location updates to fetch the current location.
     *
     * @param onLocationFetched A callback invoked with the [Location] object when the location is successfully fetched.
     * @param onError A callback invoked with an error message if the location cannot be fetched.
     */
    fun getCurrentLocation(
        onLocationFetched: (location: Location) -> Unit,
        onError: (String) -> Unit
    ) {
        val hasPermission = ActivityCompat.checkSelfPermission(
            context,
            Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED

        if (!hasPermission) {
            onError("Location permission not granted")
            return
        }

        if (!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            onError("GPS provider is disabled")
            return
        }

        requestLocationUpdates(onLocationFetched, onError)

//        val lastKnownLocation: Location? =
//            locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER)
//        if (lastKnownLocation != null) {
//            onLocationFetched(lastKnownLocation)
//        } else {
//            requestLocationUpdates(onLocationFetched, onError)
//        }
    }

    /**
     * Requests location updates to fetch the current location.
     *
     * - Registers a [LocationListener] to listen for location updates.
     * - Once the location is fetched, invokes [onLocationFetched] and removes the listener.
     * - If the location provider is disabled during the process, invokes [onError] and removes the listener.
     * - Handles exceptions gracefully and invokes [onError] if the request fails.
     *
     * @param onLocationFetched A callback invoked with the [Location] object when the location is successfully fetched.
     * @param onError A callback invoked with an error message if the location cannot be fetched.
     *
     * @throws SecurityException If the required location permissions are not granted.
     */
    @RequiresPermission(allOf = [Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION])
    private fun requestLocationUpdates(
        onLocationFetched: (Location) -> Unit,
        onError: (String) -> Unit
    ) {
        val listener = object : LocationListener {
            override fun onLocationChanged(location: Location) {
                onLocationFetched(location)
                locationManager.removeUpdates(this)
            }

            override fun onProviderDisabled(provider: String) {
                onError("Location provider disabled: $provider")
                locationManager.removeUpdates(this)
            }

            override fun onProviderEnabled(provider: String) {}
        }

        try {
            locationManager.requestLocationUpdates(
                LocationManager.GPS_PROVIDER,
                0L,
                0f,
                listener,
                Looper.getMainLooper()
            )
        } catch (e: Exception) {
            onError("Failed to fetch location: ${e.message}")
        }

    }
}
