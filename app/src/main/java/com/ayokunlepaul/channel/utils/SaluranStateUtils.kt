package com.ayokunlepaul.channel.utils

import com.ayokunlepaul.channel.models.SaluranState

object SaluranStateUtils {

    fun loading() = SaluranState.Loading

    fun failure(message: String?) = SaluranState.Failed(message ?: SaluranConstants.DEFAULT_MESSAGE)

    fun <T> success(message: String? = null, data: T) =
        SaluranState.Successful(message = message, data = data)
}