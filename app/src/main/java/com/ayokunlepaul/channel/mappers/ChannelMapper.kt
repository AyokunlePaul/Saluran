package com.ayokunlepaul.channel.mappers

import com.ayokunlepaul.channel.models.Channel
import com.ayokunlepaul.data.BaseMapper
import com.ayokunlepaul.data.models.ChannelEntity
import javax.inject.Inject

class ChannelMapper @Inject constructor(
    private val channelEpisodeMapper: ChannelEpisodeMapper
) : BaseMapper<Channel, ChannelEntity> {

    override fun toEntity(value: Channel): ChannelEntity {
        return ChannelEntity(
            channelId = value.channelId,
            title = value.title,
            coverAssetUrl = value.coverAssetUrl,
            iconAssetUrl = value.iconAssetUrl,
            latestMedia = channelEpisodeMapper.toEntityList(value.latestMedia),
            mediaCount = value.mediaCount,
            series = channelEpisodeMapper.toEntityList(value.series),
            slug = value.slug
        )
    }

    override fun toModel(value: ChannelEntity): Channel {
        return Channel(
            channelId = value.channelId,
            title = value.title,
            coverAssetUrl = value.coverAssetUrl,
            iconAssetUrl = value.iconAssetUrl,
            latestMedia = channelEpisodeMapper.toModelList(value.latestMedia),
            mediaCount = value.mediaCount,
            series = channelEpisodeMapper.toModelList(value.series),
            slug = value.slug
        )
    }
}