package com.ayokunlepaul.local.impl

import com.ayokunlepaul.data.models.NewEpisodeEntity
import com.ayokunlepaul.data.repository.NewEpisodesRepository
import com.ayokunlepaul.local.mappers.NewEpisodeLocalModelMapper
import com.ayokunlepaul.local.pref.SaluranSharedPref
import com.ayokunlepaul.local.room.daos.NewEpisodesDao
import io.reactivex.Observable
import javax.inject.Inject

class NewEpisodesRepositoryImpl @Inject constructor(
    private val sharedPref: SaluranSharedPref,
    private val newEpisodesDao: NewEpisodesDao,
    private val newEpisodeLocalModelMapper: NewEpisodeLocalModelMapper
) : NewEpisodesRepository {

    override var hasSavedNewEpisodesBefore: Boolean
        get() = sharedPref.getBoolean("")
        set(value) {
            sharedPref.setBoolean("", value)
        }

    override fun getNewEpisodes(): Observable<List<NewEpisodeEntity>> {
        return newEpisodesDao.getAllNewEpisodes().map {
            newEpisodeLocalModelMapper.toEntityList(it)
        }
    }
}