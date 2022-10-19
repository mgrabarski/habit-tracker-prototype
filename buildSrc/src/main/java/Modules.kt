object Modules {
    val resources by lazy { ":resources" }

    object Features {
        val splashScreen by lazy { ":features:splash-screen" }

        object Habits {
            val list by lazy { ":features:habits:list" }
            val addNew by lazy { ":features:habits:add-new" }
        }
    }
}
