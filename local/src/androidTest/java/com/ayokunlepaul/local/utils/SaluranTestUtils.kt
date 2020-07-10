package com.ayokunlepaul.local.utils

import com.ayokunlepaul.local.models.CategoryLocalModel
import com.ayokunlepaul.local.models.ChannelLocalModel
import com.ayokunlepaul.local.models.EpisodeLocalModel

object SaluranTestUtils {

    fun createCategories(): List<CategoryLocalModel> {
        return listOf("Health", "Fitness", "Training").map {
            CategoryLocalModel(
                id = 0,
                categoryName = it
            )
        }
    }

    fun createChannels(): List<ChannelLocalModel> {
        return listOf(
            ChannelLocalModel(
                id = 0,
                title = "Title",
                slug = "Slug",
                iconAssetUrl = "icon_asset_url",
                mediaCount = 0,
                channelId = "10",
                series = emptyList(),
                latestMedia = emptyList(),
                coverAssetUrl = "cover_asset_url"
            ),
            ChannelLocalModel(
                id = 0,
                title = "Title1",
                slug = "Slug1",
                iconAssetUrl = "icon_asset_url_1",
                mediaCount = 1,
                channelId = "11",
                series = emptyList(),
                latestMedia = emptyList(),
                coverAssetUrl = "cover_asset_url_1"
            ),
            ChannelLocalModel(
                id = 0,
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

    fun createNewEpisodes(): List<EpisodeLocalModel> {
        return listOf(
            EpisodeLocalModel(
                id = 0,
                coverAssetUrl = "cover_asset_url",
                title = "Title",
                channelTitle = "Channel Title",
                type = "Type"
            ),
            EpisodeLocalModel(
                id = 1,
                coverAssetUrl = "cover_asset_url_1",
                title = "Title 1",
                channelTitle = "Channel Title 1",
                type = "Type 1"
            ),
            EpisodeLocalModel(
                id = 2,
                coverAssetUrl = "cover_asset_url_2",
                title = "Title 2",
                channelTitle = "Channel Title 2",
                type = "Type 2"
            )
        )
    }
}