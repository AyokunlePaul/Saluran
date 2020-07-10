package com.ayokunlepaul.data.interactors.channels

import com.ayokunlepaul.data.di.LocalRepositoryImpl
import com.ayokunlepaul.data.interactors.ObservableInteractor
import com.ayokunlepaul.data.models.ChannelEntity
import com.ayokunlepaul.data.repository.ChannelsRepository
import com.ayokunlepaul.data.utils.SaluranScheduler
import io.reactivex.Observable
import javax.inject.Inject

class FetchChannelsInteractor @Inject constructor(
    scheduler: SaluranScheduler,
    @LocalRepositoryImpl private val channelsRepository: ChannelsRepository,
    private val channelsRemoteInteractor: FetchChannelsRemoteInteractor,
    private val channelsLocalInteractor: FetchChannelsLocalInteractor
) : ObservableInteractor<Nothing, List<ChannelEntity>>(scheduler) {

    override fun buildUseCaseObservable(parameter: Nothing?): Observable<List<ChannelEntity>> {
        return if (channelsRepository.hasFetchedChannelBefore) channelsLocalInteractor.buildUseCaseObservable()
        else channelsRemoteInteractor.buildUseCaseObservable()
    }
}