package com.ayokunlepaul.data.models

data class EpisodeEntity(
    val id: Long,
    val type: String,
    val title: String,
    val coverAssetUrl: String,
    val channelTitle: String
)