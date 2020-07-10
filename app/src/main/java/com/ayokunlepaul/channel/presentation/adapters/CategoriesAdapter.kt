package com.ayokunlepaul.channel.presentation.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ayokunlepaul.channel.presentation.viewholders.CategoryViewHolder
import com.ayokunlepaul.channel.utils.diffutils.AutoUpdateRecyclerView
import kotlin.properties.Delegates

class CategoriesAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>(), AutoUpdateRecyclerView {

    private var categories: List<String> by Delegates.observable(emptyList()) { _, oldCategories, newCategories ->
        autoNotify(oldCategories, newCategories) { oldCategory, newCategory ->
            oldCategory == newCategory
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return CategoryViewHolder.get(parent)
    }

    override fun getItemCount(): Int = categories.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is CategoryViewHolder) holder.bindCategory(categories[position])
    }

    fun setCategories(data: List<String>, isFirstBatch: Boolean = false) {
        categories = if (isFirstBatch) data else categories + data
    }
}