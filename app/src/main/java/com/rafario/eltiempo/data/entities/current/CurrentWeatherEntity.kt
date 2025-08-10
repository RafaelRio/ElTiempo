package com.rafario.eltiempo.data.entities.current

import com.rafario.eltiempo.data.entities.ConditionEntity

data class CurrentWeatherEntity(
    val lastUpdated: String,
    val temperatureCelsius: Double,
    val isDay: Boolean,
    val condition: ConditionEntity,
    val windSpeed: Double,
    val windDirection: String,
    val pressure: Int,
    val humidity: Int,
    val cloudCover: Int,
    val feelsLikeTemperature: Double,
    val uvIndex: Int,
)
