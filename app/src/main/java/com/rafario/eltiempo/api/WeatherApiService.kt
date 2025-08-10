package com.rafario.eltiempo.api

import com.rafario.eltiempo.data.dto.forecast.ForecastResponse
import com.rafario.eltiempo.utils.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApiService {

    @GET("forecast.json")
    suspend fun getCurrentWeather(
        @Query("key") apiKey: String = API_KEY,
        @Query("q") location: String,
        @Query("days") days: Int = 14,
    ): Response<ForecastResponse>
}