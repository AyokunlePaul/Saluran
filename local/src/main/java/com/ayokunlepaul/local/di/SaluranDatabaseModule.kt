package com.ayokunlepaul.local.di

import android.content.Context
import com.ayokunlepaul.local.room.SaluranDatabase
import com.ayokunlepaul.local.utils.database
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class SaluranDatabaseModule(
    @ApplicationContext private val context: Context
) {

    @Provides
    @Singleton
    internal fun provideSaluranDatabase(): SaluranDatabase {
        return database(context) {
            allowMainThreadQueries() // TODO: 08/07/2020 This line should be removed!
            fallbackToDestructiveMigration()
        }
    }

    @Provides
    @Singleton
    internal fun provideNewEpisodesDao(database: SaluranDatabase) = database.getNewEpisodesDao()

    @Provides
    @Singleton
    internal fun provideChannelsDao(database: SaluranDatabase) = database.getChannelsDao()
}