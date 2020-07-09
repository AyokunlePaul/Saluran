package com.ayokunlepaul.channel.models

data class ChannelEpisode(
    val type: String,
    val title: String,
    val coverAssetUrl: String
) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ChannelEpisode

        if (type != other.type) return false
        if (title != other.title) return false
        if (coverAssetUrl != other.coverAssetUrl) return false

        return true
    }

    override fun hashCode(): Int {
        var result = type.hashCode()
        result = 31 * result + title.hashCode()
        result = 31 * result + coverAssetUrl.hashCode()
        return result
    }
}