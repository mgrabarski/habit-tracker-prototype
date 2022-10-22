import Libraries.uiAndCompose

plugins {
    androidLibrary()
    kotlinAndroid()
    ksp()
}

android {
    namespace = "com.mateuszgrabarski.habittracker.resources"

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
    uiAndCompose()
}