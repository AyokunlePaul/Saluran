package com.ayokunlepaul.remote.mapper

import com.ayokunlepaul.data.BaseMapper
import com.ayokunlepaul.data.models.EpisodeEntity
import com.ayokunlepaul.remote.model.EpisodeRemoteModel

class EpisodeRemoteModelMapper : BaseMapper<EpisodeRemoteModel, EpisodeEntity> {

    override fun toEntity(value: EpisodeRemoteModel): EpisodeEntity {
        return EpisodeEntity(
            id = 0,
            title = safeString(value.title),
            channelTitle = safeString(value.channel?.data),
            coverAssetUrl = safeString(value.coverAsset?.data),
            type = safeString(value.type)
        )
    }
}