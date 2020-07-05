package com.ayokunlepaul.channel.data

import com.google.gson.annotations.SerializedName

data class CoverAsset(
    @SerializedName("url", alternate = ["title"]) val assetData: String
)