package com.rafario.eltiempo.data.entities.location

data class LocationEntity(
    val name: String,
    val region: String,
    val country: String,
    val latitude: Double,
    val longitude: Double,
    val timezoneId: String,
    val localTime: String
)
