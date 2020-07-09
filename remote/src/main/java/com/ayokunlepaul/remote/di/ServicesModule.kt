package com.ayokunlepaul.remote.di

import com.ayokunlepaul.remote.services.SaluranService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class ServicesModule {

    @Provides
    @Singleton
    internal fun provideSaluranService(
        retrofit: Retrofit
    ) = retrofit.create(SaluranService::class.java)
}