package com.ayokunlepaul.remote.model.base

import com.google.gson.annotations.SerializedName

data class SingleStringWrapper(
    @SerializedName("url", alternate = ["thumbnailUrl", "title"])
    val data: String
)