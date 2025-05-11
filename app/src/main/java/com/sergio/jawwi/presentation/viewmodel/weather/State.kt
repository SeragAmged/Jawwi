package com.sergio.jawwi.presentation.viewmodel.weather

import com.sergio.jawwi.data.models.WeatherDataModel

sealed class State {
    object Loading : State()
    data class DataLoaded(val weatherData: WeatherDataModel) : State()
    data class Error(val message: String, val errorType: com.sergio.jawwi.presentation.viewmodel.weather.ErrorType) : State()
}

enum class ErrorType {
    NoInternet,
    LocationPermissionDenied,
    DataError,
    LocationDisabled,
}