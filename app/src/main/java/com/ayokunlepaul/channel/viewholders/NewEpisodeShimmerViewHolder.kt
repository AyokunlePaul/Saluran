package com.ayokunlepaul.channel.viewholders

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ayokunlepaul.channel.R

class NewEpisodeShimmerViewHolder(
    private val rootView: View
) : RecyclerView.ViewHolder(rootView) {

    companion object {
        @JvmStatic
        fun get(parent: ViewGroup): NewEpisodeShimmerViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val rootView = inflater.inflate(R.layout.shimmer_item_new_episode, parent, false)
            return NewEpisodeShimmerViewHolder(rootView)
        }
    }
}