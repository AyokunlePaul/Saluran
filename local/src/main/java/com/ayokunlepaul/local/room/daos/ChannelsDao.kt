package com.ayokunlepaul.local.room.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ayokunlepaul.local.models.ChannelLocalModel
import io.reactivex.Observable
import io.reactivex.Single

@Dao
interface ChannelsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertChannel(value: ChannelLocalModel)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertChannels(value: List<ChannelLocalModel>): Single<Int>

    @Query("SELECT * FROM channels")
    fun getAllChannels(): Observable<List<ChannelLocalModel>>
}