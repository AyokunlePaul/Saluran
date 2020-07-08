package com.ayokunlepaul.domain.models

data class NewEpisodeEntity(
    val id: Long,
    val type: String,
    val title: String,
    val coverAssetUrl: String,
    val channelTitle: String
)