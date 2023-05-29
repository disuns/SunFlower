object Apps {
    const val applicationId = "com.practice.sunflower"
    const val compileSdk = 33
    const val minSdk = 24
    const val targetSdk = 33
    const val versionCode = 1
    const val versionName = "1.0.0"

    const val kotlinCompilerExtensionVersion = "1.3.2"

    const val jvmTarget = "1.8"
    const val gradle = "3.5.2"
}

object Versions {
    const val androidxCore = "1.8.0"
    const val kotlin_bom = "1.8.0"
    const val lifecycle = "2.3.1"
    const val androidx_compose_activity = "1.5.1"
    const val compose_bom = "2022.10.00"

    //쓸거긴함
    const val hilt = "2.44"
    const val hilt_navigation_compose = "1.0.0"

    const val junit = "4.13.2"

    const val test_junit = "1.1.5"
    const val espresso = "3.5.1"
    const val compose_junit = "1.0.0-alpha12"
}

object Libs {
    const val androidx_core = "androidx.core:core-ktx:${Versions.androidxCore}"
    const val kotlin_bom = "org.jetbrains.kotlin:kotlin-bom:${Versions.kotlin_bom}"
    const val lifecycle_runtime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"

    //hilt
    const val hilt_android = "com.google.dagger:hilt-android:${Versions.hilt}"
    const val hilt_compiler = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"
    const val hilt_plugin = "com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt}"

    //compose
    const val compose_bom = "androidx.compose:compose-bom:${Versions.compose_bom}"
    const val compose_activity = "androidx.activity:activity-compose:${Versions.androidx_compose_activity}"
    const val compose_ui = "androidx.compose.ui:ui"
    const val compose_ui_graphics = "androidx.compose.ui:ui-graphics"
    const val compose_ui_tooling_preview = "androidx.compose.ui:ui-tooling-preview"
    const val compose_material3 = "androidx.compose.material3:material3"

    const val hilt_navigation_compose = "androidx.hilt:hilt-navigation-compose:${Versions.hilt_navigation_compose}"
}

object TestLibs {
    const val junit = "junit:junit:${Versions.junit}"
}

object DebugLibs {
    const val compose_tooling = "androidx.compose.ui:ui-tooling"
    const val compose_test_manifest = "androidx.compose.ui:ui-test-manifest"
}

object AndroidTestLibs{
    const val test_junit = "androidx.test.ext:junit:${Versions.test_junit}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    const val compose_junit = "androidx.compose.ui:ui-test-junit4:${Versions.compose_junit}"
}
