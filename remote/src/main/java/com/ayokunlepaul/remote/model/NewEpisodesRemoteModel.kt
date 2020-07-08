package com.ayokunlepaul.remote.model

import com.ayokunlepaul.remote.model.base.SingleStringWrapper

data class NewEpisodesRemoteModel(
    val title: String,
    val type: String,
    val coverAsset: SingleStringWrapper,
    val channel: SingleStringWrapper
)