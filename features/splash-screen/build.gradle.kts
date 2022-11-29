import Libraries.baseDependencies
import Libraries.uiAndCompose

plugins {
    androidLibrary()
    kotlinAndroid()
    ksp()
    kover()
}

android {
    namespace = "com.mateuszgrabarski.habittracker.features.splash"

    setLibraryConfig()

    kotlinOptions {
        jvmTarget = Java.version.toString()
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Versions.composeCompiler
    }
}

dependencies {
    baseDependencies()
    uiAndCompose()

    implementation(project(Modules.business))
    implementation(project(Modules.resources))
}
