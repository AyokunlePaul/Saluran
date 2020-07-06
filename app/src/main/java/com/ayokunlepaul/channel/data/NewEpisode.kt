package com.ayokunlepaul.channel.data

data class NewEpisode(
    val type: String,
    val title: String,
    val coverAsset: CoverAsset,
    val channel: CoverAsset
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as NewEpisode

        if (type != other.type) return false
        if (title != other.title) return false
        if (coverAsset != other.coverAsset) return false
        if (channel != other.channel) return false

        return true
    }

    override fun hashCode(): Int {
        var result = type.hashCode()
        result = 31 * result + title.hashCode()
        result = 31 * result + coverAsset.hashCode()
        result = 31 * result + channel.hashCode()
        return result
    }

    override fun toString(): String = title
}