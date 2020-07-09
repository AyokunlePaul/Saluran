package com.ayokunlepaul.remote.di

import com.ayokunlepaul.data.di.RemoteRepositoryImpl
import com.ayokunlepaul.data.repository.NewEpisodesRepository
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
}