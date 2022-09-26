import com.github.benmanes.gradle.versions.updates.DependencyUpdatesTask

buildscript {
}

plugins {
    id(BuildPlugins.androidApplication) version Versions.androidApplication apply false
    id(BuildPlugins.androidLibrary) version Versions.androidApplication apply false
    id(BuildPlugins.kotlin) version Versions.kotlin apply false
    id(BuildPlugins.ktlint) version Versions.ktlint
    id(BuildPlugins.detekt) version Versions.detekt
    id(BuildPlugins.dependencyUpdate) version Versions.dependencyUpdate
}

subprojects {
    apply(plugin = BuildPlugins.ktlint)
    apply(plugin = BuildPlugins.detekt)

    repositories {
        mavenCentral()
    }

    configure<org.jlleitschuh.gradle.ktlint.KtlintExtension> {
        debug.set(true)
    }
}

fun isNonStable(version: String): Boolean {
    val stableKeyword = listOf("RELEASE", "FINAL", "GA").any { version.toUpperCase().contains(it) }
    val regex = "^[0-9,.v-]+(-r)?$".toRegex()
    val isStable = stableKeyword || regex.matches(version)
    return isStable.not()
}

tasks.withType<DependencyUpdatesTask> {
    rejectVersionIf {
        isNonStable(candidate.version)
    }
}

tasks.named<DependencyUpdatesTask>("dependencyUpdates").configure {
    checkForGradleUpdate = true
    outputFormatter = "html"
    outputDir = "build/dependencyUpdates"
    reportfileName = "report"
}
