package com.ayokunlepaul.local.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "new_episodes")
data class NewEpisodesLocalModel (
    @PrimaryKey(autoGenerate = true) val id: Long,
    val type: String,
    val title: String,
    val coverAssetUrl: String,
    val channelTitle: String
)