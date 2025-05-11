package com.sergio.jawwi.core.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.remember
import com.sergio.jawwi.core.theme.WeatherTheme.Companion.toColorScheme

/**
 * A CompositionLocal that provides the current [WeatherTheme] to the composable hierarchy.
 * Defaults to [WeatherTheme.Default] if no theme is provided.
 */
val LocalWeatherTheme = compositionLocalOf<WeatherTheme> { WeatherTheme.Default }

/**
 * A custom theme composable for the Jawwi application.
 *
 * This function applies a weather-based theme to the application, including a color scheme
 * derived from the provided [WeatherTheme]. It also supports light and dark modes.
 *
 * @param weatherTheme The [WeatherTheme] to be applied to the application.
 * @param isDark A boolean indicating whether the dark theme should be applied. Defaults to the system setting.
 * @param content The composable content to which the theme will be applied.
 */
@Composable
fun JawwiTheme(
    weatherTheme: WeatherTheme,
    isDark: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = remember(weatherTheme, isDark) {
        weatherTheme.toColorScheme(isDark)
    }

    CompositionLocalProvider(LocalWeatherTheme provides weatherTheme) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = Typography,
            shapes = MaterialTheme.shapes,
            content = content
        )
    }

}
//
//private val DarkColorScheme = darkColorScheme(
//    primary = Purple80,
//    secondary = PurpleGrey80,
//    tertiary = Pink80
//)
//
//private val LightColorScheme = lightColorScheme(
//    primary = Purple40,
//    secondary = PurpleGrey40,
//    tertiary = Pink40
//
//    /* Other default colors to override
//    background = Color(0xFFFFFBFE),
//    surface = Color(0xFFFFFBFE),
//    onPrimary = Color.White,
//    onSecondary = Color.White,
//    onTertiary = Color.White,
//    onBackground = Color(0xFF1C1B1F),
//    onSurface = Color(0xFF1C1B1F),
//    */
//)


//@Composable
//fun JawwiTheme(
//    darkTheme: Boolean = isSystemInDarkTheme(),
//    // Dynamic color is available on Android 12+
//    dynamicColor: Boolean = true,
//    content: @Composable () -> Unit
//) {
//    val colorScheme = when {
//        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
//            val context = LocalContext.current
//            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
//        }
//
//        darkTheme -> DarkColorScheme
//        else -> LightColorScheme
//    }
//
//    MaterialTheme(
//        colorScheme = colorScheme,
//        typography = Typography,
//        content = content
//    )
//}