plugins {
    androidLibrary()
    kotlinAndroid()
}

android {
    namespace = "com.mateuszgrabarski.habittracker.resources"

    setLibraryConfig()

    kotlinOptions {
        jvmTarget = Java.version.toString()
    }
}

dependencies {

    implementation(AndroidDependencies.core)
    implementation(AndroidDependencies.composeUi)
    implementation(AndroidDependencies.material)
}
