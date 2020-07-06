package com.ayokunlepaul.channel.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ayokunlepaul.channel.data.NewEpisode
import com.ayokunlepaul.channel.utils.diffutils.AutoUpdateRecyclerView
import com.ayokunlepaul.channel.viewholders.NewEpisodeShimmerViewHolder
import com.ayokunlepaul.channel.viewholders.NewEpisodeViewHolder
import kotlin.properties.Delegates

class NewEpisodesAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>(), AutoUpdateRecyclerView {

    private var episodes: List<NewEpisode> by Delegates.observable(emptyList()) { _, oldEpisodes, newEpisodes ->
        autoNotify(oldEpisodes, newEpisodes) { oldEpisode, newEpisode ->
            oldEpisode.hashCode() == newEpisode.hashCode() && oldEpisode.toString() == newEpisode.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder = if (viewType == VIEW_TYPE_SHIMMER) {
        NewEpisodeShimmerViewHolder.get(parent)
    } else NewEpisodeViewHolder.get(parent)

    override fun getItemViewType(position: Int): Int = if (episodes.isEmpty()) VIEW_TYPE_SHIMMER
    else VIEW_TYPE_EPISODE

    override fun getItemCount(): Int = if (episodes.isEmpty()) 5 else episodes.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

    }

    companion object {
        private const val VIEW_TYPE_SHIMMER = 0
        private const val VIEW_TYPE_EPISODE = 1
    }
}