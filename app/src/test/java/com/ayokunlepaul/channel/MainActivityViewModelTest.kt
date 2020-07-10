package com.ayokunlepaul.channel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.ayokunlepaul.channel.mappers.ChannelMapper
import com.ayokunlepaul.channel.mappers.EpisodeMapper
import com.ayokunlepaul.channel.models.Channel
import com.ayokunlepaul.channel.models.Episode
import com.ayokunlepaul.channel.models.SaluranState
import com.ayokunlepaul.channel.presentation.MainActivityViewModel
import com.ayokunlepaul.channel.utils.SaluranTestUtils
import com.ayokunlepaul.data.interactors.categories.FetchCategoriesInteractor
import com.ayokunlepaul.data.interactors.channels.FetchChannelsInteractor
import com.ayokunlepaul.data.interactors.newepisodes.FetchNewEpisodesInteractor
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class MainActivityViewModelTest {

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()
    private lateinit var viewModel: MainActivityViewModel

    @MockK
    private lateinit var fetchNewEpisodesInteractor: FetchNewEpisodesInteractor

    @MockK
    private lateinit var episodeMapper: EpisodeMapper

    @MockK
    private lateinit var fetchChannelsInteractor: FetchChannelsInteractor

    @MockK
    private lateinit var channelMapper: ChannelMapper

    @MockK
    private lateinit var fetchCategoriesInteractor: FetchCategoriesInteractor

    @Before
    fun setup() {
        MockKAnnotations.init(this, relaxUnitFun = true)
        viewModel = MainActivityViewModel(
            fetchNewEpisodesInteractor,
            episodeMapper,
            fetchChannelsInteractor,
            channelMapper,
            fetchCategoriesInteractor
        )
    }

    @Test
    fun `test categories live data`() {
        val data = SaluranTestUtils.createCategories()
        every {
            fetchCategoriesInteractor.executeObservableUseCaseAndPerformAction(null, any(), any())
        } answers { secondArg<(List<String>) -> Unit>().invoke(data) }

        viewModel.categories.observeForever { }
        viewModel.getCategories()

        fetchCategoriesInteractor.executeObservableUseCaseAndPerformAction(null, {
            assert(it.size == data.size)
        }, {})

        assert(viewModel.categories.value != null)
        assert(viewModel.categories.value is SaluranState.Successful<*>)
    }

    @Test
    fun `test channels live data`() {
        val data = SaluranTestUtils.createChannels()
        every {
            fetchCategoriesInteractor.executeObservableUseCaseAndPerformAction(null, any(), any())
        } answers { secondArg<(List<Channel>) -> Unit>().invoke(data) }

        viewModel.categories.observeForever { }
        viewModel.getCategories()

        fetchCategoriesInteractor.executeObservableUseCaseAndPerformAction(null, {
            assert(it.size == data.size)
        }, {})

        assert(viewModel.categories.value != null)
        assert(viewModel.categories.value is SaluranState.Successful<*>)
    }

    @Test
    fun `test new episodes live data`() {
        val data = SaluranTestUtils.createNewEpisodes()
        every {
            fetchCategoriesInteractor.executeObservableUseCaseAndPerformAction(null, any(), any())
        } answers { secondArg<(List<Episode>) -> Unit>().invoke(data) }

        viewModel.categories.observeForever { }
        viewModel.getCategories()

        fetchCategoriesInteractor.executeObservableUseCaseAndPerformAction(null, {
            assert(it.size == data.size)
        }, {})

        assert(viewModel.categories.value != null)
        assert(viewModel.categories.value is SaluranState.Successful<*>)
    }
}