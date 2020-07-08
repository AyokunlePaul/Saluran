import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.kotlin
import org.gradle.kotlin.dsl.project

const val KotlinVersion = "1.3.72"
const val KtlintVersion = "8.2.0"
const val LifeCycle = "2.0.0"

object Config {
    object Versions {
        const val minSdkVersion = 19
        const val compileSdkVersion = 30
        const val targetSdkVersion = 30
        const val versionName = "1.0.0"
        const val versionCode = 1
        const val navigation = "2.3.0"
        const val gradle = "3.5.2"
        const val Ktlint = "0.34.2"
        const val jacoco = "0.8.0"
    }

    object Android {
        const val applicationId = "com.ayokunlepaul.saluran"
    }

    object Classpaths {
        const val gradle = "com.android.tools.build:gradle:${Versions.gradle}"
        const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$KotlinVersion"
        const val ktlint = "org.jlleitschuh.gradle:ktlint-gradle:$KtlintVersion"
    }
}

object Dependencies {
    object AndroidX {
        object Versions {
            const val coreKtx = "1.1.0"
            const val constraintLayout = "2.0.0-beta2"
            const val workManager = "2.2.0"
        }

        const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
        const val lifecycle = "androidx.lifecycle:lifecycle-extensions:${LifeCycle}"
        const val lifecycleCompiler = "androidx.lifecycle:lifecycle-compiler:${LifeCycle}"
        const val constraintLayout =
            "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
        const val workManager = "androidx.work:work-runtime-ktx:${Versions.workManager}"
        const val workManagerRx = "androidx.work:work-rxjava2:${Versions.workManager}"
    }

    object Network {
        object Versions {
            const val okhttp = "3.12.0"
            const val retrofit = "2.4.0"
            const val stetho = "1.5.1"
        }

        const val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okhttp}"
        const val mockWebServer = "com.squareup.okhttp3:mockwebserver:${Versions.okhttp}"
        const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp}"
        const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
        const val gsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
        const val rxJavaAdapter = "com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofit}"

        const val stetho = "com.facebook.stetho:stetho:${Versions.stetho}"
    }

    object DependencyInjection {
        object Versions {
            const val javaxAnnotation = "1.0"
            const val javaxInject = "1"
            const val dagger = "2.24"
        }

        const val javax = "javax.inject:javax.inject:${Versions.javaxInject}"
        const val javaxAnnotation = "javax.annotation:jsr250-api:${Versions.javaxAnnotation}"
        const val dagger = "com.google.dagger:dagger:${Versions.dagger}"
        const val daggerProcessor = "com.google.dagger:dagger-compiler:${Versions.dagger}"
        const val daggerAndroid = "com.google.dagger:dagger-android-support:${Versions.dagger}"
        const val daggerAndroidProcessor =
            "com.google.dagger:dagger-android-processor:${Versions.dagger}"
    }

    object Persistence {
        object Versions {
            const val roomVersion = "2.2.5"
        }

        const val room = "androidx.room:room-runtime:${Versions.roomVersion}"
        const val roomRxJava = "androidx.room:room-rxjava2:${Versions.roomVersion}"
        const val roomCompiler = "androidx.room:room-compiler:${Versions.roomVersion}"
        const val roomTesting = "androidx.room:room-testing:${Versions.roomVersion}"
    }

    object View {
        object Versions {
            const val materialComponent = "1.3.0-alpha01"
            const val rxAnimation = "0.0.6"
            const val shimmerLayout = "0.4.0"
            const val mikhaellopez = "3.0.2"
        }

        const val materialComponent =
            "com.google.android.material:material:${Versions.materialComponent}"
        const val rxAnimation = "com.mikhaellopez:rxanimation:${Versions.rxAnimation}"
        const val shimmerLayout = "com.facebook.shimmer:shimmer:${Versions.shimmerLayout}"
        const val mikhaellopez = "com.mikhaellopez:circularimageview:${Versions.mikhaellopez}"
    }

    object Utilities {
        object Versions {
            const val recyclerAnimator = "3.0.0"
            const val gson = "2.8.5"
            const val timber = "4.7.1"
            const val overscrollDecor = "1.0.4"
        }

        const val recyclerAnimator =
            "jp.wasabeef:recyclerview-animators:${Versions.recyclerAnimator}"
        const val gson = "com.google.code.gson:gson:${Versions.gson}"
        const val timber = "com.jakewharton.timber:timber:${Versions.timber}"
        const val overscrollDecor =
            "me.everything:overscroll-decor-android:${Versions.overscrollDecor}"
    }

    object Async {
        object Versions {
            const val rxAndroid = "2.1.1"
            const val rxJava = "2.2.6"
        }

        const val rxJava = "io.reactivex.rxjava2:rxjava:${Versions.rxJava}"
        const val rxAndroid = "io.reactivex.rxjava2:rxandroid:${Versions.rxAndroid}"
    }

    object Test {
        object Versions {
            const val mockk = "1.9.3"
            const val junit = "4.12"
            const val runner = "1.1.0"
            const val rules = "1.1.0"
            const val testExt = "1.1.1"
            const val espresso = "3.2.0"
            const val fragment = "1.1.0-rc04"
        }

        const val mockk = "io.mockk:mockk:${Versions.mockk}"
        const val mockkAndroid = "io.mockk:mockk-android:${Versions.mockk}"
        const val junit = "junit:junit:${Versions.junit}"
        const val runner = "androidx.test:runner:${Versions.runner}"
        const val coreTesting = "androidx.arch.core:core-testing:${LifeCycle}"
        const val fragmentTesting = "androidx.fragment:fragment-testing:${Versions.fragment}"
        const val testExt = "androidx.test.ext:junit:${Versions.testExt}"
        const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
        const val rules = "androidx.test:rules:${Versions.rules}"
    }
}

fun DependencyHandler.inject() {
    add("implementation", Dependencies.DependencyInjection.javax)
    add("kapt", Dependencies.DependencyInjection.javaxAnnotation)
}

fun DependencyHandler.implementDI() {
    add("implementation", Dependencies.DependencyInjection.dagger)
    add("kapt", Dependencies.DependencyInjection.daggerProcessor)
    add("implementation", Dependencies.DependencyInjection.daggerAndroid)
    add("kapt", Dependencies.DependencyInjection.daggerAndroidProcessor)
}

fun DependencyHandler.implementWorker() {
    add("implementation", Dependencies.AndroidX.workManager)
    add("implementation", Dependencies.AndroidX.workManagerRx)
}

fun DependencyHandler.implementRoom() {
    add("implementation", Dependencies.Persistence.room)
    add("implementation", Dependencies.Persistence.roomRxJava)
    add("kapt", Dependencies.Persistence.roomCompiler)
    add("testImplementation", Dependencies.Persistence.roomTesting)
}

fun DependencyHandler.implementRetrofit() {
    add("api", Dependencies.Network.retrofit)
    add("api", Dependencies.Network.okhttp)
    add("api", Dependencies.Network.loggingInterceptor)
    add("api", Dependencies.Network.rxJavaAdapter)
    add("api", Dependencies.Network.gsonConverter)
    add("api", Dependencies.Network.stetho)
    add("testImplementation", Dependencies.Network.mockWebServer)
}

fun DependencyHandler.implementAsync() {
    add("implementation", Dependencies.Async.rxJava)
    add("implementation", Dependencies.Async.rxAndroid)
}

fun DependencyHandler.implementAndroidX() {
    add("implementation", Dependencies.AndroidX.coreKtx)
    add("implementation", Dependencies.AndroidX.constraintLayout)
    add("implementation", Dependencies.AndroidX.lifecycle)
    add("kapt", Dependencies.AndroidX.lifecycleCompiler)
    add("implementation", Dependencies.View.materialComponent)
}

fun DependencyHandler.implementLocal() {
    implementDI()
    implementRoom()
    add("implementation", Dependencies.AndroidX.coreKtx)
    add("implementation", kotlin("stdlib-jdk7", KotlinVersion))
    add("implementation", project(":data"))
}

fun DependencyHandler.implementRemote() {
    implementDI()
    implementRetrofit()
    add("implementation", Dependencies.Utilities.timber)
    add("implementation", Dependencies.Async.rxAndroid)
    add("implementation", Dependencies.Test.mockk)
    add("implementation", Dependencies.Test.junit)
    add("implementation", kotlin("stdlib-jdk7", KotlinVersion))
    add("implementation", project(":data"))
}

fun DependencyHandler.implementData() {
    add("implementation", kotlin("stdlib-jdk7", KotlinVersion))
    add("implementation", Dependencies.DependencyInjection.dagger)
    add("kapt", Dependencies.DependencyInjection.daggerProcessor)
    add("implementation", Dependencies.Test.mockk)
    add("implementation", Dependencies.Test.junit)
    implementAsync()
    inject()
}

fun DependencyHandler.implementApp() {
    add("implementation", kotlin("stdlib-jdk7", KotlinVersion))
    add("implementation", Dependencies.Utilities.timber)
    add("implementation", Dependencies.Utilities.overscrollDecor)
    add("implementation", Dependencies.Utilities.recyclerAnimator)
    add("implementation", Dependencies.View.shimmerLayout)
    add("testImplementation", Dependencies.Test.mockk)
    add("testImplementation", Dependencies.Test.junit)
    add("debugImplementation", Dependencies.Test.mockkAndroid)
    add("debugImplementation", Dependencies.Test.runner)
    add("debugImplementation", Dependencies.Test.testExt)
    add("debugImplementation", Dependencies.Test.espresso)
    add("debugImplementation", Dependencies.Test.rules)
    add("debugImplementation", Dependencies.Test.coreTesting)
    add("debugImplementation", Dependencies.Test.fragmentTesting)
    implementAndroidX()
    implementAsync()
    implementDI()
}