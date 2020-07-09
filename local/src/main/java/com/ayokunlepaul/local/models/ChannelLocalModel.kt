package com.ayokunlepaul.local.models

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "channels")
data class ChannelLocalModel(
    @PrimaryKey(autoGenerate = true) val id: Long,
    val title: String,
    val mediaCount: Int,
    val channelId: String,
    val iconAssetUrl: String,
    val coverAssetUrl: String,
    @Embedded val latestMedia: List<ChannelEpisodeLocalModel>,
    @Embedded val series: List<ChannelEpisodeLocalModel>
)