package com.ayokunlepaul.remote.services

import com.ayokunlepaul.remote.model.NewEpisodeRemoteModel
import io.reactivex.Single
import retrofit2.http.GET

interface SaluranService {

    @GET("z5AExTtw")
    fun getNewEpisodes(): Single<List<NewEpisodeRemoteModel>>
}