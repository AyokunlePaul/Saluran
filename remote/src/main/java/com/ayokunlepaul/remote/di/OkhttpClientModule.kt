package com.ayokunlepaul.remote.di

import android.content.Context
import com.ayokunlepaul.remote.utils.SaluranConstants
import com.ayokunlepaul.remote.utils.okhttp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.io.File
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class OkhttpClientModule {

    @Provides
    @Singleton
    fun provideFile(context: Context): File {
        return File(context.cacheDir, SaluranConstants.OKHTTP_CACHE)
    }

    @Provides
    @Singleton
    fun provideCache(file: File): Cache {
        return Cache(file, 10 * 1000 * 1000)
    }

    @Provides
    @Singleton
    fun provideOkhttpClient(
        cache: Cache,
        httpInterceptor: HttpLoggingInterceptor
    ): OkHttpClient {
        return okhttp {
            addInterceptor(httpInterceptor)
            followSslRedirects(true)
            followRedirects(true)
            cache(cache)
            connectTimeout(30, TimeUnit.SECONDS)
            readTimeout(30, TimeUnit.SECONDS)
            writeTimeout(30, TimeUnit.SECONDS)
        }
    }
}