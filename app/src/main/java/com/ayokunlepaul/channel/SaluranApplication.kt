package com.ayokunlepaul.channel

import androidx.multidex.MultiDexApplication
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class SaluranApplication : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
    }
}