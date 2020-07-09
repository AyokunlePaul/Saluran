package com.ayokunlepaul.data.interactors

import com.ayokunlepaul.data.utils.SaluranScheduler
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver

abstract class ObservableInteractor<in Parameter, Response>(
    private val scheduler: SaluranScheduler
) {

    private val compositeDisposable = CompositeDisposable()

    abstract fun buildUseCaseObservable(parameter: Parameter? = null): Observable<Response>

    fun executeUseCaseObservable(
        parameter: Parameter?,
        observer: DisposableObserver<Response>
    ) {
        val disposable = buildUseCaseObservable(parameter).observeOn(scheduler.observationThread)
            .subscribeWith(observer)
        compositeDisposable.add(disposable)
    }

    fun executeObservableUseCaseAndPerformAction(
        parameter: Parameter?,
        onSuccess: (Response) -> Unit,
        onFailure: (String?) -> Unit
    ) {
        val disposable = buildUseCaseObservable(parameter).observeOn(scheduler.observationThread)
            .subscribe({
                onSuccess.invoke(it)
            }) {
                onFailure.invoke(it.localizedMessage)
            }
        compositeDisposable.add(disposable)
    }

    fun dispose() = compositeDisposable.dispose()
}