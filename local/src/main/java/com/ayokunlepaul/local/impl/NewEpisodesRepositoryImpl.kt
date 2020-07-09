package com.ayokunlepaul.local.impl

import com.ayokunlepaul.data.models.NewEpisodeEntity
import com.ayokunlepaul.data.repository.NewEpisodesRepository
import com.ayokunlepaul.local.mappers.NewEpisodeLocalModelMapper
import com.ayokunlepaul.local.pref.SaluranSharedPref
import com.ayokunlepaul.local.room.daos.NewEpisodesDao
import com.ayokunlepaul.local.utils.SaluranLocalConstants
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

class NewEpisodesRepositoryImpl @Inject constructor(
    private val sharedPref: SaluranSharedPref,
    private val newEpisodesDao: NewEpisodesDao,
    private val newEpisodeLocalModelMapper: NewEpisodeLocalModelMapper
) : NewEpisodesRepository {

    override var hasSavedNewEpisodesBefore: Boolean
        get() = sharedPref.getBoolean(SaluranLocalConstants.HAS_FETCHED_NEW_EPISODES_BEFORE)
        set(value) {
            sharedPref.setBoolean(SaluranLocalConstants.HAS_FETCHED_NEW_EPISODES_BEFORE, value)
        }

    override fun getNewEpisodes(): Observable<List<NewEpisodeEntity>> {
        return newEpisodesDao.getAllNewEpisodes().map {
            newEpisodeLocalModelMapper.toEntityList(it)
        }
    }

    override fun saveNewEpisodes(value: List<NewEpisodeEntity>): Single<Int> {
        return newEpisodesDao.insertNewEpisodes(newEpisodeLocalModelMapper.toModelList(value))
    }
}