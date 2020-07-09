package com.ayokunlepaul.local.di

import com.ayokunlepaul.data.di.LocalRepositoryImpl
import com.ayokunlepaul.data.repository.NewEpisodesRepository
import com.ayokunlepaul.local.impl.NewEpisodesRepositoryImpl
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
}