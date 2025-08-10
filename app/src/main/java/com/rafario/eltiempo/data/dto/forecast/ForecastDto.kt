package com.rafario.eltiempo.data.dto.forecast


data class ForecastDto(
    val forecastday: List<ForecastDayDto>
)

data class ForecastDayDto(
    val date: String,
    val day: DayDto,
    val astro: AstroDto,
    val hour: List<HourDto>
)

data class DayDto(
    val maxtemp_c: Double,
    val maxtemp_f: Double,
    val mintemp_c: Double,
    val mintemp_f: Double,
    val avgtemp_c: Double,
    val avgtemp_f: Double,
    val maxwind_mph: Double,
    val maxwind_kph: Double,
    val totalprecip_mm: Int,
    val totalprecip_in: Int,
    val totalsnow_cm: Int,
    val avgvis_km: Int,
    val avgvis_miles: Int,
    val avghumidity: Int,
    val daily_will_it_rain: Int,
    val daily_chance_of_rain: Int,
    val daily_will_it_snow: Int,
    val daily_chance_of_snow: Int,
    val condition: ConditionDto,
    val uv: Double
)

data class ConditionDto(
    val text: String,
    val icon: String,
    val code: Int
)

data class AstroDto(
    val sunrise: String,
    val sunset: String,
    val moonrise: String,
    val moonset: String,
    val moon_phase: String,
    val moon_illumination: Int,
    val is_moon_up: Int,
    val is_sun_up: Int
)

data class HourDto(
    val time_epoch: Long,
    val time: String,
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
    val snow_cm: Int,
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
    val will_it_rain: Int,
    val chance_of_rain: Int,
    val will_it_snow: Int,
    val chance_of_snow: Int,
    val vis_km: Int,
    val vis_miles: Int,
    val gust_mph: Double,
    val gust_kph: Double,
    val uv: Int,
    val short_rad: Int,
    val diff_rad: Int,
    val dni: Int,
    val gti: Int
)
