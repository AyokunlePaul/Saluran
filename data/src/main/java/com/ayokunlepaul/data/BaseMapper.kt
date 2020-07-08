package com.ayokunlepaul.data

import com.ayokunlepaul.data.utils.errors.InvalidModuleException

interface BaseMapper<MODEL, ENTITY> {

    fun toModel(value: ENTITY): MODEL = throw InvalidModuleException()

    fun toEntity(value: MODEL): ENTITY

    fun toModelList(values: List<ENTITY>) = values.map { toModel(it) }

    fun toEntityList(values: List<MODEL>) = values.map { toEntity(it) }

    fun safeString(value: String?) = value ?: ""

    fun safeInt(value: Int?) = value ?: 0

    fun safeBoolean(value: Boolean?) = value ?: false

    fun <T> safeList(value: List<T>?) = value ?: emptyList()
}