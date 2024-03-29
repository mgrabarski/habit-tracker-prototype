plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
    google()
}

dependencies {
    implementation(gradleApi())
    implementation(localGroovy())

    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.21")
    implementation("com.android.tools.build:gradle:8.0.1")
}
