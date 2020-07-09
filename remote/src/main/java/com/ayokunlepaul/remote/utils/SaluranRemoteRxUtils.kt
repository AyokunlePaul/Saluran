package com.ayokunlepaul.remote.utils

import io.reactivex.Single

fun <T> Single<T>.executeOnError(): Single<T> {
    return onErrorResumeNext { throwable: Throwable ->
        Single.error<T>(
            Throwable(SaluranRemoteErrorExtractor.extractErrorMessage(throwable))
        )
    }
}