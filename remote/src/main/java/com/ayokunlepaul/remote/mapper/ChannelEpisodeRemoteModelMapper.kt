package com.ayokunlepaul.remote.mapper

import com.ayokunlepaul.data.BaseMapper
import com.ayokunlepaul.data.models.ChannelEpisodeEntity
import com.ayokunlepaul.remote.model.ChannelEpisodeRemoteModel
import javax.inject.Inject

class ChannelEpisodeRemoteModelMapper @Inject constructor() : BaseMapper<ChannelEpisodeRemoteModel, ChannelEpisodeEntity> {

    override fun toEntity(value: ChannelEpisodeRemoteModel): ChannelEpisodeEntity {
        return ChannelEpisodeEntity(
            type = safeString(value.type),
            coverAssetUrl = safeString(value.coverAsset?.data),
            title = safeString(value.title)
        )
    }
}