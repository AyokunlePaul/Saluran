package com.ayokunlepaul.remote.di

import com.ayokunlepaul.data.di.RemoteRepositoryImpl
import com.ayokunlepaul.data.repository.CategoriesRepository
import com.ayokunlepaul.data.repository.ChannelsRepository
import com.ayokunlepaul.data.repository.NewEpisodesRepository
import com.ayokunlepaul.remote.impl.CategoriesRepositoryImpl
import com.ayokunlepaul.remote.impl.ChannelsRepositoryImpl
import com.ayokunlepaul.remote.impl.NewEpisodesRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
abstract class RemoteImplModule {

    @Binds
    @Singleton
    @RemoteRepositoryImpl
    internal abstract fun bindNewEpisodesRepository(
        impl: NewEpisodesRepositoryImpl
    ): NewEpisodesRepository

    @Binds
    @Singleton
    @RemoteRepositoryImpl
    internal abstract fun bindChannelsRepository(
        impl: ChannelsRepositoryImpl
    ): ChannelsRepository

    @Binds
    @Singleton
    @RemoteRepositoryImpl
    internal abstract fun bindCategoriesRepository(
        impl: CategoriesRepositoryImpl
    ): CategoriesRepository
}