package com.ayokunlepaul.data.interactors.channels

import com.ayokunlepaul.data.di.LocalRepositoryImpl
import com.ayokunlepaul.data.interactors.ObservableInteractor
import com.ayokunlepaul.data.models.ChannelEntity
import com.ayokunlepaul.data.repository.ChannelRepository
import com.ayokunlepaul.data.utils.SaluranScheduler
import io.reactivex.Observable
import javax.inject.Inject

class FetchChannelsLocalInteractor @Inject constructor(
    scheduler: SaluranScheduler,
    @LocalRepositoryImpl private val channelRepository: ChannelRepository
) : ObservableInteractor<Nothing, List<ChannelEntity>>(scheduler) {

    override fun buildUseCaseObservable(parameter: Nothing?): Observable<List<ChannelEntity>> {
        return channelRepository.getAllChannels()
    }
}