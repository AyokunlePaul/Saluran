package com.ayokunlepaul.channel.data

import com.google.gson.annotations.SerializedName

data class CoverAsset(
    @SerializedName("url", alternate = ["title"]) val assetData: String
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as CoverAsset

        if (assetData != other.assetData) return false

        return true
    }

    override fun hashCode(): Int {
        return assetData.hashCode()
    }
}