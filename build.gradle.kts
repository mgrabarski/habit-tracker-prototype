import com.github.benmanes.gradle.versions.updates.DependencyUpdatesTask
import org.jlleitschuh.gradle.ktlint.KtlintExtension
import org.jlleitschuh.gradle.ktlint.reporter.ReporterType

buildscript {

    dependencies {
        Classpath.kotlinGradle
    }
}

plugins {
    id(BuildPlugins.ktlint) version Versions.ktlint
    id(BuildPlugins.detekt) version Versions.detekt
    id(BuildPlugins.dependencyUpdate) version Versions.dependencyUpdate
    id(BuildPlugins.kover) version Versions.kover
}

subprojects {
    apply(plugin = BuildPlugins.ktlint)
    apply(plugin = BuildPlugins.detekt)

    repositories {
        mavenCentral()
    }

    configure<KtlintExtension> {
        debug.set(true)
    }
}

ktlint {
    android.set(true)
    reporters {
        reporter(ReporterType.PLAIN)
        reporter(ReporterType.HTML)
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

koverMerged {
    enable()
    filters {
        projects {
            excludes += CodeCoverage.excludesModules
        }
        classes {
            excludes += CodeCoverage.excludesClasses
        }
        annotations {
            excludes += CodeCoverage.excludesAnnotations
        }
    }
}
