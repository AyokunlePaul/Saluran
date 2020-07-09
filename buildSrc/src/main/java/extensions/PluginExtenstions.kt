package extensions

import org.gradle.kotlin.dsl.kotlin
import org.gradle.plugin.use.PluginDependenciesSpec

fun PluginDependenciesSpec.hilt() {
    id("dagger.hilt.android.plugin")
}

fun PluginDependenciesSpec.kotlinAndroid() {
    kotlin("kapt")
    kotlin("android")
    kotlin("android.extensions")
}