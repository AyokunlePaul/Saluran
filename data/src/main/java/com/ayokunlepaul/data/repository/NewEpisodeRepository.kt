package com.ayokunlepaul.data.repository

import com.ayokunlepaul.data.models.EpisodeEntity
import com.ayokunlepaul.data.utils.errors.IllegalModuleAccessException
import io.reactivex.Observable
import io.reactivex.Single

interface NewEpisodeRepository {

    var hasSavedNewEpisodesBefore: Boolean

    fun getNewEpisodes(): Observable<List<EpisodeEntity>>

    fun saveNewEpisodes(value: List<EpisodeEntity>): Single<Int> =
        throw IllegalModuleAccessException()
}