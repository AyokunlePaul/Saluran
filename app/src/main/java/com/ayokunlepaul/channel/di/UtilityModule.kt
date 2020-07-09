package com.ayokunlepaul.channel.di

import com.ayokunlepaul.channel.utils.SaluranSchedulerImpl
import com.ayokunlepaul.data.utils.SaluranScheduler
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
abstract class UtilityModule {

    @Binds
    @Singleton
    internal abstract fun bindSaluranScheduler(
        impl: SaluranSchedulerImpl
    ): SaluranScheduler
}