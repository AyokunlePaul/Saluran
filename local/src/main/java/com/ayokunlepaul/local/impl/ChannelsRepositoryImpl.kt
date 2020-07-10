package com.ayokunlepaul.local.impl

import com.ayokunlepaul.data.models.ChannelEntity
import com.ayokunlepaul.data.repository.ChannelsRepository
import com.ayokunlepaul.local.mappers.ChannelLocalModelMapper
import com.ayokunlepaul.local.pref.SaluranSharedPref
import com.ayokunlepaul.local.room.daos.ChannelsDao
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

class ChannelsRepositoryImpl @Inject constructor(
    private val saluranSharedPref: SaluranSharedPref,
    private val channelLocalModelMapper: ChannelLocalModelMapper,
    private val channelsDao: ChannelsDao
) : ChannelsRepository {

    override var hasFetchedChannelBefore: Boolean
        get() = saluranSharedPref.getBoolean("")
        set(value) {
            saluranSharedPref.setBoolean("", value)
        }

    override fun getAllChannels(): Observable<List<ChannelEntity>> {
        return channelsDao.getAllChannels().map {
            channelLocalModelMapper.toEntityList(it)
        }
    }

    override fun saveChannels(value: List<ChannelEntity>): Single<Int> {
        return Single.fromCallable {
            channelsDao.insertChannels(
                channelLocalModelMapper.toModelList(value)
            )
            value.size
        }
    }
}