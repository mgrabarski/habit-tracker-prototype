pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "Habit Tracker"

include(
    ":app",
    ":resources",
    ":features:splash-screen",
    ":features:habits:list",
    ":features:habits:add-new",
    ":business",
    ":core:local-database",
    ":core:storage"
)
