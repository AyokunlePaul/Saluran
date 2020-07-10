package com.ayokunlepaul.channel.presentation.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ayokunlepaul.channel.models.Episode
import com.ayokunlepaul.channel.presentation.viewholders.NewEpisodeViewHolder
import com.ayokunlepaul.channel.utils.diffutils.AutoUpdateRecyclerView
import kotlin.properties.Delegates

class EpisodesAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>(), AutoUpdateRecyclerView {

    private var episodes: List<Episode> by Delegates.observable(emptyList()) { _, oldEpisodes, newEpisodes ->
        autoNotify(oldEpisodes, newEpisodes) { oldEpisode, newEpisode ->
            oldEpisode.hashCode() == newEpisode.hashCode() && oldEpisode.toString() == newEpisode.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        NewEpisodeViewHolder.get(parent)

    override fun getItemCount(): Int = episodes.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is NewEpisodeViewHolder -> {
                holder.bindNewEpisode(episodes[position])
            }
        }
    }

    fun setNewEpisodes(data: List<Episode>, isFirstBatch: Boolean = false) {
        episodes = if (isFirstBatch) data
        else episodes + data
    }
}