package com.ayokunlepaul.remote.di

import com.ayokunlepaul.remote.BuildConfig
import com.ayokunlepaul.remote.utils.retrofit
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class RetrofitModule {

    @Provides
    @Singleton
    fun provideRetrofit(
        client: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory,
        rxJavaCallAdapterFactory: RxJava2CallAdapterFactory
    ): Retrofit {
        return retrofit {
            client(client)
            addCallAdapterFactory(rxJavaCallAdapterFactory)
            addConverterFactory(gsonConverterFactory)
            baseUrl(BuildConfig.BASE_URL)
        }
    }
}