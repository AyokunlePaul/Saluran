package com.ayokunlepaul.channel.data

data class NewEpisodes(
    val type: String,
    val title: String,
    val coverAsset: CoverAsset,
    val channel: CoverAsset
)