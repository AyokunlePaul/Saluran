package com.ayokunlepaul.data.interactors.newepisodes

import com.ayokunlepaul.data.di.LocalRepositoryImpl
import com.ayokunlepaul.data.interactors.ObservableInteractor
import com.ayokunlepaul.data.models.EpisodeEntity
import com.ayokunlepaul.data.repository.NewEpisodesRepository
import com.ayokunlepaul.data.utils.SaluranScheduler
import io.reactivex.Observable
import javax.inject.Inject

class FetchNewEpisodeLocalInteractor @Inject constructor(
    scheduler: SaluranScheduler,
    @LocalRepositoryImpl private val newEpisodesRepository: NewEpisodesRepository
) : ObservableInteractor<Nothing, List<EpisodeEntity>>(scheduler) {

    override fun buildUseCaseObservable(parameter: Nothing?): Observable<List<EpisodeEntity>> {
        return newEpisodesRepository.getNewEpisodes()
    }
}