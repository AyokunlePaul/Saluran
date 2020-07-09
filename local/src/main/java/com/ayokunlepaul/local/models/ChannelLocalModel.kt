package com.ayokunlepaul.local.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "channels")
data class ChannelLocalModel(
    @PrimaryKey(autoGenerate = true) val id: Long,
    val title: String,
    val slug: String,
    val mediaCount: Int,
    val channelId: String,
    val iconAssetUrl: String,
    val coverAssetUrl: String,
    val latestMedia: List<ChannelEpisodeLocalModel>,
    val series: List<ChannelEpisodeLocalModel>
)