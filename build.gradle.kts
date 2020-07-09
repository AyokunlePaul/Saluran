// Top-level build file where you can add configuration options common to all sub-projects/modules.
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jlleitschuh.gradle.ktlint.reporter.ReporterType

plugins {
    id("org.jlleitschuh.gradle.ktlint") version KtlintVersion
}

ktlint {
    setVersion(Config.Versions.Ktlint)
    debug.set(true)
    verbose.set(true)
    android.set(false)
    outputToConsole.set(true)
    reporters.set(setOf(ReporterType.PLAIN, ReporterType.CHECKSTYLE))
    ignoreFailures.set(true)
    kotlinScriptAdditionalPaths {
        include(fileTree("scripts/"))
    }
    filter {
        exclude("**/generated/**")
        include("**/kotlin/**")
    }
}

buildscript {
    repositories {
        google()
        jcenter()
        maven { setUrl("https://jitpack.io") }
        maven { setUrl("https://plugins.gradle.org/m2/") }
    }
    dependencies {
        classpath(kotlin("gradle-plugin", KotlinVersion))
        classpath(Config.Classpaths.gradle)
        classpath(Config.Classpaths.ktlint)
        classpath(Config.Classpaths.hilt)
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle.kts files
    }
}

allprojects {
    /*A work around for failed D8 build  https://github.com/mockk/mockk/issues/281*/
    configurations.all {
        resolutionStrategy {
            force("org.objenesis:objenesis:2.6")
        }
    }
    repositories {
        google()
        jcenter()
        maven { setUrl("https://jitpack.io") }
    }
    tasks.withType<KotlinCompile> {
        kotlinOptions.jvmTarget = "1.8"
    }
}

subprojects {
    apply(plugin = "org.jlleitschuh.gradle.ktlint")
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}