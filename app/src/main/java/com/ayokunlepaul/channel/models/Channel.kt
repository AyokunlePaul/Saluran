package com.ayokunlepaul.channel.models

data class Channel(
    val title: String,
    val slug: String,
    val mediaCount: Int,
    val channelId: String,
    val iconAssetUrl: String,
    val coverAssetUrl: String,
    val latestMedia: List<ChannelEpisode>,
    val series: List<ChannelEpisode>
)