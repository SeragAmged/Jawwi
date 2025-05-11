package com.sergio.jawwi.data.models

/**
 * Represents a weather alert with an event name and description.
 *
 * @property event The name of the weather alert event (e.g., "Flood Warning").
 * @property description A detailed description of the weather alert.
 */
data class AlertDataModel(
    val event: String,
    val description: String
) {
    companion object {
        /**
         * Creates an instance of [AlertDataModel] from a map representation.
         *
         * @param map A map containing the alert data, typically parsed from JSON.
         * @return An [AlertDataModel] instance populated with the data from the map.
         */
        fun fromJson(map: Map<String, Any?>?): AlertDataModel {
            return AlertDataModel(
                event = map?.get("event")?.toString().orEmpty(),
                description = map?.get("description")?.toString().orEmpty()
            )
        }
    }
}
