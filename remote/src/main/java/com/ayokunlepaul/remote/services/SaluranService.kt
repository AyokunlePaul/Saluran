package com.ayokunlepaul.remote.services

import com.ayokunlepaul.domain.models.NewEpisodeEntity
import io.reactivex.Single
import retrofit2.http.GET

interface SaluranService {

    @GET("z5AExTtw")
    fun getNewEpisodes(): Single<List<NewEpisodeEntity>>
}