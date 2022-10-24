import Libraries.baseDependencies

plugins {
    androidLibrary()
    kotlinAndroid()
}

android {
    namespace = "com.mateuszgrabarski.habittracker.business"

    setLibraryConfig()

    tasks.withType<Test> {
        useJUnitPlatform()
    }

    kotlinOptions {
        jvmTarget = Java.version.toString()
    }
}

dependencies {
    baseDependencies()

    implementation(AndroidDependencies.core)

    implementation(project(Modules.resources))
}
