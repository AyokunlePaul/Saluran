package com.ayokunlepaul.local.mappers

import com.ayokunlepaul.data.BaseMapper
import com.ayokunlepaul.data.models.ChannelEpisodeEntity
import com.ayokunlepaul.local.models.ChannelEpisodeLocalModel
import javax.inject.Inject

class ChannelEpisodeLocalMapper @Inject constructor(): BaseMapper<ChannelEpisodeLocalModel, ChannelEpisodeEntity> {

    override fun toEntity(value: ChannelEpisodeLocalModel): ChannelEpisodeEntity {
        return ChannelEpisodeEntity(
            type = value.type,
            coverAssetUrl = value.coverAssetUrl,
            title = value.title
        )
    }

    override fun toModel(value: ChannelEpisodeEntity): ChannelEpisodeLocalModel {
        return ChannelEpisodeLocalModel(
            type = value.type,
            coverAssetUrl = value.coverAssetUrl,
            title = value.title
        )
    }
}