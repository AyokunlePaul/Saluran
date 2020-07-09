package com.ayokunlepaul.channel.presentation.viewholders

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ayokunlepaul.channel.R

class CourseViewHolder(
    private val rootView: View
) : RecyclerView.ViewHolder(rootView) {

    fun bind() {

    }

    companion object {
        @JvmStatic
        fun get(
            parent: ViewGroup
        ): CourseViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val rootView = inflater.inflate(R.layout.item_course, parent, false)
            return CourseViewHolder(rootView)
        }
    }
}