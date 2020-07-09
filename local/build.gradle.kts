import org.jetbrains.kotlin.konan.properties.Properties

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
        buildConfigField(
            "String",
            "SALURAN_DATABASE_NAME",
            getSaluranProperty("SALURAN_DATABASE_NAME")
        )
        buildConfigField(
            "String",
            "SALURAN_SHARED_PREFERENCE",
            getSaluranProperty("SALURAN_SHARED_PREFERENCE")
        )
        javaCompileOptions {
            annotationProcessorOptions {
                arguments.putAll(
                    mapOf(
                        "room.schemaLocation" to "$projectDir/schemas".toString(),
                        "room.incremental" to "true"
                    )
                )
            }
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

fun getSaluranProperty(property: String): String {
    val properties = Properties()
    val localPropertiesFile = project.rootProject.file("local.properties")
    if (localPropertiesFile.exists()) {
        properties.load(localPropertiesFile.inputStream())
    }
    return properties.getProperty(property)
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementLocal()
}