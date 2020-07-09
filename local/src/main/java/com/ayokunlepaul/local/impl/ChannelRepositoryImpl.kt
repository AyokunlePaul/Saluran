package com.ayokunlepaul.local.impl

import com.ayokunlepaul.data.models.ChannelEntity
import com.ayokunlepaul.data.repository.ChannelRepository
import com.ayokunlepaul.local.mappers.ChannelLocalModelMapper
import com.ayokunlepaul.local.pref.SaluranSharedPref
import com.ayokunlepaul.local.room.daos.ChannelsDao
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

class ChannelRepositoryImpl @Inject constructor(
    private val saluranSharedPref: SaluranSharedPref,
    private val channelLocalModelMapper: ChannelLocalModelMapper,
    private val channelsDao: ChannelsDao
) : ChannelRepository {

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
        return channelsDao.insertChannels(channelLocalModelMapper.toModelList(value))
    }
}