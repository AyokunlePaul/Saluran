package com.ayokunlepaul.channel.utils

import com.ayokunlepaul.channel.models.Channel
import com.ayokunlepaul.channel.models.Episode

object SaluranTestUtils {

    fun createCategories(): List<String> {
        return listOf("Health", "Fitness", "Training")
    }

    fun createChannels(): List<Channel> {
        return listOf(
            Channel(
                title = "Title",
                slug = "Slug",
                iconAssetUrl = "icon_asset_url",
                mediaCount = 0,
                channelId = "10",
                series = emptyList(),
                latestMedia = emptyList(),
                coverAssetUrl = "cover_asset_url"
            ),
            Channel(
                title = "Title1",
                slug = "Slug1",
                iconAssetUrl = "icon_asset_url_1",
                mediaCount = 1,
                channelId = "11",
                series = emptyList(),
                latestMedia = emptyList(),
                coverAssetUrl = "cover_asset_url_1"
            ),
            Channel(
                title = "Title2",
                slug = "Slug2",
                iconAssetUrl = "icon_asset_url_2",
                mediaCount = 2,
                channelId = "12",
                series = emptyList(),
                latestMedia = emptyList(),
                coverAssetUrl = "cover_asset_url_2"
            )
        )
    }

    fun createNewEpisodes(): List<Episode> {
        return listOf(
            Episode(
                id = 0,
                coverAssetUrl = "cover_asset_url",
                title = "Title",
                channelTitle = "Channel Title",
                type = "Type"
            ),
            Episode(
                id = 1,
                coverAssetUrl = "cover_asset_url_1",
                title = "Title 1",
                channelTitle = "Channel Title 1",
                type = "Type 1"
            ),
            Episode(
                id = 2,
                coverAssetUrl = "cover_asset_url_2",
                title = "Title 2",
                channelTitle = "Channel Title 2",
                type = "Type 2"
            )
        )
    }
}