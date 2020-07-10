package com.ayokunlepaul.remote.impl

import com.ayokunlepaul.data.di.LocalRepositoryImpl
import com.ayokunlepaul.data.models.ChannelEntity
import com.ayokunlepaul.data.repository.ChannelsRepository
import com.ayokunlepaul.data.utils.errors.IllegalModuleAccessException
import com.ayokunlepaul.remote.mapper.ChannelRemoteModelMapper
import com.ayokunlepaul.remote.services.SaluranService
import com.ayokunlepaul.remote.utils.executeOnError
import io.reactivex.Observable
import javax.inject.Inject

class ChannelsRepositoryImpl @Inject constructor(
    private val service: SaluranService,
    private val channelRemoteModelMapper: ChannelRemoteModelMapper,
    @LocalRepositoryImpl private val channelsRepository: ChannelsRepository
) : ChannelsRepository {
    override fun getAllChannels(): Observable<List<ChannelEntity>> {
        return service.getAllChannels().executeOnError().flatMap {
            channelsRepository.saveChannels(
                channelRemoteModelMapper.toEntityList(it.data.channels)
            )
        }.flatMapObservable {
            channelsRepository.hasFetchedChannelBefore = true
            channelsRepository.getAllChannels()
        }
    }

    override var hasFetchedChannelBefore: Boolean
        get() = throw IllegalModuleAccessException()
        set(@Suppress("UNUSED_PARAMETER") value) {}
}