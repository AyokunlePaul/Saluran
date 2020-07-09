package com.ayokunlepaul.channel.presentation.viewholders

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ayokunlepaul.channel.R
import com.ayokunlepaul.channel.models.Channel

class ChannelViewHolder(
    private val rootView: View
) : RecyclerView.ViewHolder(rootView) {

    fun bind(channel: Channel) {
        with(rootView) {
            val title = rootView.findViewById<TextView>(R.id.channel_title)
            title.text = channel.title
            val mediaCount = rootView.findViewById<TextView>(R.id.media_count)
            mediaCount.text = resources.getString(R.string.media_count, channel.mediaCount)
        }
    }

    companion object {
        @JvmStatic
        fun get(parent: ViewGroup): ChannelViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val rootView = inflater.inflate(R.layout.item_channel, parent, false)
            return ChannelViewHolder(rootView = rootView)
        }
    }
}