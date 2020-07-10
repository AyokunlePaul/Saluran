package com.ayokunlepaul.data.models

data class EpisodeEntity(
    val id: Long,
    val type: String,
    val title: String,
    val coverAssetUrl: String,
    val channelTitle: String
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as EpisodeEntity

        if (id != other.id) return false
        if (type != other.type) return false
        if (title != other.title) return false
        if (coverAssetUrl != other.coverAssetUrl) return false
        if (channelTitle != other.channelTitle) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + type.hashCode()
        result = 31 * result + title.hashCode()
        result = 31 * result + coverAssetUrl.hashCode()
        result = 31 * result + channelTitle.hashCode()
        return result
    }
}