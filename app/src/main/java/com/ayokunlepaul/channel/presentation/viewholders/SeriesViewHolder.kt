package com.ayokunlepaul.channel.presentation.viewholders

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.ayokunlepaul.channel.R
import com.ayokunlepaul.channel.models.ChannelEpisode
import com.bumptech.glide.Glide

class SeriesViewHolder(
    private val rootView: View
) : RecyclerView.ViewHolder(rootView) {

    fun bind(value: ChannelEpisode) {
        with(rootView) {
            val title = findViewById<TextView>(R.id.series_title)
            title.text = value.title
            val coverAsset = findViewById<AppCompatImageView>(R.id.series_cover_asset)
            Glide.with(this).load(value.coverAssetUrl).placeholder(R.drawable.ic_broken_image)
                .into(coverAsset)
        }
    }

    companion object {
        @JvmStatic
        fun get(parent: ViewGroup): SeriesViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val rootView = inflater.inflate(R.layout.item_series, parent, false)
            return SeriesViewHolder(rootView)
        }
    }
}