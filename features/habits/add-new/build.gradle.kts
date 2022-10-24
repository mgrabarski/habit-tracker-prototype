import Libraries.uiAndCompose

plugins {
    androidLibrary()
    kotlinAndroid()
    ksp()
}

android {
    namespace = "com.mateuszgrabarski.habittracker.features.habits.add"

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

    implementation(project(Modules.resources))
    implementation(project(Modules.business))
}
