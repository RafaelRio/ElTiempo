package com.rafario.eltiempo.data.mappers

import com.rafario.eltiempo.data.dto.location.LocationDto
import com.rafario.eltiempo.data.entities.location.LocationEntity

fun LocationDto.toEntity(): LocationEntity {
    return LocationEntity(
        name = name,
        region = region,
        country = country,
        latitude = lat,
        longitude = lon,
        timezoneId = tz_id,
        localTime = localtime
    )
}