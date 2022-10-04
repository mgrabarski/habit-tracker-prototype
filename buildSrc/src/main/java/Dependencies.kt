import org.gradle.api.JavaVersion

object Dependencies {

}

object AndroidDependencies {
    val core by lazy { "androidx.core:core-ktx:${Versions.core}" }
    val lifecycleRuntime by lazy { "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleRuntime}" }
    val activityCompose by lazy { "androidx.activity:activity-compose:${Versions.activityCompose}" }
    val composeUi by lazy { "androidx.compose.ui:ui:${Versions.composeUi}" }
    val composeToolingPreview by lazy { "androidx.compose.ui:ui-tooling-preview:${Versions.composeToolingPreview}" }
    val composeUiTooling by lazy { "androidx.compose.ui:ui-tooling:${Versions.composeUiTooling}" }
    val composeTestManifest by lazy { "androidx.compose.ui:ui-test-manifest:${Versions.composeTestManifest}" }
    val material by lazy { "androidx.compose.material:material:${Versions.composeMaterial}" }
    val destinations by lazy { "io.github.raamcosta.compose-destinations:core:${Versions.destination}" }
    val destinationsKsp by lazy { "io.github.raamcosta.compose-destinations:ksp:${Versions.destination}" }
    val koinCore by lazy { "io.insert-koin:koin-android:${Versions.koinAndroid}" }
    val koinCompose by lazy { "io.insert-koin:koin-androidx-compose:${Versions.koinAndroidCompose}" }
}

object UnitTestDependencies {
    val junit by lazy { "org.junit.jupiter:junit-jupiter-api:${Versions.junit}" }
    val junitVintageEngine by lazy { "org.junit.vintage:junit-vintage-engine:${Versions.junit}" }
    val junitJupiterEngine by lazy { "org.junit.jupiter:junit-jupiter-engine" }
    val kotestCore by lazy { "io.kotest:kotest-assertions-core:${Versions.kotest}" }
    val kotestRunner by lazy { "io.kotest:kotest-runner-junit5:${Versions.kotest}" }
    val kotlinCoroutines by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutines}" }
    val mockk by lazy { "io.mockk:mockk:${Versions.mockk}" }
    val mockkAgentJvm by lazy { "io.mockk:mockk-agent-jvm:${Versions.mockkAgentJvm}" }
    val turbine by lazy { "app.cash.turbine:turbine:${Versions.turbine}" }
    val androidxCoreTesting by lazy { "androidx.arch.core:core-testing:${Versions.androidxCoreTesting}" }
    val koin by lazy { "io.insert-koin:koin-test-junit5:${Versions.koinAndroid}" }
}

object IntegrationTestDependencies {
    val androidJunit by lazy { "androidx.test.ext:junit:${Versions.androidJunit}" }
    val espressoCore by lazy { "androidx.test.espresso:espresso-core:${Versions.espressoCore}" }
    val composeTestJunit by lazy { "androidx.compose.ui:ui-test-junit4:${Versions.composeTestJunit}" }
}

object BuildPlugins {
    val androidApplication by lazy { "com.android.application" }
    val androidLibrary by lazy { "com.android.library" }
    val kotlin by lazy { "org.jetbrains.kotlin.android" }
    val ktlint by lazy { "org.jlleitschuh.gradle.ktlint" }
    val detekt by lazy { "io.gitlab.arturbosch.detekt" }
    val dependencyUpdate by lazy { "com.github.ben-manes.versions" }
}

object Java {
    val version = JavaVersion.VERSION_11
}
