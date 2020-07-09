package com.ayokunlepaul.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ayokunlepaul.local.models.ChannelLocalModel
import com.ayokunlepaul.local.models.EpisodeLocalModel
import com.ayokunlepaul.local.room.daos.ChannelsDao
import com.ayokunlepaul.local.room.daos.NewEpisodesDao
import com.ayokunlepaul.local.utils.SaluranLocalConstants

@Database(
    version = SaluranLocalConstants.SALURAN_DATABASE_SCHEMA_VERSION,
    exportSchema = true,
    entities = [
        EpisodeLocalModel::class, ChannelLocalModel::class
    ]
)
abstract class SaluranDatabase : RoomDatabase() {

    abstract fun getNewEpisodesDao(): NewEpisodesDao

    abstract fun getChannelsDao(): ChannelsDao
}