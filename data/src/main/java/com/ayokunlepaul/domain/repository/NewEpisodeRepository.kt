package com.ayokunlepaul.domain.repository

import com.ayokunlepaul.domain.models.NewEpisodeEntity
import io.reactivex.Observable

interface NewEpisodeRepository {

    fun getNewEpisodes(): Observable<List<NewEpisodeEntity>>
}