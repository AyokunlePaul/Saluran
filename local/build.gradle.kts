import extensions.hilt
import extensions.kotlinAndroid

plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}
android {
    defaultConfig {
        minSdkVersion(Config.Versions.minSdkVersion)
        compileSdkVersion(Config.Versions.compileSdkVersion)
        targetSdkVersion(Config.Versions.targetSdkVersion)
        versionCode = Config.Versions.versionCode
        versionName = Config.Versions.versionName
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementLocal()
}