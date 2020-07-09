package com.ayokunlepaul.data.models

data class ChannelEntity(
    val title: String,
    val mediaCount: Int,
    val channelId: String,
    val iconAssetUrl: String,
    val coverAssetUrl: String,
    val latestMedia: List<ChannelEpisodeEntity>,
    val series: List<ChannelEpisodeEntity>
)