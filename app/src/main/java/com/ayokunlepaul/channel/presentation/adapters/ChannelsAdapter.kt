package com.ayokunlepaul.channel.presentation.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ayokunlepaul.channel.models.Channel
import com.ayokunlepaul.channel.presentation.viewholders.ChannelViewHolder
import com.ayokunlepaul.channel.utils.diffutils.AutoUpdateRecyclerView
import kotlin.properties.Delegates

class ChannelsAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>(), AutoUpdateRecyclerView {

    private var channels: List<Channel> by Delegates.observable(emptyList()) { _, oldChannels, newChannels ->
        autoNotify(oldChannels, newChannels) { oldChannel, newChannel ->
            oldChannel.hashCode() == newChannel.hashCode() && oldChannel.title == newChannel.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ChannelViewHolder.get(parent)
    }

    override fun getItemCount(): Int = channels.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ChannelViewHolder) {
            holder.bind(channels[position])
        }
    }

    fun setChannels(data: List<Channel>, isFirstBatch: Boolean = true) {
        channels = if (isFirstBatch) data else channels + data
    }
}