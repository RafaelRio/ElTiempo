package com.rafario.eltiempo.data.mappers

import com.rafario.eltiempo.data.dto.current.CurrentWeatherDto
import com.rafario.eltiempo.data.entities.current.CurrentWeatherEntity

fun CurrentWeatherDto.toEntity(): CurrentWeatherEntity {
    return CurrentWeatherEntity(
        lastUpdated = last_updated,
        temperatureCelsius = temp_c,
        condition = condition.toEntity(),
        windSpeed = wind_kph,
        windDirection = wind_dir,
        pressure = pressure_mb,
        humidity = humidity,
        cloudCover = cloud,
        feelsLikeTemperature = feelslike_c,
        uvIndex = uv,
        isDay = is_day == 1
    )
}