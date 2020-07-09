package com.ayokunlepaul.channel.models

sealed class SaluranState {

    object Loading : SaluranState()

    data class Failed(
        val message: String
    ) : SaluranState()

    data class Successful<T>(
        val message: String?,
        val data: T
    ) : SaluranState()
}