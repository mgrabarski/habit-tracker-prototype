import com.android.build.gradle.BaseExtension
import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import org.gradle.api.tasks.testing.logging.TestLogEvent.FAILED

fun BaseAppModuleExtension.setAppConfig() {
    setLibraryConfig()

    defaultConfig {
        applicationId = ApplicationId.production
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName
        multiDexEnabled = true
    }

    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

fun BaseExtension.setLibraryConfig() {
    compileSdkVersion(AppConfig.compileSdk)

    defaultConfig {
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk

        testInstrumentationRunner = AppConfig.testInstrumentationRunner
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = Java.version
        targetCompatibility = Java.version
    }

    sourceSets {
        getByName("main").java.srcDirs("src/main/kotlin")
    }

    testOptions {
        unitTests.all {
            it.testLogging {
                events = setOf(FAILED)
            }
        }
    }
}
