package com.ayokunlepaul.data.repository

import com.ayokunlepaul.data.models.NewEpisodeEntity
import io.reactivex.Observable

interface NewEpisodesRepository {

    var hasSavedNewEpisodesBefore: Boolean

    fun getNewEpisodes(): Observable<List<NewEpisodeEntity>>
}