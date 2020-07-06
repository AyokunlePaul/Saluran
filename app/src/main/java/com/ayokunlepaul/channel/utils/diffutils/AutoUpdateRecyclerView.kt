package com.ayokunlepaul.channel.utils.diffutils

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

interface AutoUpdateRecyclerView {

    fun <T> RecyclerView.Adapter<*>.autoNotify(oldList: List<T>, newList: List<T>, compare: (T, T) -> Boolean) {
        val diffCallback = object : DiffUtil.Callback() {
            override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean = compare(oldList[oldItemPosition], newList[newItemPosition])

            override fun getOldListSize(): Int = oldList.size

            override fun getNewListSize(): Int = newList.size

            override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean = oldList[oldItemPosition] == newList[newItemPosition]
        }
        val diff = DiffUtil.calculateDiff(diffCallback)
        diff.dispatchUpdatesTo(this)
    }
}