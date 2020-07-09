package com.ayokunlepaul.remote.model

import com.ayokunlepaul.remote.model.base.SingleStringWrapper

data class ChannelEpisodeRemoteModel(
    val title: String?,
    val type: String?,
    val coverAsset: SingleStringWrapper?
)