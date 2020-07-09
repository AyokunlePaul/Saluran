package com.ayokunlepaul.channel.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ayokunlepaul.channel.R
import com.ayokunlepaul.channel.models.Channel
import com.ayokunlepaul.channel.models.Episode
import com.ayokunlepaul.channel.models.SaluranState
import com.ayokunlepaul.channel.presentation.adapters.ChannelsAdapter
import com.ayokunlepaul.channel.presentation.adapters.NewEpisodesAdapter
import com.ayokunlepaul.channel.utils.itemdecoration.RecyclerInsetsDecoration
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<MainActivityViewModel>()
    private val newEpisodes by lazy { findViewById<RecyclerView>(R.id.new_episodes) }
    private val channels by lazy { findViewById<RecyclerView>(R.id.channels) }
    private val newEpisodesAdapter = NewEpisodesAdapter()
    private val channelsAdapter = ChannelsAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        observeViewModel()
        setupRecyclerView()
        viewModel.getNewEpisodes()
        viewModel.getChannels()
    }

    private fun setupRecyclerView() {
        newEpisodes.apply {
            adapter = newEpisodesAdapter
            layoutManager = LinearLayoutManager(this@MainActivity, RecyclerView.HORIZONTAL, false)
            if (itemDecorationCount == 0) {
                val inset = resources.getDimension(R.dimen.new_episode_inset).toInt()
                addItemDecoration(RecyclerInsetsDecoration(inset, inset))
            }
        }
        channels.apply {
            adapter = channelsAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
            if (itemDecorationCount == 0) {
                val dividerItemDecoration =
                    DividerItemDecoration(this@MainActivity, RecyclerView.VERTICAL)
                val verticalInset = resources.getDimension(R.dimen.channels_inset).toInt()
                val horizontalInset = resources.getDimension(R.dimen.new_episode_inset).toInt()
                addItemDecoration(dividerItemDecoration)
                addItemDecoration(RecyclerInsetsDecoration(verticalInset, horizontalInset))
            }
        }
    }

    private fun observeViewModel() {
        with(viewModel) {
            newEpisodes.observe(this@MainActivity, Observer {
                when (it) {
                    is SaluranState.Loading -> Timber.e("Loading...")
                    is SaluranState.Failed -> Timber.e(Throwable(it.message))
                    else -> {
                        newEpisodesAdapter.setNewEpisodes((it as SaluranState.Successful<List<Episode>>).data)
                    }
                }
            })
            channels.observe(this@MainActivity, Observer {
                when (it) {
                    is SaluranState.Loading -> Timber.e("Loading...")
                    is SaluranState.Failed -> Timber.e(Throwable(it.message))
                    else -> {
                        channelsAdapter.setChannels((it as SaluranState.Successful<List<Channel>>).data)
                    }
                }
            })
        }
    }
}