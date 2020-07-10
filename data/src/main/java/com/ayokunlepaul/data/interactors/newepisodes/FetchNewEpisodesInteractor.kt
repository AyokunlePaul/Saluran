package com.ayokunlepaul.data.interactors.newepisodes

import com.ayokunlepaul.data.di.LocalRepositoryImpl
import com.ayokunlepaul.data.interactors.ObservableInteractor
import com.ayokunlepaul.data.models.EpisodeEntity
import com.ayokunlepaul.data.repository.NewEpisodesRepository
import com.ayokunlepaul.data.utils.SaluranScheduler
import io.reactivex.Observable
import javax.inject.Inject

class FetchNewEpisodesInteractor @Inject constructor(
    scheduler: SaluranScheduler,
    @LocalRepositoryImpl private val repository: NewEpisodesRepository,
    private val newEpisodeLocalInteractor: FetchNewEpisodeLocalInteractor,
    private val newEpisodesRemoteInteractor: FetchNewEpisodesRemoteInteractor
) : ObservableInteractor<Nothing, List<EpisodeEntity>>(scheduler) {

    override fun buildUseCaseObservable(parameter: Nothing?): Observable<List<EpisodeEntity>> {
        return if (repository.hasSavedNewEpisodesBefore) newEpisodeLocalInteractor.buildUseCaseObservable(
            parameter
        )
        else newEpisodesRemoteInteractor.buildUseCaseObservable(parameter)
    }
}