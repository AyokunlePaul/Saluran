package com.ayokunlepaul.channel.mappers

import com.ayokunlepaul.channel.models.Episode
import com.ayokunlepaul.data.BaseMapper
import com.ayokunlepaul.data.models.EpisodeEntity
import javax.inject.Inject

class EpisodeMapper @Inject constructor() : BaseMapper<Episode, EpisodeEntity> {

    override fun toEntity(value: Episode): EpisodeEntity {
        return EpisodeEntity(
            id = 0,
            title = value.title,
            channelTitle = value.channelTitle,
            coverAssetUrl = value.coverAssetUrl,
            type = value.type
        )
    }

    override fun toModel(value: EpisodeEntity): Episode {
        return Episode(
            id = 0,
            title = value.title,
            channelTitle = value.channelTitle,
            coverAssetUrl = value.coverAssetUrl,
            type = value.type
        )
    }
}