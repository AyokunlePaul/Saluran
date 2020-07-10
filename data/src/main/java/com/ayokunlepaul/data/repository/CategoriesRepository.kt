package com.ayokunlepaul.data.repository

import com.ayokunlepaul.data.utils.errors.IllegalModuleAccessException
import io.reactivex.Observable
import io.reactivex.Single

interface CategoriesRepository {

    fun getAllCategories(): Observable<List<String>>

    fun saveCategories(value: List<String>): Single<Int> = throw IllegalModuleAccessException()

    var hasFetchedCategoriesBefore: Boolean
}