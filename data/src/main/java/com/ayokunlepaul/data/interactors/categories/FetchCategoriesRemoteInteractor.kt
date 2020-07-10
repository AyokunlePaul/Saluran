package com.ayokunlepaul.data.interactors.categories

import com.ayokunlepaul.data.di.RemoteRepositoryImpl
import com.ayokunlepaul.data.interactors.ObservableInteractor
import com.ayokunlepaul.data.repository.CategoriesRepository
import com.ayokunlepaul.data.utils.SaluranScheduler
import io.reactivex.Observable
import javax.inject.Inject

class FetchCategoriesRemoteInteractor @Inject constructor(
    scheduler: SaluranScheduler,
    @RemoteRepositoryImpl private val categoriesRepository: CategoriesRepository
) : ObservableInteractor<Nothing, List<String>>(scheduler) {

    override fun buildUseCaseObservable(parameter: Nothing?): Observable<List<String>> {
        return categoriesRepository.getAllCategories()
    }
}