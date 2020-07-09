package com.ayokunlepaul.remote.impl

import com.ayokunlepaul.data.di.LocalRepositoryImpl
import com.ayokunlepaul.data.models.ChannelEntity
import com.ayokunlepaul.data.repository.ChannelRepository
import com.ayokunlepaul.data.utils.errors.IllegalModuleAccessException
import com.ayokunlepaul.remote.mapper.ChannelRemoteModelMapper
import com.ayokunlepaul.remote.services.SaluranService
import com.ayokunlepaul.remote.utils.executeOnError
import io.reactivex.Observable
import javax.inject.Inject

class ChannelRepositoryImpl @Inject constructor(
    private val service: SaluranService,
    private val channelRemoteModelMapper: ChannelRemoteModelMapper,
    @LocalRepositoryImpl private val channelRepository: ChannelRepository
) : ChannelRepository {
    override fun getAllChannels(): Observable<List<ChannelEntity>> {
        return service.getAllChannels().executeOnError().flatMap {
            channelRepository.saveChannels(
                channelRemoteModelMapper.toEntityList(it.data.channels)
            )
        }.flatMapObservable {
            channelRepository.hasFetchedChannelBefore = true
            channelRepository.getAllChannels()
        }
    }

    override var hasFetchedChannelBefore: Boolean
        get() = throw IllegalModuleAccessException()
        set(@Suppress("UNUSED_PARAMETER") value) {}
}