package com.ayokunlepaul.remote.impl

import com.ayokunlepaul.data.models.NewEpisodeEntity
import com.ayokunlepaul.data.repository.NewEpisodesRepository
import com.ayokunlepaul.data.utils.errors.IllegalModuleAccessException
import com.ayokunlepaul.remote.mapper.NewEpisodeRemoteModelMapper
import com.ayokunlepaul.remote.services.SaluranService
import com.ayokunlepaul.remote.utils.executeOnError
import io.reactivex.Observable
import javax.inject.Inject

class NewEpisodesRepositoryImpl @Inject constructor(
    private val service: SaluranService,
    private val mapper: NewEpisodeRemoteModelMapper
) : NewEpisodesRepository {

    override fun getNewEpisodes(): Observable<List<NewEpisodeEntity>> {
        return service.getNewEpisodes().executeOnError().flatMapObservable {
            Observable.just(
                mapper.toEntityList(it)
            )
        }
    }

    override var hasSavedNewEpisodesBefore: Boolean
        get() = throw IllegalModuleAccessException()
        set(value) {}
}