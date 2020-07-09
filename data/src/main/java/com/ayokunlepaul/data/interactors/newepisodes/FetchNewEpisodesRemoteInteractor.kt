package com.ayokunlepaul.data.interactors.newepisodes

import com.ayokunlepaul.data.di.RemoteRepositoryImpl
import com.ayokunlepaul.data.interactors.ObservableInteractor
import com.ayokunlepaul.data.models.EpisodeEntity
import com.ayokunlepaul.data.repository.NewEpisodeRepository
import com.ayokunlepaul.data.utils.SaluranScheduler
import io.reactivex.Observable
import javax.inject.Inject

class FetchNewEpisodesRemoteInteractor @Inject constructor(
    scheduler: SaluranScheduler,
    @RemoteRepositoryImpl private val newEpisodeRepository: NewEpisodeRepository
) : ObservableInteractor<Nothing, List<EpisodeEntity>>(scheduler) {

    override fun buildUseCaseObservable(parameter: Nothing?): Observable<List<EpisodeEntity>> {
        return newEpisodeRepository.getNewEpisodes()
    }
}