package com.ayokunlepaul.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.ayokunlepaul.local.models.CategoryLocalModel
import com.ayokunlepaul.local.models.ChannelLocalModel
import com.ayokunlepaul.local.models.EpisodeLocalModel
import com.ayokunlepaul.local.room.daos.CategoriesDao
import com.ayokunlepaul.local.room.daos.ChannelsDao
import com.ayokunlepaul.local.room.daos.NewEpisodesDao
import com.ayokunlepaul.local.room.typeconverters.ChannelEpisodeTypeConverter
import com.ayokunlepaul.local.utils.SaluranLocalConstants

@Database(
    version = SaluranLocalConstants.SALURAN_DATABASE_SCHEMA_VERSION,
    exportSchema = true,
    entities = [
        EpisodeLocalModel::class, ChannelLocalModel::class, CategoryLocalModel::class
    ]
)
@TypeConverters(ChannelEpisodeTypeConverter::class)
abstract class SaluranDatabase : RoomDatabase() {

    abstract fun getNewEpisodesDao(): NewEpisodesDao

    abstract fun getChannelsDao(): ChannelsDao

    abstract fun getCategoriesDao(): CategoriesDao
}