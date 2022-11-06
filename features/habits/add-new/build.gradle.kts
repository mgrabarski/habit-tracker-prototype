import Libraries.baseDependencies
import Libraries.uiAndCompose

plugins {
    androidLibrary()
    kotlinAndroid()
    ksp()
    kover()
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

    tasks.withType<Test> {
        useJUnitPlatform()
    }
}

dependencies {
    baseDependencies()
    uiAndCompose()

    implementation(project(Modules.resources))
    implementation(project(Modules.business))
}
