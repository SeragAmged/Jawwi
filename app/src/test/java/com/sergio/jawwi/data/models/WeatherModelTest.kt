package com.sergio.jawwi.data.models

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test
import java.time.LocalDate
import java.time.LocalTime

class WeatherModelTest {

    @Test
    fun `test AlertDataModel fromJson with valid data`() {
        val alertMap = mapOf(
            "event" to "Severe Storm",
            "description" to "Heavy rainfall expected"
        )

        val alert = AlertDataModel.fromJson(alertMap)

        assertEquals("Severe Storm", alert.event)
        assertEquals("Heavy rainfall expected", alert.description)
    }

    @Test
    fun `test AlertDataModel fromJson with empty data`() {
        val alert = AlertDataModel.fromJson(null)

        assertEquals("", alert.event)
        assertEquals("", alert.description)
    }

    @Test
    fun `test WeatherForecastDataModel fromJson with complete data`() {
        val forecastMap = mapOf(
            "temp" to 25.5,
            "feelslike" to 26.0,
            "humidity" to 80.0,
            "precipprob" to 30.0,
            "windspeed" to 15.2,
            "winddir" to 180.0,
            "pressure" to 1015.0,
            "cloudcover" to 75.0,
            "visibility" to 10.0,
            "conditions" to "Partly Cloudy",
            "icon" to "partly-cloudy-day",
            "datetime" to "14:00:00"
        )

        val forecast = WeatherForecastDataModel.fromJson(forecastMap, false)

        assertEquals(26, forecast.temp)
        assertEquals(26, forecast.feelsLike)
        assertEquals(80, forecast.humidity)
        assertEquals(30, forecast.precipitationProb)
        assertEquals(15, forecast.windSpeed)
        assertEquals(180.0, forecast.windDir)
        assertEquals(1015, forecast.pressure)
        assertEquals(75, forecast.cloudCoverPercentage)
        assertEquals(10, forecast.visibilityKm)
        assertEquals("Partly Cloudy", forecast.conditions)
        assertEquals("partly-cloudy-day", forecast.icon)
        assertEquals(LocalTime.parse("14:00:00"), forecast.datetime)
    }

    @Test
    fun `test WeatherDataModel fromJson parses complete weather data`() {
        val weatherMap = mapOf(
            "timezone" to "UTC",
            "description" to "Clear skies",
            "alerts" to listOf(
                mapOf(
                    "event" to "Heat Warning",
                    "description" to "High temperatures expected"
                )
            ),
            "currentConditions" to mapOf(
                "temp" to 30.0,
                "feelslike" to 32.0,
                "conditions" to "Clear",
                "icon" to "clear-day"
            ),
            "days" to listOf(
                mapOf(
                    "datetime" to "2025-05-11",
                    "tempmax" to 32.0,
                    "tempmin" to 25.0,
                    "temp" to 28.5,
                    "conditions" to "Clear",
                    "icon" to "clear-day"
                )
            )
        )

        val weatherData = WeatherDataModel.fromJson(weatherMap)

        assertEquals("UTC", weatherData.timezone)
        assertEquals("Clear skies", weatherData.description)
        assertEquals(1, weatherData.alerts.size)
        assertEquals("Heat Warning", weatherData.alerts[0].event)
        assertEquals(30, weatherData.currentConditions.temp)
        assertEquals(1, weatherData.days.size)
        assertEquals(LocalDate.parse("2025-05-11"), weatherData.days[0].datetime)
        assertEquals(32, weatherData.days[0].tempMax)
        assertEquals(25, weatherData.days[0].tempMin)
    }

    @Test
    fun `test WeatherForecastDataModel handles null values gracefully`() {
        val forecastMap = mapOf<String, Any?>()

        val forecast = WeatherForecastDataModel.fromJson(forecastMap, false)

        assertNull(forecast.temp)
        assertNull(forecast.feelsLike)
        assertNull(forecast.humidity)
        assertNull(forecast.precipitationProb)
        assertNull(forecast.windSpeed)
        assertNull(forecast.windDir)
        assertNull(forecast.conditions)
        assertNull(forecast.icon)
    }
}