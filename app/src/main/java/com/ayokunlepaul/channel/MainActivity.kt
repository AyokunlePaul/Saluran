package com.ayokunlepaul.channel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ayokunlepaul.channel.adapters.NewEpisodesAdapter
import com.ayokunlepaul.channel.utils.itemdecoration.RecyclerInsetsDecoration

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<MainActivityViewModel>()
    private val newEpisodes by lazy { findViewById<RecyclerView>(R.id.new_episodes) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        newEpisodes.apply {
            adapter = NewEpisodesAdapter()
            layoutManager = LinearLayoutManager(this@MainActivity, RecyclerView.HORIZONTAL, false)
            if (itemDecorationCount == 0) addItemDecoration(RecyclerInsetsDecoration(10, 10))
        }
    }
}