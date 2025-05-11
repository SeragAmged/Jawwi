@file:Suppress("UNCHECKED_CAST")

package com.sergio.jawwi.data.models

/**
 * Represents the weather data model containing information about the timezone,
 * description, alerts, current conditions, and daily forecasts.
 *
 * @property timezone The timezone of the weather data.
 * @property description A brief description of the weather.
 * @property alerts A list of weather alerts.
 * @property currentConditions The current weather conditions.
 * @property days A list of daily weather forecasts.
 */
data class WeatherDataModel(
    val timezone: String?,
    val description: String?,
    val alerts: List<AlertDataModel>,
    val currentConditions: WeatherForecastDataModel,
    val days: List<WeatherForecastDataModel>
) {
    companion object {
        /**
         * Converts a map representation of weather data into a [WeatherDataModel] instance.
         *
         * @param map A map containing weather data, typically parsed from JSON.
         * @return A [WeatherDataModel] instance populated with the data from the map.
         */
        fun fromJson(map: Map<String, Any?>): WeatherDataModel {
            // Extract timezone and description from the map.
            val timezone = map["timezone"] as? String
            val description = map["description"] as? String

            // Parse alerts from the map into a list of [AlertDataModel].
            val alerts = (map["alerts"] as? List<*>)?.mapNotNull {
                (it as? Map<String, Any?>)?.let { innerMap ->
                    AlertDataModel.fromJson(innerMap)
                }
            } ?: emptyList()

            // Parse current conditions from the map into a [WeatherForecastDataModel].
            val currentConditions = (map["currentConditions"] as? Map<String, Any?>)?.let {
                WeatherForecastDataModel.fromJson(it, false)
            } ?: WeatherForecastDataModel.fromJson(emptyMap(), false)

            // Parse daily forecasts from the map into a list of [WeatherForecastDataModel].
            val days = (map["days"] as? List<*>)?.mapNotNull {
                (it as? Map<String, Any?>)?.let { innerMap ->
                    WeatherForecastDataModel.fromJson(innerMap, true)
                }
            } ?: emptyList()

            // Return a new instance of [WeatherDataModel] with the parsed data.
            return WeatherDataModel(
                timezone = timezone,
                description = description,
                alerts = alerts,
                currentConditions = currentConditions,
                days = days
            )
        }
    }
}
