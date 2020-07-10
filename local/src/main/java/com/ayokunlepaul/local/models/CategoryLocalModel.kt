package com.ayokunlepaul.local.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "categories")
data class CategoryLocalModel(
    @PrimaryKey(autoGenerate = true) val id: Long,
    val categoryName: String
)