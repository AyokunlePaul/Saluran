package com.ayokunlepaul.data.repository

import com.ayokunlepaul.data.models.ChannelEntity
import com.ayokunlepaul.data.utils.errors.IllegalModuleAccessException
import io.reactivex.Observable
import io.reactivex.Single

interface ChannelsRepository {

    fun getAllChannels(): Observable<List<ChannelEntity>>

    fun saveChannels(value: List<ChannelEntity>): Single<Int> = throw IllegalModuleAccessException()

    var hasFetchedChannelBefore: Boolean
}