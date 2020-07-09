package com.ayokunlepaul.local.room.typeconverters

import androidx.room.TypeConverter
import com.ayokunlepaul.local.models.ChannelEpisodeLocalModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ChannelEpisodeTypeConverter {

    private val gson = Gson()

    @TypeConverter
    fun convertFrom(value: String): List<ChannelEpisodeLocalModel> {
        return gson.fromJson(value, object : TypeToken<List<ChannelEpisodeLocalModel>>() {}.type)
    }

    @TypeConverter
    fun convertTo(value: List<ChannelEpisodeLocalModel>): String {
        return gson.toJson(value)
    }
}