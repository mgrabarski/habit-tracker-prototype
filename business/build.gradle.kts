import Libraries.baseDependencies

plugins {
    androidLibrary()
    kotlinAndroid()
    parcelize()
    kover()
}

android {
    namespace = "com.mateuszgrabarski.habittracker.business"

    setLibraryConfig()

    kotlinOptions {
        jvmTarget = Java.version.toString()
    }
}

dependencies {
    baseDependencies()

    implementation(AndroidDependencies.core)

    implementation(project(Modules.resources))
}
