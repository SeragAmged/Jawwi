package com.sergio.jawwi.core

import com.sergio.jawwi.core.utils.JsonParserHelper
import com.sergio.jawwi.data.models.WeatherDataModel

/**
 * Provides dummy weather data models for testing and development purposes.
 * Contains various weather scenarios to help test different weather conditions
 * and app behaviors.
 */
object DummyData {
    // Original dummy data
    val dummyWeatherDataModel = WeatherDataModel.fromJson(
        JsonParserHelper.parseJsonString(
            """
            {
                "queryCost": 1,
                "latitude": 0.0,
                "longitude": 0.0,
                "resolvedAddress": "0.0,0.0",
                "address": "0.0,0.0",
                "timezone": "Etc/GMT",
                "tzoffset": 0.0,
                "description": "Similar temperatures continuing with a chance of rain tomorrow, Friday & Monday.",
                "days": [
                    {
                        "datetime": "2025-05-07",
                        "datetimeEpoch": 1746576000,
                        "tempmax": 28.3,
                        "tempmin": 27.4,
                        "temp": 28.1,
                        "feelslikemax": 32.5,
                        "feelslikemin": 30.7,
                        "feelslike": 31.9,
                        "dew": 24.0,
                        "humidity": 78.7,
                        "precip": 3.9,
                        "precipprob": 100.0,
                        "precipcover": 33.33,
                        "preciptype": [
                            "rain"
                        ],
                        "snow": 0.0,
                        "snowdepth": null,
                        "windgust": 15.9,
                        "windspeed": 15.4,
                        "winddir": 147.2,
                        "pressure": 1011.2,
                        "cloudcover": 51.7,
                        "visibility": 14.2,
                        "solarradiation": 104.8,
                        "solarenergy": 9.0,
                        "uvindex": 9.0,
                        "severerisk": 60.0,
                        "sunrise": "05:53:07",
                        "sunriseEpoch": 1746597187,
                        "sunset": "18:00:06",
                        "sunsetEpoch": 1746640806,
                        "moonphase": 0.33,
                        "conditions": "Rain, Partially cloudy",
                        "description": "Partly cloudy throughout the day with storms possible.",
                        "icon": "snow",
                        "stations": [
                            "remote"
                        ],
                        "source": "comb",
                        "hours": [
                            {
                                "datetime": "00:00:00",
                                "datetimeEpoch": 1746576000,
                                "temp": 27.9,
                                "feelslike": 31.8,
                                "humidity": 80.33,
                                "dew": 24.2,
                                "precip": 0.1,
                                "precipprob": 100.0,
                                "snow": null,
                                "snowdepth": null,
                                "preciptype": [
                                    "rain"
                                ],
                                "windgust": 14.1,
                                "windspeed": 13.6,
                                "winddir": 147.2,
                                "pressure": 1011.0,
                                "visibility": 15.0,
                                "cloudcover": 16.7,
                                "solarradiation": 0.0,
                                "solarenergy": 0.0,
                                "uvindex": 0.0,
                                "severerisk": 30.0,
                                "conditions": "Rain",
                                "icon": "rain",
                                "stations": [
                                    "remote"
                                ],
                                "source": "obs"
                            },
                            {
                                "datetime": "01:00:00",
                                "datetimeEpoch": 1746579600,
                                "temp": 27.8,
                                "feelslike": 31.5,
                                "humidity": 80.32,
                                "dew": 24.1,
                                "precip": 0.0,
                                "precipprob": 0.0,
                                "snow": 0.0,
                                "snowdepth": null,
                                "preciptype": [
                                    "rain"
                                ],
                                "windgust": 13.4,
                                "windspeed": 13.4,
                                "winddir": 149.9,
                                "pressure": 1011.0,
                                "visibility": 8.8,
                                "cloudcover": 22.6,
                                "solarradiation": 0.0,
                                "solarenergy": 0.0,
                                "uvindex": 0.0,
                                "severerisk": 30.0,
                                "conditions": "Partially cloudy",
                                "icon": "partly-cloudy-night",
                                "stations": [
                                    "remote"
                                ],
                                "source": "obs"
                            },
                            {
                                "datetime": "02:00:00",
                                "datetimeEpoch": 1746583200,
                                "temp": 27.8,
                                "feelslike": 31.5,
                                "humidity": 79.84,
                                "dew": 24.0,
                                "precip": 0.1,
                                "precipprob": 100.0,
                                "snow": 0.0,
                                "snowdepth": null,
                                "preciptype": [
                                    "rain"
                                ],
                                "windgust": 13.4,
                                "windspeed": 13.0,
                                "winddir": 153.2,
                                "pressure": 1010.0,
                                "visibility": 15.0,
                                "cloudcover": 17.8,
                                "solarradiation": 0.0,
                                "solarenergy": 0.0,
                                "uvindex": 0.0,
                                "severerisk": 30.0,
                                "conditions": "Rain",
                                "icon": "rain",
                                "stations": [
                                    "remote"
                                ],
                                "source": "obs"
                            },
                            {
                                "datetime": "03:00:00",
                                "datetimeEpoch": 1746586800,
                                "temp": 27.8,
                                "feelslike": 31.5,
                                "humidity": 79.84,
                                "dew": 24.0,
                                "precip": 0.3,
                                "precipprob": 100.0,
                                "snow": 0.0,
                                "snowdepth": null,
                                "preciptype": [
                                    "rain"
                                ],
                                "windgust": 12.8,
                                "windspeed": 12.3,
                                "winddir": 153.0,
                                "pressure": 1010.0,
                                "visibility": 8.7,
                                "cloudcover": 11.5,
                                "solarradiation": 0.0,
                                "solarenergy": 0.0,
                                "uvindex": 0.0,
                                "severerisk": 30.0,
                                "conditions": "Rain",
                                "icon": "rain",
                                "stations": [
                                    "remote"
                                ],
                                "source": "obs"
                            },
                            {
                                "datetime": "04:00:00",
                                "datetimeEpoch": 1746590400,
                                "temp": 27.4,
                                "feelslike": 30.7,
                                "humidity": 81.73,
                                "dew": 24.0,
                                "precip": 1.2,
                                "precipprob": 100.0,
                                "snow": 0.0,
                                "snowdepth": null,
                                "preciptype": [
                                    "rain"
                                ],
                                "windgust": 13.0,
                                "windspeed": 12.5,
                                "winddir": 150.0,
                                "pressure": 1010.0,
                                "visibility": 8.5,
                                "cloudcover": 5.0,
                                "solarradiation": 0.0,
                                "solarenergy": 0.0,
                                "uvindex": 0.0,
                                "severerisk": 30.0,
                                "conditions": "Rain",
                                "icon": "rain",
                                "stations": [
                                    "remote"
                                ],
                                "source": "obs"
                            },
                            {
                                "datetime": "05:00:00",
                                "datetimeEpoch": 1746594000,
                                "temp": 27.4,
                                "feelslike": 30.7,
                                "humidity": 81.73,
                                "dew": 24.0,
                                "precip": 1.1,
                                "precipprob": 100.0,
                                "snow": 0.0,
                                "snowdepth": null,
                                "preciptype": [
                                    "rain"
                                ],
                                "windgust": 14.5,
                                "windspeed": 13.4,
                                "winddir": 142.7,
                                "pressure": 1011.0,
                                "visibility": 15.0,
                                "cloudcover": 57.0,
                                "solarradiation": 0.0,
                                "solarenergy": 0.0,
                                "uvindex": 0.0,
                                "severerisk": 30.0,
                                "conditions": "Rain, Partially cloudy",
                                "icon": "rain",
                                "stations": [
                                    "remote"
                                ],
                                "source": "obs"
                            },
                            {
                                "datetime": "06:00:00",
                                "datetimeEpoch": 1746597600,
                                "temp": 27.6,
                                "feelslike": 31.1,
                                "humidity": 80.78,
                                "dew": 24.0,
                                "precip": 0.8,
                                "precipprob": 100.0,
                                "snow": null,
                                "snowdepth": null,
                                "preciptype": [
                                    "rain"
                                ],
                                "windgust": 15.0,
                                "windspeed": 13.6,
                                "winddir": 138.7,
                                "pressure": 1011.0,
                                "visibility": 15.0,
                                "cloudcover": 86.0,
                                "solarradiation": 0.0,
                                "solarenergy": 0.0,
                                "uvindex": 0.0,
                                "severerisk": 30.0,
                                "conditions": "Rain, Partially cloudy",
                                "icon": "rain",
                                "stations": [
                                    "remote"
                                ],
                                "source": "obs"
                            },
                            {
                                "datetime": "07:00:00",
                                "datetimeEpoch": 1746601200,
                                "temp": 28.1,
                                "feelslike": 32.0,
                                "humidity": 78.45,
                                "dew": 24.0,
                                "precip": 0.0,
                                "precipprob": 0.0,
                                "snow": 0.0,
                                "snowdepth": null,
                                "preciptype": null,
                                "windgust": 15.9,
                                "windspeed": 15.4,
                                "winddir": 136.7,
                                "pressure": 1012.0,
                                "visibility": 15.0,
                                "cloudcover": 99.6,
                                "solarradiation": 85.0,
                                "solarenergy": 0.3,
                                "uvindex": 1.0,
                                "severerisk": 30.0,
                                "conditions": "Overcast",
                                "icon": "cloudy",
                                "stations": [
                                    "remote"
                                ],
                                "source": "obs"
                            },
                            {
                                "datetime": "08:00:00",
                                "datetimeEpoch": 1746604800,
                                "temp": 28.3,
                                "feelslike": 32.2,
                                "humidity": 77.08,
                                "dew": 23.9,
                                "precip": 0.2,
                                "precipprob": 100.0,
                                "snow": 0.0,
                                "snowdepth": null,
                                "preciptype": [
                                    "rain"
                                ],
                                "windgust": 15.2,
                                "windspeed": 15.4,
                                "winddir": 136.2,
                                "pressure": 1013.0,
                                "visibility": 15.0,
                                "cloudcover": 100.0,
                                "solarradiation": 304.0,
                                "solarenergy": 1.1,
                                "uvindex": 3.0,
                                "severerisk": 30.0,
                                "conditions": "Rain, Overcast",
                                "icon": "rain",
                                "stations": [
                                    "remote"
                                ],
                                "source": "obs"
                            },
                            {
                                "datetime": "09:00:00",
                                "datetimeEpoch": 1746608400,
                                "temp": 28.3,
                                "feelslike": 32.2,
                                "humidity": 77.08,
                                "dew": 23.9,
                                "precip": 0.0,
                                "precipprob": 0.0,
                                "snow": 0.0,
                                "snowdepth": null,
                                "preciptype": null,
                                "windgust": 14.1,
                                "windspeed": 14.1,
                                "winddir": 135.7,
                                "pressure": 1013.0,
                                "visibility": 15.0,
                                "cloudcover": 69.5,
                                "solarradiation": 521.0,
                                "solarenergy": 1.9,
                                "uvindex": 5.0,
                                "severerisk": 30.0,
                                "conditions": "Partially cloudy",
                                "icon": "partly-cloudy-day",
                                "stations": [
                                    "remote"
                                ],
                                "source": "obs"
                            },
                            {
                                "datetime": "10:00:00",
                                "datetimeEpoch": 1746612000,
                                "temp": 28.3,
                                "feelslike": 32.2,
                                "humidity": 77.08,
                                "dew": 23.9,
                                "precip": 0.0,
                                "precipprob": 0.0,
                                "snow": 0.0,
                                "snowdepth": null,
                                "preciptype": null,
                                "windgust": 13.9,
                                "windspeed": 13.0,
                                "winddir": 138.8,
                                "pressure": 1013.0,
                                "visibility": 15.0,
                                "cloudcover": 12.9,
                                "solarradiation": 732.0,
                                "solarenergy": 2.6,
                                "uvindex": 7.0,
                                "severerisk": 30.0,
                                "conditions": "Clear",
                                "icon": "clear-day",
                                "stations": [
                                    "remote"
                                ],
                                "source": "obs"
                            },
                            {
                                "datetime": "11:00:00",
                                "datetimeEpoch": 1746615600,
                                "temp": 28.2,
                                "feelslike": 32.2,
                                "humidity": 78.0,
                                "dew": 24.0,
                                "precip": 0.0,
                                "precipprob": 0.0,
                                "snow": 0.0,
                                "snowdepth": null,
                                "preciptype": null,
                                "windgust": 12.1,
                                "windspeed": 11.4,
                                "winddir": 136.4,
                                "pressure": 1013.0,
                                "visibility": 15.0,
                                "cloudcover": 100.0,
                                "solarradiation": 874.0,
                                "solarenergy": 3.1,
                                "uvindex": 9.0,
                                "severerisk": 30.0,
                                "conditions": "Overcast",
                                "icon": "cloudy",
                                "stations": [
                                    "remote"
                                ],
                                "source": "obs"
                            },
                            {
                                "datetime": "12:00:00",
                                "datetimeEpoch": 1746619200,
                                "temp": 28.3,
                                "feelslike": 32.2,
                                "humidity": 77.08,
                                "dew": 23.9,
                                "precip": 0.0,
                                "precipprob": 0.0,
                                "snow": null,
                                "snowdepth": null,
                                "preciptype": null,
                                "windgust": 10.1,
                                "windspeed": 9.2,
                                "winddir": 137.9,
                                "pressure": 1012.0,
                                "visibility": 15.0,
                                "cloudcover": 53.7,
                                "solarradiation": 0.0,
                                "solarenergy": 0.0,
                                "uvindex": 0.0,
                                "severerisk": 30.0,
                                "conditions": "Partially cloudy",
                                "icon": "partly-cloudy-day",
                                "stations": [
                                    "remote"
                                ],
                                "source": "obs"
                            },
                            {
                                "datetime": "13:00:00",
                                "datetimeEpoch": 1746622800,
                                "temp": 28.2,
                                "feelslike": 32.2,
                                "humidity": 78.0,
                                "dew": 24.0,
                                "precip": 0.0,
                                "precipprob": 0.0,
                                "snow": 0.0,
                                "snowdepth": null,
                                "preciptype": [
                                    "rain"
                                ],
                                "windgust": 9.2,
                                "windspeed": 8.7,
                                "winddir": 141.5,
                                "pressure": 1011.0,
                                "visibility": 15.0,
                                "cloudcover": 85.8,
                                "solarradiation": 0.0,
                                "solarenergy": 0.0,
                                "uvindex": 0.0,
                                "severerisk": 30.0,
                                "conditions": "Partially cloudy",
                                "icon": "partly-cloudy-day",
                                "stations": [
                                    "remote"
                                ],
                                "source": "obs"
                            },
                            {
                                "datetime": "14:00:00",
                                "datetimeEpoch": 1746626400,
                                "temp": 28.3,
                                "feelslike": 32.4,
                                "humidity": 78.01,
                                "dew": 24.1,
                                "precip": 0.0,
                                "precipprob": 0.0,
                                "snow": 0.0,
                                "snowdepth": null,
                                "preciptype": [
                                    "rain"
                                ],
                                "windgust": 8.9,
                                "windspeed": 8.7,
                                "winddir": 147.1,
                                "pressure": 1010.0,
                                "visibility": 15.0,
                                "cloudcover": 78.7,
                                "solarradiation": 0.0,
                                "solarenergy": 0.0,
                                "uvindex": 0.0,
                                "severerisk": 60.0,
                                "conditions": "Partially cloudy",
                                "icon": "partly-cloudy-day",
                                "stations": [
                                    "remote"
                                ],
                                "source": "obs"
                            },
                            {
                                "datetime": "15:00:00",
                                "datetimeEpoch": 1746630000,
                                "temp": 28.3,
                                "feelslike": 32.5,
                                "humidity": 78.48,
                                "dew": 24.2,
                                "precip": 0.1,
                                "precipprob": 100.0,
                                "snow": 0.0,
                                "snowdepth": null,
                                "preciptype": [
                                    "rain"
                                ],
                                "windgust": 8.7,
                                "windspeed": 8.7,
                                "winddir": 150.2,
                                "pressure": 1010.0,
                                "visibility": 15.0,
                                "cloudcover": 100.0,
                                "solarradiation": 0.0,
                                "solarenergy": 0.0,
                                "uvindex": 0.0,
                                "severerisk": 60.0,
                                "conditions": "Rain, Overcast",
                                "icon": "rain",
                                "stations": [
                                    "remote"
                                ],
                                "source": "obs"
                            },
                            {
                                "datetime": "16:00:00",
                                "datetimeEpoch": 1746633600,
                                "temp": 28.3,
                                "feelslike": 32.5,
                                "humidity": 78.48,
                                "dew": 24.2,
                                "precip": 0.0,
                                "precipprob": 0.0,
                                "snow": 0.0,
                                "snowdepth": null,
                                "preciptype": null,
                                "windgust": 9.2,
                                "windspeed": 9.4,
                                "winddir": 144.3,
                                "pressure": 1010.0,
                                "visibility": 15.0,
                                "cloudcover": 100.0,
                                "solarradiation": 0.0,
                                "solarenergy": 0.0,
                                "uvindex": 0.0,
                                "severerisk": 60.0,
                                "conditions": "Overcast",
                                "icon": "cloudy",
                                "stations": [
                                    "remote"
                                ],
                                "source": "obs"
                            },
                            {
                                "datetime": "17:00:00",
                                "datetimeEpoch": 1746637200,
                                "temp": 28.3,
                                "feelslike": 32.3,
                                "humidity": 77.55,
                                "dew": 24.0,
                                "precip": 0.0,
                                "precipprob": 0.0,
                                "snow": 0.0,
                                "snowdepth": null,
                                "preciptype": null,
                                "windgust": 8.9,
                                "windspeed": 9.2,
                                "winddir": 147.3,
                                "pressure": 1010.0,
                                "visibility": 15.0,
                                "cloudcover": 12.9,
                                "solarradiation": 0.0,
                                "solarenergy": 0.0,
                                "uvindex": 0.0,
                                "severerisk": 30.0,
                                "conditions": "Clear",
                                "icon": "clear-day",
                                "stations": [
                                    "remote"
                                ],
                                "source": "obs"
                            },
                            {
                                "datetime": "18:00:00",
                                "datetimeEpoch": 1746640800,
                                "temp": 28.3,
                                "feelslike": 32.3,
                                "humidity": 77.55,
                                "dew": 24.0,
                                "precip": 0.0,
                                "precipprob": 41.9,
                                "snow": null,
                                "snowdepth": null,
                                "preciptype": null,
                                "windgust": 10.1,
                                "windspeed": 10.3,
                                "winddir": 147.1,
                                "pressure": 1010.0,
                                "visibility": 15.0,
                                "cloudcover": 22.4,
                                "solarradiation": 0.0,
                                "solarenergy": 0.0,
                                "uvindex": 0.0,
                                "severerisk": 30.0,
                                "conditions": "Partially cloudy",
                                "icon": "partly-cloudy-day",
                                "stations": null,
                                "source": "fcst"
                            },
                            {
                                "datetime": "19:00:00",
                                "datetimeEpoch": 1746644400,
                                "temp": 28.3,
                                "feelslike": 32.3,
                                "humidity": 77.55,
                                "dew": 24.0,
                                "precip": 0.0,
                                "precipprob": 19.4,
                                "snow": 0.0,
                                "snowdepth": null,
                                "preciptype": null,
                                "windgust": 10.1,
                                "windspeed": 9.8,
                                "winddir": 153.9,
                                "pressure": 1011.0,
                                "visibility": 15.0,
                                "cloudcover": 13.9,
                                "solarradiation": 0.0,
                                "solarenergy": 0.0,
                                "uvindex": 0.0,
                                "severerisk": 30.0,
                                "conditions": "Clear",
                                "icon": "clear-night",
                                "stations": null,
                                "source": "fcst"
                            },
                            {
                                "datetime": "20:00:00",
                                "datetimeEpoch": 1746648000,
                                "temp": 28.2,
                                "feelslike": 32.2,
                                "humidity": 78.0,
                                "dew": 24.0,
                                "precip": 0.0,
                                "precipprob": 19.4,
                                "snow": 0.0,
                                "snowdepth": null,
                                "preciptype": null,
                                "windgust": 9.6,
                                "windspeed": 9.4,
                                "winddir": 159.5,
                                "pressure": 1011.0,
                                "visibility": 15.0,
                                "cloudcover": 10.5,
                                "solarradiation": 0.0,
                                "solarenergy": 0.0,
                                "uvindex": 0.0,
                                "severerisk": 30.0,
                                "conditions": "Clear",
                                "icon": "clear-night",
                                "stations": null,
                                "source": "fcst"
                            },
                            {
                                "datetime": "21:00:00",
                                "datetimeEpoch": 1746651600,
                                "temp": 28.1,
                                "feelslike": 32.0,
                                "humidity": 78.45,
                                "dew": 24.0,
                                "precip": 0.0,
                                "precipprob": 19.4,
                                "snow": 0.0,
                                "snowdepth": null,
                                "preciptype": null,
                                "windgust": 9.6,
                                "windspeed": 8.9,
                                "winddir": 167.3,
                                "pressure": 1012.0,
                                "visibility": 15.0,
                                "cloudcover": 16.8,
                                "solarradiation": 0.0,
                                "solarenergy": 0.0,
                                "uvindex": 0.0,
                                "severerisk": 30.0,
                                "conditions": "Clear",
                                "icon": "clear-night",
                                "stations": null,
                                "source": "fcst"
                            },
                            {
                                "datetime": "22:00:00",
                                "datetimeEpoch": 1746655200,
                                "temp": 28.1,
                                "feelslike": 32.1,
                                "humidity": 78.93,
                                "dew": 24.1,
                                "precip": 0.0,
                                "precipprob": 19.4,
                                "snow": 0.0,
                                "snowdepth": null,
                                "preciptype": [
                                    "rain"
                                ],
                                "windgust": 9.2,
                                "windspeed": 8.9,
                                "winddir": 171.7,
                                "pressure": 1012.0,
                                "visibility": 15.0,
                                "cloudcover": 98.5,
                                "solarradiation": 0.0,
                                "solarenergy": 0.0,
                                "uvindex": 0.0,
                                "severerisk": 30.0,
                                "conditions": "Overcast",
                                "icon": "cloudy",
                                "stations": null,
                                "source": "fcst"
                            },
                            {
                                "datetime": "23:00:00",
                                "datetimeEpoch": 1746658800,
                                "temp": 28.1,
                                "feelslike": 32.1,
                                "humidity": 79.4,
                                "dew": 24.2,
                                "precip": 0.0,
                                "precipprob": 19.4,
                                "snow": 0.0,
                                "snowdepth": null,
                                "preciptype": [
                                    "rain"
                                ],
                                "windgust": 9.8,
                                "windspeed": 9.4,
                                "winddir": 175.9,
                                "pressure": 1012.0,
                                "visibility": 15.0,
                                "cloudcover": 50.1,
                                "solarradiation": 0.0,
                                "solarenergy": 0.0,
                                "uvindex": 0.0,
                                "severerisk": 30.0,
                                "conditions": "Partially cloudy",
                                "icon": "partly-cloudy-night",
                                "stations": null,
                                "source": "fcst"
                            }
                        ]
                    }
                
                ],
                "alerts":[
  {
    "event": "Flash Flood Watch",
    "description": "Heavy rainfall may lead to flash flooding. Be prepared to move to higher ground."
  },
  {
    "event": "Severe Thunderstorm Warning",
    "description": "Large hail and damaging winds possible. Seek shelter immediately."
  },
  {
    "event": "Tornado Watch",
    "description": "Conditions are favorable for tornadoes. Stay alert for severe weather updates."
  }
],
                "currentConditions": {
                    "datetime": "18:00:00",
                    "datetimeEpoch": 1746640800,
                    "temp": 22.0,
                    "feelslike": 22.0,
                    "humidity": 63.3,
                    "dew": 14.7,
                    "precip": 0.0,
                    "precipprob": 0.0,
                    "snow": null,
                    "snowdepth": 0.0,
                    "preciptype": null,
                    "windgust": null,
                    "windspeed": 10.3,
                    "winddir": 147.1,
                    "pressure": 1010.0,
                    "visibility": null,
                    "cloudcover": 22.4,
                    "solarradiation": 0.0,
                    "solarenergy": 0.0,
                    "uvindex": 0.0,
                    "conditions": "Partially cloudy",
                    "icon": "partly-cloudy-day",
                    "stations": [
                        "VSLK2",
                        "BOWK2",
                        "FPCI3"
                    ],
                    "source": "obs",
                    "sunrise": "05:53:07",
                    "sunriseEpoch": 1746597187,
                    "sunset": "18:00:06",
                    "sunsetEpoch": 1746640806,
                    "moonphase": 0.33
                }
            }
            """.trimIndent()
        )
    )

    // Sunny day scenario with high temperatures and no precipitation
    val sunnyDayScenario = WeatherDataModel.fromJson(
        JsonParserHelper.parseJsonString(
            """
            {
                "timezone": "Etc/GMT",
                "description": "Clear skies and warm temperatures throughout the day.",
                "alerts": [],
                "days": [{
                    "datetime": "2025-05-07",
                    "tempmax": 35.0,
                    "tempmin": 25.0,
                    "temp": 30.0,
                    "feelslike": 32.0,
                    "humidity": 45.0,
                    "precip": 0.0,
                    "precipprob": 0.0,
                    "conditions": "Clear",
                    "icon": "clear-day",
                    "sunrise": "05:53:07",
                    "sunset": "18:00:06"
                }],
                "currentConditions": {
                    "temp": 32.0,
                    "feelslike": 34.0,
                    "humidity": 40.0,
                    "conditions": "Clear",
                    "icon": "clear-day",
                    "sunrise": "05:53:07",
                    "sunset": "18:00:06"
                }
            }
            """.trimIndent()
        )
    )

    // Stormy weather scenario with severe alerts
    val stormyWeatherScenario = WeatherDataModel.fromJson(
        JsonParserHelper.parseJsonString(
            """
            {
                "timezone": "Etc/GMT",
                "description": "Severe thunderstorms with potential flooding.",
                "alerts": [
                    {
                        "event": "Severe Thunderstorm Warning",
                        "description": "Damaging winds and large hail possible. Seek shelter immediately."
                    },
                    {
                        "event": "Flash Flood Warning",
                        "description": "Flash flooding is occurring or imminent. Move to higher ground."
                    }
                ],
                "days": [{
                    "datetime": "2025-05-07",
                    "tempmax": 28.0,
                    "tempmin": 22.0,
                    "temp": 24.0,
                    "feelslike": 26.0,
                    "humidity": 85.0,
                    "precip": 50.0,
                    "precipprob": 100.0,
                    "conditions": "Thunder and Rain",
                    "icon": "thunder-rain",
                    "sunrise": "05:53:07",
                    "sunset": "18:00:06"
                }],
                "currentConditions": {
                    "temp": 23.0,
                    "feelslike": 25.0,
                    "humidity": 90.0,
                    "conditions": "Thunder and Rain",
                    "icon": "thunder-rain",
                    "sunrise": "05:53:07",
                    "sunset": "18:00:06"
                }
            }
            """.trimIndent()
        )
    )

    // Snowy day scenario
    val snowyDayScenario = WeatherDataModel.fromJson(
        JsonParserHelper.parseJsonString(
            """
            {
                "timezone": "Etc/GMT",
                "description": "Heavy snowfall throughout the day.",
                "alerts": [
                    {
                        "event": "Winter Storm Warning",
                        "description": "Heavy snow and reduced visibility. Avoid unnecessary travel."
                    }
                ],
                "days": [{
                    "datetime": "2025-05-07",
                    "tempmax": 0.0,
                    "tempmin": -5.0,
                    "temp": -2.0,
                    "feelslike": -7.0,
                    "humidity": 80.0,
                    "snow": 15.0,
                    "conditions": "Snow",
                    "icon": "snow",
                    "sunrise": "07:53:07",
                    "sunset": "16:00:06"
                }],
                "currentConditions": {
                    "temp": -3.0,
                    "feelslike": -8.0,
                    "humidity": 85.0,
                    "conditions": "Snow",
                    "icon": "snow",
                    "sunrise": "07:53:07",
                    "sunset": "16:00:06"
                }
            }
            """.trimIndent()
        )
    )

    // Foggy day scenario
    val foggyDayScenario = WeatherDataModel.fromJson(
        JsonParserHelper.parseJsonString(
            """
            {
                "timezone": "Etc/GMT",
                "description": "Dense fog with reduced visibility.",
                "alerts": [
                    {
                        "event": "Dense Fog Advisory",
                        "description": "Visibility less than 1/4 mile. Use caution while driving."
                    }
                ],
                "days": [{
                    "datetime": "2025-05-07",
                    "tempmax": 18.0,
                    "tempmin": 15.0,
                    "temp": 16.0,
                    "feelslike": 16.0,
                    "humidity": 95.0,
                    "visibility": 0.5,
                    "conditions": "Fog",
                    "icon": "fog",
                    "sunrise": "06:53:07",
                    "sunset": "17:00:06"
                }],
                "currentConditions": {
                    "temp": 16.0,
                    "feelslike": 16.0,
                    "humidity": 98.0,
                    "visibility": 0.2,
                    "conditions": "Dense Fog",
                    "icon": "fog",
                    "sunrise": "06:53:07",
                    "sunset": "17:00:06"
                }
            }
            """.trimIndent()
        )
    )

    // Windy day scenario
    val windyDayScenario = WeatherDataModel.fromJson(
        JsonParserHelper.parseJsonString(
            """
            {
                "timezone": "Etc/GMT",
                "description": "Very windy conditions with gusts up to 80 km/h.",
                "alerts": [
                    {
                        "event": "High Wind Warning",
                        "description": "Damaging winds could blow down trees and power lines."
                    }
                ],
                "days": [{
                    "datetime": "2025-05-07",
                    "tempmax": 22.0,
                    "tempmin": 18.0,
                    "temp": 20.0,
                    "feelslike": 15.0,
                    "humidity": 50.0,
                    "windspeed": 45.0,
                    "windgust": 80.0,
                    "winddir": 270.0,
                    "conditions": "Windy",
                    "icon": "wind",
                    "sunrise": "06:53:07",
                    "sunset": "17:00:06"
                }],
                "currentConditions": {
                    "temp": 20.0,
                    "feelslike": 15.0,
                    "humidity": 45.0,
                    "windspeed": 50.0,
                    "windgust": 85.0,
                    "winddir": 275.0,
                    "conditions": "Very Windy",
                    "icon": "wind",
                    "sunrise": "06:53:07",
                    "sunset": "17:00:06"
                }
            }
            """.trimIndent()
        )
    )
}

