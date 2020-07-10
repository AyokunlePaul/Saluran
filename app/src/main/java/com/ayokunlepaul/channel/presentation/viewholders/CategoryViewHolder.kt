package com.ayokunlepaul.channel.presentation.viewholders

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ayokunlepaul.channel.R

class CategoryViewHolder(
    private val rootView: View
) : RecyclerView.ViewHolder(rootView) {

    fun bindCategory(value: String) {
        with(rootView) {
            val categoryName = findViewById<TextView>(R.id.category_name)
            categoryName.text = value
        }
    }

    companion object {
        @JvmStatic
        fun get(parent: ViewGroup): CategoryViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val rootView = inflater.inflate(R.layout.item_category, parent, false)
            return CategoryViewHolder(rootView)
        }
    }
}