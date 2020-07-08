package com.ayokunlepaul.remote.di

import com.ayokunlepaul.remote.BuildConfig
import com.ayokunlepaul.remote.utils.loggingInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
class InterceptorsModule {

    @Provides
    @Singleton
    internal fun provideLoggingInteceptor(): HttpLoggingInterceptor {
        return loggingInterceptor {
            level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
            else HttpLoggingInterceptor.Level.NONE
        }
    }
}