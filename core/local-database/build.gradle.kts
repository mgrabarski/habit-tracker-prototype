import Libraries.baseDependencies
import Libraries.room

plugins {
    androidLibrary()
    kotlinAndroid()
    ksp()
    kover()
}

android {
    namespace = "com.mateuszgrabarski.habittracker.framework.database"

    ksp {
        arg("room.schemaLocation", "$projectDir/schemas")
        arg("room.incremental", "true")
        arg("room.expandProjection", "true")
    }

    setLibraryConfig()

    kotlinOptions {
        jvmTarget = Java.version.toString()
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
    room()

    implementation(project(Modules.business))
}
