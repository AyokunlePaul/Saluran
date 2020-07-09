package com.ayokunlepaul.local.mappers

import com.ayokunlepaul.data.BaseMapper
import com.ayokunlepaul.data.models.EpisodeEntity
import com.ayokunlepaul.local.models.EpisodeLocalModel
import javax.inject.Inject

class EpisodeLocalModelMapper @Inject constructor() : BaseMapper<EpisodeLocalModel, EpisodeEntity> {

    override fun toEntity(value: EpisodeLocalModel): EpisodeEntity {
        return EpisodeEntity(
            id = 0,
            title = value.title,
            channelTitle = value.channelTitle,
            coverAssetUrl = value.coverAssetUrl,
            type = value.type
        )
    }

    override fun toModel(value: EpisodeEntity): EpisodeLocalModel {
        return EpisodeLocalModel(
            id = 0,
            title = value.title,
            channelTitle = value.channelTitle,
            coverAssetUrl = value.coverAssetUrl,
            type = value.type
        )
    }
}