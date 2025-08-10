package com.rafario.eltiempo.data.mappers

import com.rafario.eltiempo.data.dto.forecast.ConditionDto
import com.rafario.eltiempo.data.entities.ConditionEntity

fun ConditionDto.toEntity(): ConditionEntity {
    return ConditionEntity(
        text = text,
        icon = icon,
        code = code
    )
}