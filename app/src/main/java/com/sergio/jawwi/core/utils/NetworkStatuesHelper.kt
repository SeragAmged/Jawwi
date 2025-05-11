package com.sergio.jawwi.core.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities

/**
 * A utility object to check the network status of the device.
 */
object NetworkStatuesHelper {

    /**
     * Checks if the network is available on the device.
     *
     * This method verifies if the device is connected to a network and if the network
     * has internet capability.
     *
     * @param context The application context used to access system services.
     * @return `true` if the network is available and has internet capability, `false` otherwise.
     */
    fun isNetworkAvailable(context: Context): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val network = connectivityManager.activeNetwork ?: return false
        val capabilities = connectivityManager.getNetworkCapabilities(network) ?: return false
        return capabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
    }
}
