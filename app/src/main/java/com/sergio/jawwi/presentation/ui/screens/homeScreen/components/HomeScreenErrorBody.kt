package com.sergio.jawwi.presentation.ui.screens.homeScreen.components

import android.content.Intent
import android.net.Uri
import android.provider.Settings
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.sergio.jawwi.R
import com.sergio.jawwi.presentation.viewmodel.weather.ErrorType

/**
 * A composable that displays an error screen when there are issues loading the home screen.
 * 
 * This component provides a user-friendly error screen with appropriate messaging and
 * action buttons based on the type of error encountered. It handles different error scenarios
 * such as location permission issues, network connectivity problems, or general errors.
 * 
 * The error screen includes:
 * - An appropriate error icon based on the error type
 * - A title describing the error
 * - A detailed error message
 * - Action buttons that either open relevant settings or retry the operation
 *
 * The component also handles the navigation to system settings when needed, such as
 * for location permissions or location services.
 *
 * @param errorMessage The detailed error message to display
 * @param type The type of error that occurred, which determines the UI elements and actions
 * @param onRetry Callback function to retry the operation that failed
 */
@Composable
fun HomeScreenErrorBody(errorMessage: String, type: ErrorType, onRetry: () -> Unit) {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Error Icon
        Image(
            painter = painterResource(
                when (type) {
                    ErrorType.LocationPermissionDenied -> R.drawable.location_off_ic
                    ErrorType.NoInternet -> R.drawable.wifi_off_ic
                    ErrorType.LocationDisabled -> R.drawable.location_off_ic
                    else -> R.drawable.error_ic
                }
            ),
            contentDescription = null,
            colorFilter = ColorFilter.tint(Color.Red),
            modifier = Modifier.size(72.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Error Title
        Text(
            text = when (type) {
                ErrorType.LocationPermissionDenied -> "Location Permission Required"
                ErrorType.NoInternet -> "No Internet Connection"
                ErrorType.LocationDisabled -> "Location Services Disabled"
                else -> "Something Went Wrong"
            },
            style = MaterialTheme.typography.titleLarge,
            color = Color.White,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Error Message
        Text(
            text = errorMessage,
            style = MaterialTheme.typography.bodyLarge,
            color = Color.White.copy(alpha = 0.7f),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Action Button
        Button(
            onClick = {
                when (type) {
                    ErrorType.LocationPermissionDenied -> {
                        val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS).apply {
                            data = Uri.fromParts("package", context.packageName, null)
                        }
                        context.startActivity(intent)
                    }

                    ErrorType.LocationDisabled -> {
                        context.startActivity(Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS))
                    }

                    else -> onRetry()
                }
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White,
                contentColor = Color(0xFF4B80FF)
            ),
            modifier = Modifier.fillMaxWidth(0.7f),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(
                text = when (type) {
                    ErrorType.LocationPermissionDenied -> "Open Settings"
                    ErrorType.LocationDisabled -> "Enable Location"
                    else -> "Retry"
                },
                style = MaterialTheme.typography.labelLarge
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (type != ErrorType.NoInternet)
            Button(
                onClick = onRetry,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = Color(0xFF4B80FF)
                ),
                modifier = Modifier.fillMaxWidth(0.7f),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(
                    text = "Retry",
                    style = MaterialTheme.typography.labelLarge
                )
            }

    }
}
