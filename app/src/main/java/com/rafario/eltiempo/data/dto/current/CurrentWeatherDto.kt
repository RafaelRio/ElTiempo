package com.rafario.eltiempo.data.dto.current

import com.rafario.eltiempo.data.dto.forecast.ConditionDto

@Suppress("PropertyName")
data class CurrentWeatherDto(
    val last_updated_epoch: Long,
    val last_updated: String,
    val temp_c: Double,
    val temp_f: Double,
    val is_day: Int,
    val condition: ConditionDto,
    val wind_mph: Double,
    val wind_kph: Double,
    val wind_degree: Int,
    val wind_dir: String,
    val pressure_mb: Int,
    val pressure_in: Double,
    val precip_mm: Int,
    val precip_in: Int,
    val humidity: Int,
    val cloud: Int,
    val feelslike_c: Double,
    val feelslike_f: Double,
    val windchill_c: Double,
    val windchill_f: Double,
    val heatindex_c: Double,
    val heatindex_f: Double,
    val dewpoint_c: Double,
    val dewpoint_f: Double,
    val vis_km: Int,
    val vis_miles: Int,
    val uv: Int,
    val gust_mph: Double,
    val gust_kph: Double,
    val short_rad: Int,
    val diff_rad: Int,
    val dni: Int,
    val gti: Int
)
