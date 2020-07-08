package com.ayokunlepaul.remote.utils

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import timber.log.Timber

fun okhttp(block: OkHttpClient.Builder.() -> Unit): OkHttpClient {
    return OkHttpClient.Builder().apply(block).build()
}

fun retrofit(block: Retrofit.Builder.() -> Unit): Retrofit {
    return Retrofit.Builder().apply(block).build()
}

fun loggingInterceptor(block: HttpLoggingInterceptor.() -> Unit): HttpLoggingInterceptor {
    return HttpLoggingInterceptor {
        Timber.e(it)
    }.apply(block)
}