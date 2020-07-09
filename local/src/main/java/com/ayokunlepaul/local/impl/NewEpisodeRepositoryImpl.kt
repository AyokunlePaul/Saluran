package com.ayokunlepaul.local.impl

import com.ayokunlepaul.data.models.EpisodeEntity
import com.ayokunlepaul.data.repository.NewEpisodeRepository
import com.ayokunlepaul.local.mappers.EpisodeLocalModelMapper
import com.ayokunlepaul.local.pref.SaluranSharedPref
import com.ayokunlepaul.local.room.daos.NewEpisodesDao
import com.ayokunlepaul.local.utils.SaluranLocalConstants
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

class NewEpisodeRepositoryImpl @Inject constructor(
    private val sharedPref: SaluranSharedPref,
    private val newEpisodesDao: NewEpisodesDao,
    private val episodeLocalModelMapper: EpisodeLocalModelMapper
) : NewEpisodeRepository {

    override var hasSavedNewEpisodesBefore: Boolean
        get() = sharedPref.getBoolean(SaluranLocalConstants.HAS_FETCHED_NEW_EPISODES_BEFORE)
        set(value) {
            sharedPref.setBoolean(SaluranLocalConstants.HAS_FETCHED_NEW_EPISODES_BEFORE, value)
        }

    override fun getNewEpisodes(): Observable<List<EpisodeEntity>> {
        return newEpisodesDao.getAllNewEpisodes().map {
            episodeLocalModelMapper.toEntityList(it)
        }
    }

    override fun saveNewEpisodes(value: List<EpisodeEntity>): Single<Int> {
        return Single.fromCallable<Int> {
            newEpisodesDao.insertNewEpisodes(
                episodeLocalModelMapper.toModelList(value)
            )
            value.size
        }
    }
}