package com.ayokunlepaul.local.di

import com.ayokunlepaul.data.di.LocalRepositoryImpl
import com.ayokunlepaul.data.repository.CategoriesRepository
import com.ayokunlepaul.data.repository.ChannelsRepository
import com.ayokunlepaul.data.repository.NewEpisodesRepository
import com.ayokunlepaul.local.impl.CategoriesRepositoryImpl
import com.ayokunlepaul.local.impl.ChannelsRepositoryImpl
import com.ayokunlepaul.local.impl.NewEpisodesRepositoryImpl
import com.ayokunlepaul.local.pref.SaluranSharedPref
import com.ayokunlepaul.local.pref.SaluranSharedPrefImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
abstract class LocalImplModule {

    @Binds
    @Singleton
    @LocalRepositoryImpl
    internal abstract fun bindNewEpisodesRepository(
        impl: NewEpisodesRepositoryImpl
    ): NewEpisodesRepository

    @Binds
    @Singleton
    @LocalRepositoryImpl
    internal abstract fun bindChannelsRepository(
        impl: ChannelsRepositoryImpl
    ): ChannelsRepository

    @Binds
    @Singleton
    @LocalRepositoryImpl
    internal abstract fun bindCategoriesRepository(
        impl: CategoriesRepositoryImpl
    ): CategoriesRepository

    @Binds
    @Singleton
    internal abstract fun bindSaluranSharedPreference(
        impl: SaluranSharedPrefImpl
    ): SaluranSharedPref
}