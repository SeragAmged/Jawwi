package com.sergio.jawwi.core.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.luminance
import com.sergio.jawwi.R

/**
 * Represents a theme for weather conditions, including an icon, primary color,
 * gradient colors, and text color.
 *
 * @property icon The resource ID of the weather icon.
 * @property color The primary color of the theme.
 * @property gradient A list of colors representing the gradient background.
 * @property textColor The color of the text for this theme.
 */
data class WeatherTheme(
    val icon: Int,
    val color: Color,
    val gradient: List<Color>,
    val textColor: Color
) {
    companion object {
        /**
         * The default weather theme used when no specific theme matches.
         */
        val Default = WeatherTheme(
            icon = R.drawable.clear_day,
            color = Color(0xFF4B80FF),
            gradient = listOf(Color(0xFF4B80FF), Color(0xFF9CC0FF)),
            textColor = Color.White
        )

        /**
         * Returns a [WeatherTheme] based on the provided weather icon string.
         *
         * @param icon The weather icon string (e.g., "snow", "rain").
         * @return A [WeatherTheme] corresponding to the icon, or the default theme if no match is found.
         */
        fun fromIcon(icon: String?): WeatherTheme {
            return when (icon) {
                "snow" -> WeatherTheme(
                    R.drawable.snow,
                    Color(0xFFD0E6F6),
                    listOf(Color(0xFFD0E6F6), Color(0xFFB0CDE9)),
                    Color.Black
                )

                "snow-showers-day" -> WeatherTheme(
                    R.drawable.snow_showers_day,
                    Color(0xFFCFE4F7),
                    listOf(Color(0xFFCFE4F7), Color(0xFFA0BBD6)),
                    Color.Black
                )

                "snow-showers-night" -> WeatherTheme(
                    R.drawable.snow_showers_night,
                    Color(0xFFA0BBD6),
                    listOf(Color(0xFFA0BBD6), Color(0xFF5F7A9B)),
                    Color.Black
                )

                "thunder-rain" -> WeatherTheme(
                    R.drawable.thunder_rain,
                    Color(0xFF4A536B),
                    listOf(Color(0xFF4A536B), Color(0xFF1B1D26)),
                    Color.White
                )

                "thunder-showers-day" -> WeatherTheme(
                    R.drawable.thunder_showers_day,
                    Color(0xFF5A6980),
                    listOf(Color(0xFF5A6980), Color(0xFF2E3A56)),
                    Color.White
                )

                "thunder-showers-night" -> WeatherTheme(
                    R.drawable.thunder_showers_night,
                    Color(0xFF3B4A65),
                    listOf(Color(0xFF3B4A65), Color(0xFF1A2439)),
                    Color.White
                )

                "rain" -> WeatherTheme(
                    R.drawable.rain,
                    Color(0xFF4A90E2),
                    listOf(Color(0xFF4A90E2), Color(0xFF50A7F3)),
                    Color.White
                )

                "showers-day" -> WeatherTheme(
                    R.drawable.showers_day,
                    Color(0xFF81C2F3),
                    listOf(Color(0xFF81C2F3), Color(0xFF4A90E2)),
                    Color.White
                )

                "showers-night" -> WeatherTheme(
                    R.drawable.showers_night,
                    Color(0xFF3B5F87),
                    listOf(Color(0xFF3B5F87), Color(0xFF2D456A)),
                    Color.White
                )

                "fog" -> WeatherTheme(
                    R.drawable.fog,
                    Color(0xFF9E9E9E),
                    listOf(Color(0xFF9E9E9E), Color(0xFF757575)),
                    Color.White
                )

                "wind" -> WeatherTheme(
                    R.drawable.wind,
                    Color(0xFFA3B8C2),
                    listOf(Color(0xFFA3B8C2), Color(0xFF6D8A99)),
                    Color.White
                )

                "cloudy" -> WeatherTheme(
                    R.drawable.cloudy,
                    Color(0xFFB0BEC5),
                    listOf(Color(0xFFB0BEC5), Color(0xFF90A4AE)),
                    Color.White
                )

                "partly-cloudy-day" -> WeatherTheme(
                    R.drawable.partly_cloudy_day,
                    Color(0xFF8FC9F0),
                    listOf(Color(0xFF8FC9F0), Color(0xFFC6DEF8)),
                    Color.Black
                )

                "partly-cloudy-night" -> WeatherTheme(
                    R.drawable.partly_cloudy_night,
                    Color(0xFF6B8AA7),
                    listOf(Color(0xFF6B8AA7), Color(0xFF3B4E68)),
                    Color.White
                )

                "clear-day" -> WeatherTheme(
                    R.drawable.clear_day,
                    Color(0xFF4B80FF),
                    listOf(Color(0xFF4B80FF), Color(0xFF9CC0FF)),
                    Color.White
                )

                "clear-night" -> WeatherTheme(
                    R.drawable.clear_night,
                    Color(0xFF283593),
                    listOf(Color(0xFF021024),Color(0xFF052659)),
                    Color.White
                )

                else -> Default
            }
        }

        /**
         * Converts the current [WeatherTheme] into a [ColorScheme] for Material 3.
         *
         * @param isDark Whether the color scheme should be dark or light.
         * @return A [ColorScheme] based on the current theme.
         */
        fun WeatherTheme.toColorScheme(isDark: Boolean = false): ColorScheme {
            return if (isDark) {
                darkColorScheme(
                    primary = color,
                    onPrimary = if (color.luminance() > 0.5f) Color.Black else Color.White,
                    background = gradient.firstOrNull() ?: color,
                    onBackground = if ((gradient.firstOrNull() ?: color).luminance() > 0.5f) Color.Black else Color.White,
                    surface = gradient.lastOrNull() ?: color,
                    onSurface = if ((gradient.lastOrNull() ?: color).luminance() > 0.5f) Color.Black else Color.White,
                )
            } else {
                lightColorScheme(
                    primary = color,
                    onPrimary = if (color.luminance() > 0.5f) Color.Black else Color.White,
                    background = gradient.firstOrNull() ?: color,
                    onBackground = if ((gradient.firstOrNull() ?: color).luminance() > 0.5f) Color.Black else Color.White,
                    surface = gradient.lastOrNull() ?: color,
                    onSurface = if ((gradient.lastOrNull() ?: color).luminance() > 0.5f) Color.Black else Color.White,
                )
            }
        }
    }
}

