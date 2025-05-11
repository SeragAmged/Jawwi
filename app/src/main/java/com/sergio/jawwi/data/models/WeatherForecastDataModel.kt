package com.sergio.jawwi.data.models

import java.time.LocalDate
import java.time.LocalTime
import kotlin.math.roundToInt

/**
 * Represents detailed weather forecast data, including temperature, wind, precipitation,
 * and other weather-related metrics.
 *
 * @property datetime The date or time of the forecast, parsed as [LocalDate] or [LocalTime].
 * @property tempMax The maximum temperature for the forecast period, in degrees.
 * @property tempMin The minimum temperature for the forecast period, in degrees.
 * @property temp The average temperature for the forecast period, in degrees.
 * @property feelsLike The "feels like" temperature, accounting for wind chill or heat index.
 * @property humidity The humidity percentage.
 * @property precipitationProb The probability of precipitation, as a percentage.
 * @property windSpeed The wind speed, in kilometers per hour.
 * @property windDir The wind direction, in degrees (0–360).
 * @property pressure The atmospheric pressure, in hPa.
 * @property cloudCoverPercentage The percentage of cloud cover.
 * @property visibilityKm The visibility distance, in kilometers.
 * @property snow The amount of snowfall, in millimeters.
 * @property snowDepth The depth of snow on the ground, in millimeters.
 * @property solarRadiation The solar radiation, in W/m².
 * @property solarEnergy The solar energy, in kWh/m².
 * @property uvIndex The UV index value.
 * @property severeRisk The risk level of severe weather, as an integer.
 * @property sunrise The time of sunrise, as [LocalTime].
 * @property sunset The time of sunset, as [LocalTime].
 * @property conditions A brief description of the weather conditions (e.g., "Clear").
 * @property description A detailed description of the weather.
 * @property icon The icon identifier for the weather condition.
 * @property hours A list of hourly weather forecasts, represented as [WeatherForecastDataModel].
 */
data class WeatherForecastDataModel(
    val datetime: Any?,
    val tempMax: Int?,
    val tempMin: Int?,
    val temp: Int?,
    val feelsLike: Int?,
    val humidity: Int?,
    val precipitationProb: Int?,
    val windSpeed: Int?,
    val windDir: Double?,
    val pressure: Int?,
    val cloudCoverPercentage: Int?,
    val visibilityKm: Int?,
    val snow: Int?,
    val snowDepth: Int?,
    val solarRadiation: Double?,
    val solarEnergy: Double?,
    val uvIndex: Int?,
    val severeRisk: Int?,
    val sunrise: LocalTime?,
    val sunset: LocalTime?,
    val conditions: String?,
    val description: String?,
    val icon: String?,
    val hours: List<WeatherForecastDataModel>?
) {

    companion object {
        /**
         * Converts a map representation of weather forecast data into a [WeatherForecastDataModel] instance.
         *
         * This function parses the provided map, typically obtained from a JSON response,
         * and converts it into a structured [WeatherForecastDataModel] object. It handles nested
         * structures such as hourly forecasts.
         *
         * @param map A map containing weather forecast data, typically parsed from JSON.
         * @param hasHours A boolean indicating whether the map contains hourly forecast data.
         * @return A [WeatherForecastDataModel] instance populated with the data from the map.
         */
        fun fromJson(map: Map<String, Any?>, hasHours: Boolean): WeatherForecastDataModel {
            return WeatherForecastDataModel(
                tempMax = (map["tempmax"] as? Number)?.toDouble()?.roundToInt(),
                tempMin = (map["tempmin"] as? Number)?.toDouble()?.roundToInt(),
                temp = (map["temp"] as? Number)?.toDouble()?.roundToInt(),
                feelsLike = (map["feelslike"] as? Number)?.toDouble()?.roundToInt(),
                humidity = (map["humidity"] as? Number)?.toDouble()?.roundToInt(),
                precipitationProb = (map["precipprob"] as? Number)?.toDouble()?.roundToInt(),
                windSpeed = (map["windspeed"] as? Number)?.toDouble()?.roundToInt(),
                windDir = (map["winddir"] as? Number)?.toDouble(),
                pressure = (map["pressure"] as? Number)?.toDouble()?.roundToInt(),
                cloudCoverPercentage = (map["cloudcover"] as? Number)?.toDouble()?.roundToInt(),
                visibilityKm = (map["visibility"] as? Number)?.toDouble()?.roundToInt(),
                snow = (map["snow"] as? Number)?.toDouble()?.roundToInt(),
                snowDepth = (map["snowdepth"] as? Number)?.toDouble()?.roundToInt(),
                solarRadiation = (map["solarradiation"] as? Number)?.toDouble(),
                solarEnergy = (map["solarenergy"] as? Number)?.toDouble(),
                uvIndex = (map["uvindex"] as? Number)?.toDouble()?.roundToInt(),
                severeRisk = (map["severerisk"] as? Number)?.toDouble()?.roundToInt(),
                sunrise = (map["sunrise"] as? String)?.let {
                    runCatching { LocalTime.parse(it) }.getOrNull()
                },
                sunset = (map["sunset"] as? String)?.let {
                    runCatching { LocalTime.parse(it) }.getOrNull()
                },
                conditions = map["conditions"] as? String,
                description = map["description"] as? String,
                icon = map["icon"] as? String,
                hours = if (!hasHours) null else {
                    (map["hours"] as? List<*>)?.mapNotNull {
                        (it as? Map<String, Any?>)?.let { innerMap ->
                            fromJson(innerMap, false)
                        }
                    }
                },
                datetime = (map["datetime"] as? String)?.let { datetimeStr ->
                    runCatching { LocalDate.parse(datetimeStr) }
                        .getOrElse {
                            runCatching { LocalTime.parse(datetimeStr) }.getOrNull()
                        }
                }
            )
        }
    }
}
