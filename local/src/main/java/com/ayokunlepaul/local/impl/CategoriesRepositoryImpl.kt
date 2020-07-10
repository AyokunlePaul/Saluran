package com.ayokunlepaul.local.impl

import com.ayokunlepaul.data.repository.CategoriesRepository
import com.ayokunlepaul.local.models.CategoryLocalModel
import com.ayokunlepaul.local.pref.SaluranSharedPref
import com.ayokunlepaul.local.room.daos.CategoriesDao
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

internal class CategoriesRepositoryImpl @Inject constructor(
    private val saluranSharedPref: SaluranSharedPref,
    private val categoriesDao: CategoriesDao
) : CategoriesRepository {

    override var hasFetchedCategoriesBefore: Boolean
        get() = saluranSharedPref.getBoolean("")
        set(value) {
            saluranSharedPref.setBoolean("", value)
        }

    override fun getAllCategories(): Observable<List<String>> {
        return categoriesDao.getAllCategories().map {
            it.map { category -> category.categoryName }
        }
    }

    override fun saveCategories(value: List<String>): Single<Int> {
        categoriesDao.insertChannels(
            value.map {
                CategoryLocalModel(
                    id = 0,
                    categoryName = it
                )
            }
        )
        return Single.just(value.size)
    }
}