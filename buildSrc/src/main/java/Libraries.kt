import org.gradle.kotlin.dsl.DependencyHandlerScope

object Libraries {

    fun DependencyHandlerScope.baseDependencies() {
        koin()
        kotest()
    }

    fun DependencyHandlerScope.uiAndCompose() {
        dependencies.add("implementation", AndroidDependencies.lifecycleRuntime)
        dependencies.add("implementation", AndroidDependencies.activityCompose)
        dependencies.add("implementation", AndroidDependencies.composeUi)
        dependencies.add("implementation", AndroidDependencies.composeToolingPreview)
        dependencies.add("implementation", AndroidDependencies.material)
        dependencies.add("implementation", AndroidDependencies.materialNavigation)
        dependencies.add("implementation", AndroidDependencies.destinations)
        dependencies.add("ksp", AndroidDependencies.destinationsKsp)

        dependencies.add("debugImplementation", AndroidDependencies.composeUiTooling)
        dependencies.add("debugImplementation", AndroidDependencies.composeTestManifest)
    }

    fun DependencyHandlerScope.androidTests() {
        dependencies.add("androidTestImplementation", IntegrationTestDependencies.androidJunit)
        dependencies.add("androidTestImplementation", IntegrationTestDependencies.espressoCore)
        dependencies.add("androidTestImplementation", IntegrationTestDependencies.composeTestJunit)
    }

    private fun DependencyHandlerScope.koin() {
        dependencies.add("implementation", AndroidDependencies.koinCore)
        dependencies.add("implementation", AndroidDependencies.koinCompose)
        dependencies.add("testImplementation", UnitTestDependencies.koin)
    }

    private fun DependencyHandlerScope.kotest() {
        dependencies.add("testImplementation", UnitTestDependencies.kotestCore)
        dependencies.add("testImplementation", UnitTestDependencies.kotestRunner)
    }
}
