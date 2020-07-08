package com.ayokunlepaul.channel

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class SaluranApplication : Application() {

    override fun onCreate() {
        super.onCreate()
    }
}