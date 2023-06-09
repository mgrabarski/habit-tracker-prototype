import Libraries.baseDependencies
import Libraries.uiAndCompose

plugins {
    androidLibrary()
    kotlinAndroid()
    ksp()
    kover()
}

android {
    namespace = "com.mateuszgrabarski.habittracker.features.habits.list"

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

    implementation(project(Modules.resources))
    implementation(project(Modules.business))
}
