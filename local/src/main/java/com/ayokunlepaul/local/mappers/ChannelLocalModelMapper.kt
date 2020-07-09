package com.ayokunlepaul.local.mappers

import com.ayokunlepaul.data.BaseMapper
import com.ayokunlepaul.data.models.ChannelEntity
import com.ayokunlepaul.local.models.ChannelLocalModel
import javax.inject.Inject

class ChannelLocalModelMapper @Inject constructor(
    private val channelEpisodeLocalMapper: ChannelEpisodeLocalMapper
) : BaseMapper<ChannelLocalModel, ChannelEntity> {

    override fun toEntity(value: ChannelLocalModel): ChannelEntity {
        return ChannelEntity(
            channelId = value.channelId,
            title = value.title,
            coverAssetUrl = value.coverAssetUrl,
            iconAssetUrl = value.iconAssetUrl,
            latestMedia = channelEpisodeLocalMapper.toEntityList(value.latestMedia),
            mediaCount = value.mediaCount,
            series = channelEpisodeLocalMapper.toEntityList(value.series),
            slug = value.slug
        )
    }

    override fun toModel(value: ChannelEntity): ChannelLocalModel {
        return ChannelLocalModel(
            id = 0,
            channelId = value.channelId,
            title = value.title,
            coverAssetUrl = value.coverAssetUrl,
            iconAssetUrl = value.iconAssetUrl,
            latestMedia = channelEpisodeLocalMapper.toModelList(value.latestMedia),
            mediaCount = value.mediaCount,
            series = channelEpisodeLocalMapper.toModelList(value.series),
            slug = value.slug
        )
    }
}