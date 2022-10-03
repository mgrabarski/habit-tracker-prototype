plugins {
    androidApp()
    kotlinAndroid()
    id("com.google.devtools.ksp") version Versions.ksp
}

android {
    setAppConfig()

    flavorDimensions += AppProductFlavours.flavorDimensions

    productFlavors {
        create(AppProductFlavours.production) {
            namespace = ApplicationId.production
            applicationId = ApplicationId.production
        }
        create(AppProductFlavours.stage) {
            namespace = ApplicationId.stage
            applicationId = ApplicationId.stage
        }
        create(AppProductFlavours.dev) {
            namespace = ApplicationId.dev
            applicationId = ApplicationId.dev
        }
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Versions.composeCompiler
    }

    kotlinOptions {
        jvmTarget = Java.version.toString()
    }

    applicationVariants.all {
        kotlin.sourceSets {
            getByName(name) {
                kotlin.srcDir("build/generated/ksp/$name/kotlin")
            }
        }
    }
}

dependencies {

    implementation(AndroidDependencies.core)
    implementation(AndroidDependencies.lifecycleRuntime)
    implementation(AndroidDependencies.activityCompose)
    implementation(AndroidDependencies.composeUi)
    implementation(AndroidDependencies.composeToolingPreview)
    implementation(AndroidDependencies.material)
    implementation(AndroidDependencies.destinations)
    ksp(AndroidDependencies.destinationsKsp)

    implementation(project(Modules.resources))

    debugImplementation(AndroidDependencies.composeUiTooling)
    debugImplementation(AndroidDependencies.composeTestManifest)

    testImplementation(UnitTestDependencies.kotestCore)
    testImplementation(UnitTestDependencies.kotestRunner)

    androidTestImplementation(IntegrationTestDependencies.androidJunit)
    androidTestImplementation(IntegrationTestDependencies.espressoCore)
    androidTestImplementation(IntegrationTestDependencies.composeTestJunit)
}
