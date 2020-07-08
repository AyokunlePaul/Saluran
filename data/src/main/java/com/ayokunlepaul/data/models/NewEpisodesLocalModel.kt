package com.ayokunlepaul.data.models

data class NewEpisodeEntity(
    val id: Long,
    val type: String,
    val title: String,
    val coverAssetUrl: String,
    val channelTitle: String
)