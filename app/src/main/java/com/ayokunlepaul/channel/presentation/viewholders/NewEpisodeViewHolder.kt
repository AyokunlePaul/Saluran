package com.ayokunlepaul.channel.presentation.viewholders

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ayokunlepaul.channel.R
import com.ayokunlepaul.channel.models.Episode

class NewEpisodeViewHolder(
    private val rootView: View
) : RecyclerView.ViewHolder(rootView) {

    fun bind(value: Episode) {
        with(rootView) {
            val title = findViewById<TextView>(R.id.new_episodes_title)
            title.text = value.title
            val channelTitle = findViewById<TextView>(R.id.channel_title)
            channelTitle.text = value.channelTitle
        }
    }

    companion object {
        @JvmStatic
        fun get(parent: ViewGroup): NewEpisodeViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val rootView = inflater.inflate(R.layout.item_new_episode, parent, false)
            return NewEpisodeViewHolder(rootView)
        }
    }
}