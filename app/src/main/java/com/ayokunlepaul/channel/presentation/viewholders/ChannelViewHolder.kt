package com.ayokunlepaul.channel.presentation.viewholders

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ayokunlepaul.channel.R
import com.ayokunlepaul.channel.models.Channel
import com.ayokunlepaul.channel.presentation.adapters.EpisodesAdapter
import com.ayokunlepaul.channel.presentation.adapters.SeriesAdapter
import com.ayokunlepaul.channel.utils.SaluranConstants
import com.ayokunlepaul.channel.utils.itemdecoration.RecyclerInsetsDecoration
import com.bumptech.glide.Glide

class ChannelViewHolder(
    private val rootView: View
) : RecyclerView.ViewHolder(rootView) {

    fun bind(value: Channel) {
        val course = with(rootView) {
            val title = findViewById<TextView>(R.id.channel_title)
            title.text = value.title
            val mediaCount = findViewById<TextView>(R.id.media_count)
            mediaCount.text = resources.getString(R.string.media_count, value.mediaCount)
            val thumbnail = findViewById<AppCompatImageView>(R.id.thumbnail)
            val thumbnailUrl = if (value.iconAssetUrl.isEmpty()) SaluranConstants.DEFAULT_SALURAN_THUMBNAIL
            else value.iconAssetUrl
            Glide.with(this).load(thumbnailUrl).placeholder(R.drawable.ic_broken_image)
                .into(thumbnail)
            findViewById<RecyclerView>(R.id.course)
        }
        with(course) {
            if (value.isSeries) setupSeries(this, value)
            else setupCourse(this, value)
        }
    }

    private fun setupSeries(recyclerView: RecyclerView, channel: Channel) {
        val series = if (channel.latestMedia.size > 6) channel.latestMedia.take(6)
        else channel.latestMedia
        val seriesAdapter = SeriesAdapter(series)
        with(recyclerView) {
            adapter = seriesAdapter
            layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
            val rightInset = resources.getDimension(R.dimen.channels_horizontal_inset).toInt()
            addItemDecoration(RecyclerInsetsDecoration(0, 0, rightInset, 0))
        }
    }

    private fun setupCourse(recyclerView: RecyclerView, channel: Channel) {
        val courseAdapter = EpisodesAdapter().apply {
            val episodes = channel.latestMedia.map { it.toEpisode() }
            setEpisodes(if (episodes.size > 6) episodes.take(6) else episodes)
        }
        with(recyclerView) {
            adapter = courseAdapter
            layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
            val rightInset = resources.getDimension(R.dimen.channels_horizontal_inset).toInt()
            addItemDecoration(RecyclerInsetsDecoration(0, 0, rightInset, 0))
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