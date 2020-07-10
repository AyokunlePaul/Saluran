package com.ayokunlepaul.remote.model.base

import com.google.gson.annotations.SerializedName

data class SingleStringWrapper(
    @SerializedName("url", alternate = ["thumbnailUrl", "title", "name"])
    val data: String
)