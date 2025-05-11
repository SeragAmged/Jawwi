package com.sergio.jawwi.core.utils

import android.util.Log
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

/**
 * A utility object that provides helper methods for making HTTP GET requests
 * and parsing JSON responses.
 */
object ApiHelper {

    /**
     * Makes an HTTP GET request to the specified URL and parses the response
     * into a Map<String, Any?> using the JsonParserHelper.
     *
     * @param urlStr The URL to send the GET request to.
     * @return A map representation of the JSON response.
     */
    fun httpGetJson(urlStr: String): Map<String, Any?> {
        val jsonStr = httpGet(urlStr)
        return JsonParserHelper.parseJsonString(jsonStr)
    }

    /**
     * Makes an HTTP GET request to the specified URL and returns the response
     * as a string. Handles connection timeouts and errors gracefully.
     *
     * @param urlStr The URL to send the GET request to.
     * @return The response as a string, or throws an error message if the request fails.
     */
    fun httpGet(urlStr: String): String {
        return try {
            val url = URL(urlStr)
            val connection = url.openConnection() as HttpURLConnection
            connection.requestMethod = "GET"
            connection.connectTimeout = 5000
            connection.readTimeout = 5000

            val inputStream = if (connection.responseCode in 200..299) {
                connection.inputStream
            } else {
                connection.errorStream
            }

            val reader = BufferedReader(InputStreamReader(inputStream))
            val response = StringBuilder()
            var line: String?

            while (reader.readLine().also { line = it } != null) {
                response.append(line)
            }

            reader.close()
            connection.disconnect()

            response.toString()
        } catch (e: Exception) {
            // Log the error or handle it as needed
            Log.e("ApiHelper",e.message,e)
            throw Exception("Error making GET request: ${e.message}")
        }
    }
}
