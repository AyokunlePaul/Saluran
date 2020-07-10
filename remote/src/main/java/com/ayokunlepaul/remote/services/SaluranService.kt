package com.ayokunlepaul.remote.services

import com.ayokunlepaul.remote.model.CategoryRemoteModel
import com.ayokunlepaul.remote.model.ChannelsWrapperRemoteModel
import com.ayokunlepaul.remote.model.MediaRemoteModel
import com.ayokunlepaul.remote.model.base.BaseRemoteModel
import io.reactivex.Single
import retrofit2.http.GET

interface SaluranService {

    @GET("raw/z5AExTtw")
    fun getNewEpisodes(): Single<BaseRemoteModel<MediaRemoteModel>>

    @GET("raw/Xt12uVhM")
    fun getAllChannels(): Single<BaseRemoteModel<ChannelsWrapperRemoteModel>>

    @GET("raw/A0CgArX3")
    fun getAllCategories(): Single<BaseRemoteModel<CategoryRemoteModel>>
}