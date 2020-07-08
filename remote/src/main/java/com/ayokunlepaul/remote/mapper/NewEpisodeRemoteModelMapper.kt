package com.ayokunlepaul.remote.mapper

import com.ayokunlepaul.data.BaseMapper
import com.ayokunlepaul.data.models.NewEpisodeEntity
import com.ayokunlepaul.remote.model.NewEpisodeRemoteModel

class NewEpisodeRemoteModelMapper : BaseMapper<NewEpisodeRemoteModel, NewEpisodeEntity> {

    override fun toEntity(value: NewEpisodeRemoteModel): NewEpisodeEntity {
        return NewEpisodeEntity(
            id = 0,
            title = value.title,
            channelTitle = value.channel.data,
            coverAssetUrl = value.coverAsset.data,
            type = value.type
        )
    }
}