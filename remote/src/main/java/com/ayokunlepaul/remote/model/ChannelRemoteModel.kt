package com.ayokunlepaul.remote.model

import com.ayokunlepaul.remote.model.base.SingleStringWrapper

data class ChannelRemoteModel(
    val title: String?,
    val slug: String?,
    val mediaCount: Int?,
    val id: String?,
    val iconAsset: SingleStringWrapper?,
    val coverAsset: SingleStringWrapper?,
    val latestMedia: List<ChannelEpisodeRemoteModel>?,
    val series: List<ChannelEpisodeRemoteModel>?
)