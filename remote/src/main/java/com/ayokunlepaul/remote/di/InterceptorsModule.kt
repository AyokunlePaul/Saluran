package com.ayokunlepaul.remote.di

import com.ayokunlepaul.remote.BuildConfig
import com.ayokunlepaul.remote.utils.loggingInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.logging.HttpLoggingInterceptor

@Module
class InterceptorsModule {

    @Provides
    internal fun provideLoggingInteceptor(): HttpLoggingInterceptor {
        return loggingInterceptor {
            level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
            else HttpLoggingInterceptor.Level.NONE
        }
    }
}