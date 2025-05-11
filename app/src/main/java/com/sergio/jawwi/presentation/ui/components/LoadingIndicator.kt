package com.sergio.jawwi.presentation.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.unit.dp

/**
 * A composable function that displays a centered circular loading indicator.
 *
 * The indicator is styled with a white color and a semi-transparent track.
 * It is useful for indicating loading states in the UI.
 */
@Composable
fun LoadingIndicator() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    )
    {
        CircularProgressIndicator(
            color = Color.White,
            trackColor = Color.White.copy(alpha = 0.2f),
            strokeCap = StrokeCap.Round,
            strokeWidth = 4.dp,
        )
    }
}

