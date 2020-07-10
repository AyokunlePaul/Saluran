package com.ayokunlepaul.channel.presentation

import android.os.Bundle
import android.os.Handler
import android.widget.ViewFlipper
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.ayokunlepaul.channel.R
import com.ayokunlepaul.channel.models.Channel
import com.ayokunlepaul.channel.models.Episode
import com.ayokunlepaul.channel.models.SaluranState
import com.ayokunlepaul.channel.presentation.adapters.CategoriesAdapter
import com.ayokunlepaul.channel.presentation.adapters.ChannelsAdapter
import com.ayokunlepaul.channel.presentation.adapters.EpisodesAdapter
import com.ayokunlepaul.channel.utils.itemdecoration.RecyclerInsetsDecoration
import com.ayokunlepaul.channel.utils.layoutmanager.GridLayoutManagerWrapper
import dagger.hilt.android.AndroidEntryPoint
import jp.wasabeef.recyclerview.animators.SlideInRightAnimator
import timber.log.Timber

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<MainActivityViewModel>()
    private val newEpisodes by lazy { findViewById<RecyclerView>(R.id.new_episodes) }
    private val channels by lazy { findViewById<RecyclerView>(R.id.channels) }
    private val categories by lazy { findViewById<RecyclerView>(R.id.categories) }

    private val newEpisodesFlipper by lazy { findViewById<ViewFlipper>(R.id.new_episodes_flipper) }
    private val channelsFlipper by lazy { findViewById<ViewFlipper>(R.id.channels_flipper) }

    private val swipeToRefresh by lazy { findViewById<SwipeRefreshLayout>(R.id.swipe_to_refresh) }

    private val newEpisodesAdapter = EpisodesAdapter()
    private val channelsAdapter = ChannelsAdapter()
    private val categoriesAdapter = CategoriesAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        observeViewModel()
        setupRecyclerView()
        getAllData()
        swipeToRefresh.setOnRefreshListener {
            getAllData()
            Handler().postDelayed({
                if (swipeToRefresh.isRefreshing) swipeToRefresh.isRefreshing = false
            }, 1000)
        }
    }

    private fun getAllData() {
        viewModel.getNewEpisodes()
        viewModel.getChannels()
        viewModel.getCategories()
    }

    private fun setupRecyclerView() {
        val animatorDuration = resources.getInteger(R.integer.animator_duration)
        newEpisodes.apply {
            adapter = newEpisodesAdapter
            layoutManager = LinearLayoutManager(this@MainActivity, RecyclerView.HORIZONTAL, false)
            if (itemDecorationCount == 0) {
                val inset = resources.getDimension(R.dimen.new_episode_inset).toInt()
                addItemDecoration(RecyclerInsetsDecoration(inset, inset))
            }
            itemAnimator = SlideInRightAnimator().apply { addDuration = animatorDuration.toLong() }
        }
        channels.apply {
            adapter = channelsAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
            if (itemDecorationCount == 0) {
                val dividerItemDecoration =
                    DividerItemDecoration(this@MainActivity, RecyclerView.VERTICAL)
                val verticalInset = resources.getDimension(R.dimen.channels_vertical_inset).toInt()
                val horizontalInset = resources.getDimension(R.dimen.new_episode_inset).toInt()
                addItemDecoration(dividerItemDecoration)
                addItemDecoration(RecyclerInsetsDecoration(verticalInset, horizontalInset))
            }
            itemAnimator = SlideInRightAnimator().apply { addDuration = animatorDuration.toLong() }
        }
        categories.apply {
            adapter = categoriesAdapter
            layoutManager = GridLayoutManagerWrapper(this@MainActivity, 2)
            if (itemDecorationCount == 0) {
                val inset = resources.getDimension(R.dimen.new_episode_inset).toInt()
                addItemDecoration(RecyclerInsetsDecoration(inset, inset))
            }
            itemAnimator = SlideInRightAnimator().apply { addDuration = animatorDuration.toLong() }
        }
    }

    private fun observeViewModel() {
        with(viewModel) {
            newEpisodes.observe(this@MainActivity, Observer {
                when (it) {
                    is SaluranState.Loading -> {
                        Timber.e("Loading...")
                        if (newEpisodesFlipper.displayedChild != 0) newEpisodesFlipper.displayedChild =
                            0
                    }
                    is SaluranState.Failed -> {
                        Timber.e(Throwable(it.message))
                        if (newEpisodesFlipper.displayedChild != 1) newEpisodesFlipper.displayedChild =
                            1
                    }
                    else -> {
                        if (newEpisodesFlipper.displayedChild != 2) newEpisodesFlipper.displayedChild =
                            2
                        newEpisodesAdapter.setEpisodes((it as SaluranState.Successful<List<Episode>>).data)
                    }
                }
            })
            channels.observe(this@MainActivity, Observer {
                when (it) {
                    is SaluranState.Loading -> {
                        if (channelsFlipper.displayedChild != 0) channelsFlipper.displayedChild = 0
                        Timber.e("Loading...")
                    }
                    is SaluranState.Failed -> {
                        if (channelsFlipper.displayedChild != 1) channelsFlipper.displayedChild = 1
                        Timber.e(Throwable(it.message))
                    }
                    else -> {
                        if (channelsFlipper.displayedChild != 2) channelsFlipper.displayedChild = 2
                        channelsAdapter.setChannels((it as SaluranState.Successful<List<Channel>>).data)
                    }
                }
            })
            categories.observe(this@MainActivity, Observer {
                when (it) {
                    is SaluranState.Loading -> Timber.e("Loading...")
                    is SaluranState.Failed -> Timber.e(Throwable(it.message))
                    else -> {
                        categoriesAdapter.setCategories((it as SaluranState.Successful<List<String>>).data)
                    }
                }
            })
        }
    }
}