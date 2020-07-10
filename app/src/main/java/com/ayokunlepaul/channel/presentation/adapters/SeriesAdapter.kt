package com.ayokunlepaul.channel.presentation.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ayokunlepaul.channel.models.ChannelEpisode
import com.ayokunlepaul.channel.presentation.viewholders.SeriesViewHolder

class SeriesAdapter(
    private val episodes: List<ChannelEpisode>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return SeriesViewHolder.get(parent)
    }

    /**
     * Constant value 6 is part of the requirements
     */
    override fun getItemCount(): Int = 6

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is SeriesViewHolder) holder.bind(episodes[position])
    }
}