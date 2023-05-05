import Libraries.baseDependencies

plugins {
    androidLibrary()
    kotlinAndroid()
    ksp()
    kover()
}

android {
    namespace = "com.mateuszgrabarski.habittracker.framework.storage"

    setLibraryConfig()

    kotlinOptions {
        jvmTarget = Java.version.toString()
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Versions.composeCompiler
    }
}
dependencies {
    baseDependencies()

    implementation(AndroidDependencies.datastorePreferences)

    implementation(project(Modules.business))
}
