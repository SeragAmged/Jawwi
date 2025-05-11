package com.sergio.jawwi.core.exceptions

import java.io.IOException

/**
 * Exception thrown when there is no internet connection available.
 *
 * This exception is used to indicate that a network operation cannot proceed
 * due to the absence of an active internet connection.
 *
 * @param message The error message describing the exception. Defaults to "No Internet Connection".
 */
class NoInternetException(message: String = "No Internet Connection") : IOException(message)
