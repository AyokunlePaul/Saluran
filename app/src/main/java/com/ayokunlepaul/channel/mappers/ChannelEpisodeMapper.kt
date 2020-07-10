package com.ayokunlepaul.channel.mappers

import com.ayokunlepaul.channel.models.ChannelEpisode
import com.ayokunlepaul.data.BaseMapper
import com.ayokunlepaul.data.models.ChannelEpisodeEntity
import javax.inject.Inject

class ChannelEpisodeMapper @Inject constructor(

) : BaseMapper<ChannelEpisode, ChannelEpisodeEntity> {

    override fun toEntity(value: ChannelEpisode): ChannelEpisodeEntity {
        return ChannelEpisodeEntity(
            type = value.type,
            coverAssetUrl = value.coverAssetUrl,
            title = value.title
        )
    }

    override fun toModel(value: ChannelEpisodeEntity): ChannelEpisode {
        return ChannelEpisode(
            type = value.type,
            coverAssetUrl = value.coverAssetUrl,
            title = value.title
        )
    }
}