object CodeCoverage {

    val excludesModules = listOf(
        "app"
    )

    val excludesClasses = listOf(
        "*.di.*",
        "*.databinding.*",
        "*.BR",
        "*.BuildConfig",
        "*.*TriggerClass",
        "*.DataBinderMapperImpl",
        "*ComposableSingletons*",
    )

    val excludesAnnotations = listOf(
        "androidx.compose.runtime.Composable",
        "androidx.compose.ui.tooling.preview.Preview"
    )
}
