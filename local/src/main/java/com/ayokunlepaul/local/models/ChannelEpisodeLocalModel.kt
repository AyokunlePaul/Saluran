package com.ayokunlepaul.local.models

import androidx.room.ColumnInfo

data class ChannelEpisodeLocalModel(
    val type: String,
    @ColumnInfo(name = "channel_episode_title") val title: String,
    val coverAssetUrl: String
)