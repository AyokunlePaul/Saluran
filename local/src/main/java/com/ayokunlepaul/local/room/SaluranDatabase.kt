package com.ayokunlepaul.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ayokunlepaul.local.models.NewEpisodesLocalModel
import com.ayokunlepaul.local.room.daos.NewEpisodesDao
import com.ayokunlepaul.local.utils.SaluranLocalConstants

@Database(
    version = SaluranLocalConstants.SALURAN_DATABASE_SCHEMA_VERSION,
    exportSchema = true,
    entities = [
        NewEpisodesLocalModel::class
    ]
)
abstract class SaluranDatabase : RoomDatabase() {

    abstract fun getNewEpisodesDao(): NewEpisodesDao
}