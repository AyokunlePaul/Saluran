package com.ayokunlepaul.channel.models

data class Episode(
    val id: Long,
    val type: String,
    val title: String,
    val coverAssetUrl: String,
    val channelTitle: String
)