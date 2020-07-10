package com.ayokunlepaul.remote.mapper

import com.ayokunlepaul.data.BaseMapper
import com.ayokunlepaul.data.models.ChannelEntity
import com.ayokunlepaul.remote.model.ChannelRemoteModel
import javax.inject.Inject

class ChannelRemoteModelMapper @Inject constructor(
    private val channelEpisodeRemoteModelMapper: ChannelEpisodeRemoteModelMapper
) : BaseMapper<ChannelRemoteModel, ChannelEntity> {

    override fun toEntity(value: ChannelRemoteModel): ChannelEntity {
        return ChannelEntity(
            channelId = safeString(value.id),
            slug = safeString(value.slug),
            title = safeString(value.title),
            coverAssetUrl = safeString(value.coverAsset?.data),
            iconAssetUrl = safeString(value.iconAsset?.data),
            latestMedia = channelEpisodeRemoteModelMapper.toEntityList(safeList(value.latestMedia)),
            mediaCount = safeInt(value.mediaCount),
            series = channelEpisodeRemoteModelMapper.toEntityList(safeList(value.series))
        )
    }
}