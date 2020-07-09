package com.ayokunlepaul.data.repository

import com.ayokunlepaul.data.models.NewEpisodeEntity
import com.ayokunlepaul.data.utils.errors.IllegalModuleAccessException
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single

interface NewEpisodesRepository {

    var hasSavedNewEpisodesBefore: Boolean

    fun getNewEpisodes(): Observable<List<NewEpisodeEntity>>

    fun saveNewEpisodes(value: List<NewEpisodeEntity>): Single<Int> =
        throw IllegalModuleAccessException()
}