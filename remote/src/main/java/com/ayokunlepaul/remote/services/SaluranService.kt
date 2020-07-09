package com.ayokunlepaul.remote.services

import com.ayokunlepaul.remote.model.ChannelRemoteModel
import com.ayokunlepaul.remote.model.EpisodeRemoteModel
import io.reactivex.Single
import retrofit2.http.GET

interface SaluranService {

    @GET("raw/z5AExTtw")
    fun getNewEpisodes(): Single<List<EpisodeRemoteModel>>

    @GET("raw/Xt12uVhM")
    fun getAllChannels(): Single<List<ChannelRemoteModel>>
}