package com.rafario.eltiempo.data.dto.forecast

import com.rafario.eltiempo.data.dto.location.LocationDto
import com.rafario.eltiempo.data.dto.current.CurrentWeatherDto

data class ForecastResponse(
    val location: LocationDto,
    val current: CurrentWeatherDto,
    val forecast: ForecastDto
)