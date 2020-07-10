package com.ayokunlepaul.remote.impl

import com.ayokunlepaul.data.di.LocalRepositoryImpl
import com.ayokunlepaul.data.repository.CategoriesRepository
import com.ayokunlepaul.data.utils.errors.IllegalModuleAccessException
import com.ayokunlepaul.remote.services.SaluranService
import io.reactivex.Observable
import javax.inject.Inject

internal class CategoriesRepositoryImpl @Inject constructor(
    private val service: SaluranService,
    @LocalRepositoryImpl private val repository: CategoriesRepository
) : CategoriesRepository {

    override fun getAllCategories(): Observable<List<String>> {
        return service.getAllCategories().flatMap {
            val categoriesString = it.data.categories.map { it.data }
            repository.saveCategories(categoriesString)
        }.flatMapObservable {
            repository.hasFetchedCategoriesBefore = true
            repository.getAllCategories()
        }
    }

    override var hasFetchedCategoriesBefore: Boolean
        get() = throw IllegalModuleAccessException()
        set(@Suppress("UNUSED_PARAMETER") value) {}

}