package com.sergio.jawwi.presentation.ui.components

import android.Manifest
import android.content.pm.PackageManager
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat

/**
 * A composable function that requests the user's location permission.
 *
 * - If the permission is already granted, it invokes [onPermissionGranted].
 * - If the permission is denied, it invokes [onPermissionDenied].
 * - If the permission is not yet granted, it launches a permission request dialog.
 *
 * @param onPermissionGranted Callback invoked when the location permission is granted.
 * @param onPermissionDenied Callback invoked when the location permission is denied.
 */
@Composable
fun RequestLocationPermission(
    onPermissionGranted: () -> Unit, onPermissionDenied: () -> Unit
) {
    val context = LocalContext.current

    val locationPermissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission(),
        onResult = { if (it) onPermissionGranted() else onPermissionDenied() })

    LaunchedEffect(Unit) {
        if (ContextCompat.checkSelfPermission(
                context,
                Manifest.permission.ACCESS_FINE_LOCATION,
            ) != PackageManager.PERMISSION_GRANTED
        ) locationPermissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
        else onPermissionGranted()

    }
}
