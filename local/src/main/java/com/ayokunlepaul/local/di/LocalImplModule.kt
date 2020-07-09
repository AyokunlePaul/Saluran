package com.ayokunlepaul.local.di

import com.ayokunlepaul.data.di.LocalRepositoryImpl
import com.ayokunlepaul.data.repository.ChannelRepository
import com.ayokunlepaul.data.repository.NewEpisodeRepository
import com.ayokunlepaul.local.impl.ChannelRepositoryImpl
import com.ayokunlepaul.local.impl.NewEpisodeRepositoryImpl
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
        impl: NewEpisodeRepositoryImpl
    ): NewEpisodeRepository

    @Binds
    @Singleton
    @LocalRepositoryImpl
    internal abstract fun bindChannelsRepository(
        impl: ChannelRepositoryImpl
    ): ChannelRepository

    @Binds
    @Singleton
    internal abstract fun bindSaluranSharedPreference(
        impl: SaluranSharedPrefImpl
    ): SaluranSharedPref
}