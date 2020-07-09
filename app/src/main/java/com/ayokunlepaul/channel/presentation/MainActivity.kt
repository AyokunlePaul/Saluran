package com.ayokunlepaul.channel.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ayokunlepaul.channel.R
import com.ayokunlepaul.channel.models.Episode
import com.ayokunlepaul.channel.models.SaluranState
import com.ayokunlepaul.channel.presentation.adapters.NewEpisodesAdapter
import com.ayokunlepaul.channel.utils.itemdecoration.RecyclerInsetsDecoration
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<MainActivityViewModel>()
    private val newEpisodes by lazy { findViewById<RecyclerView>(R.id.new_episodes) }
    private val newEpisodesAdapter = NewEpisodesAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        observeViewModel()
        setupRecyclerView()
        viewModel.getNewEpisodes()
    }

    private fun setupRecyclerView() {
        newEpisodes.apply {
            adapter = newEpisodesAdapter
            layoutManager = LinearLayoutManager(this@MainActivity, RecyclerView.HORIZONTAL, false)
            if (itemDecorationCount == 0) addItemDecoration(RecyclerInsetsDecoration(10, 10))
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
        }
    }

    companion object {
        private const val TAG = "MainActivity"
    }
}