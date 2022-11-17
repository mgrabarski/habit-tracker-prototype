import Libraries.baseDependencies
import Libraries.room
import Libraries.uiAndCompose

plugins {
    androidLibrary()
    kotlinAndroid()
    ksp()
    kover()
}

android {
    namespace = "com.mateuszgrabarski.habittracker.framework.database"

    defaultConfig {
        javaCompileOptions {
            annotationProcessorOptions {
                arguments += mapOf(
                    "room.schemaLocation" to "$projectDir/schemas",
                    "room.incremental" to "true",
                    "room.expandProjection" to "true"
                )
            }
        }
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
