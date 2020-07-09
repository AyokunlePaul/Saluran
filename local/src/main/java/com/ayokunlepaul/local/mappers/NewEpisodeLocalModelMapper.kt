package com.ayokunlepaul.local.mappers

import com.ayokunlepaul.data.BaseMapper
import com.ayokunlepaul.data.models.NewEpisodeEntity
import com.ayokunlepaul.local.models.NewEpisodeLocalModel

class NewEpisodeLocalModelMapper : BaseMapper<NewEpisodeLocalModel, NewEpisodeEntity> {

    override fun toEntity(value: NewEpisodeLocalModel): NewEpisodeEntity {
        return NewEpisodeEntity(
            id = 0,
            title = value.title,
            channelTitle = value.channelTitle,
            coverAssetUrl = value.coverAssetUrl,
            type = value.type
        )
    }

    override fun toModel(value: NewEpisodeEntity): NewEpisodeLocalModel {
        return NewEpisodeLocalModel(
            id = 0,
            title = value.title,
            channelTitle = value.channelTitle,
            coverAssetUrl = value.coverAssetUrl,
            type = value.type
        )
    }
}