object CodeCoverage {

    val excludesClasses = listOf(
        "*.di.*",
        "*.databinding.*",
        "*.BR",
        "*.BuildConfig",
        "*.*TriggerClass",
        "*.DataBinderMapperImpl"
    )

    val excludesAnnotations = listOf(
        "androidx.compose.runtime.Composable",
        "androidx.compose.ui.tooling.preview.Preview"
    )
}
