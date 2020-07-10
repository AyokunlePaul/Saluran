package com.ayokunlepaul.channel.models

data class Channel(
    val title: String,
    val slug: String,
    val mediaCount: Int,
    val channelId: String,
    val iconAssetUrl: String,
    val coverAssetUrl: String,
    val latestMedia: List<ChannelEpisode>,
    val series: List<ChannelEpisode>
) {

    val isSeries = series.isNotEmpty()

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Channel

        if (title != other.title) return false
        if (slug != other.slug) return false
        if (mediaCount != other.mediaCount) return false
        if (channelId != other.channelId) return false
        if (iconAssetUrl != other.iconAssetUrl) return false
        if (coverAssetUrl != other.coverAssetUrl) return false
        if (latestMedia != other.latestMedia) return false
        if (series != other.series) return false

        return true
    }

    override fun hashCode(): Int {
        var result = title.hashCode()
        result = 31 * result + slug.hashCode()
        result = 31 * result + mediaCount
        result = 31 * result + channelId.hashCode()
        result = 31 * result + iconAssetUrl.hashCode()
        result = 31 * result + coverAssetUrl.hashCode()
        result = 31 * result + latestMedia.hashCode()
        result = 31 * result + series.hashCode()
        return result
    }
}