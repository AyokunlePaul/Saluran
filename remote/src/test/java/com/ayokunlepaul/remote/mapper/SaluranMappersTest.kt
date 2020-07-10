package com.ayokunlepaul.remote.mapper

import com.ayokunlepaul.data.models.ChannelEntity
import com.ayokunlepaul.data.models.ChannelEpisodeEntity
import com.ayokunlepaul.data.models.EpisodeEntity
import com.ayokunlepaul.remote.model.ChannelEpisodeRemoteModel
import com.ayokunlepaul.remote.model.ChannelRemoteModel
import com.ayokunlepaul.remote.model.EpisodeRemoteModel
import com.ayokunlepaul.remote.model.base.SingleStringWrapper
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class SaluranMappersTest {

    @Before
    fun setup() {
        MockKAnnotations.init(this, relaxUnitFun = true)
    }

    @Test
    fun `test that EpisodeRemoteModelMapper maps to the correct entity model`() {
        val episodeMapper = mockk<EpisodeRemoteModelMapper>()
        val channel = SingleStringWrapper(data = "Channel")
        val coverAsset = SingleStringWrapper(data = "https://my_url")
        val remoteModel = EpisodeRemoteModel(
            title = "Title",
            type = "Type",
            channel = channel,
            coverAsset = coverAsset
        )
        val expectedEntityModel = EpisodeEntity(
            title = "Title",
            type = "Type",
            channelTitle = "Channel",
            id = 0,
            coverAssetUrl = "https://my_url"
        )
        every { episodeMapper.toEntity(remoteModel) } returns expectedEntityModel

        val returnedEntity = episodeMapper.toEntity(remoteModel)
        verify { episodeMapper.toEntity(remoteModel) }
        assertNotNull(returnedEntity)
        assertEquals(returnedEntity, expectedEntityModel)
    }

    @Test
    fun `test that ChannelEpisodeRemoteModelMapper maps to the correct entity model`() {
        val channelEpisodeMapper = mockk<ChannelEpisodeRemoteModelMapper>()
        val coverAsset = SingleStringWrapper(data = "https://my_url")
        val remoteModel = ChannelEpisodeRemoteModel(
            title = "Title",
            type = "Type",
            coverAsset = coverAsset
        )
        val expectedEntityModel = ChannelEpisodeEntity(
            title = "Title",
            type = "Type",
            coverAssetUrl = "https://my_url"
        )
        every { channelEpisodeMapper.toEntity(remoteModel) } returns expectedEntityModel

        val returnedEntity = channelEpisodeMapper.toEntity(remoteModel)
        verify { channelEpisodeMapper.toEntity(remoteModel) }
        assertNotNull(returnedEntity)
        assertEquals(returnedEntity, expectedEntityModel)
    }

    @Test
    fun `test that ChannelRemoteModelMapper maps to the correct entity model`() {
        val channelMapper = mockk<ChannelRemoteModelMapper>()
        val coverAsset = SingleStringWrapper(data = "https://my_url")
        val remoteModel = ChannelRemoteModel(
            title = "Title",
            id = "Id",
            coverAsset = coverAsset,
            iconAsset = coverAsset,
            slug = "Slug",
            series = emptyList(),
            latestMedia = emptyList(),
            mediaCount = 10
        )
        val expectedEntityModel = ChannelEntity(
            title = "Title",
            channelId = "Id",
            mediaCount = 10,
            latestMedia = emptyList(),
            series = emptyList(),
            slug = "Slug",
            iconAssetUrl = "https://my_url",
            coverAssetUrl = "https://my_url"
        )
        every { channelMapper.toEntity(remoteModel) } returns expectedEntityModel

        val returnedEntity = channelMapper.toEntity(remoteModel)
        verify { channelMapper.toEntity(remoteModel) }
        assertNotNull(returnedEntity)
        assertEquals(returnedEntity, expectedEntityModel)
    }
}