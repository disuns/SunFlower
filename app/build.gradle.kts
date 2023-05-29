plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = Apps.applicationId
    compileSdk = Apps.compileSdk

    defaultConfig {
        applicationId = Apps.applicationId
        minSdk = Apps.minSdk
        targetSdk = Apps.targetSdk
        versionCode = Apps.versionCode
        versionName = Apps.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName("release"){
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
        dataBinding = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Apps.kotlinCompilerExtensionVersion
    }

    packagingOptions.resources.excludes.add("/META-INF/{AL2.0,LGPL2.1}")
//    packagingOptions {
//        resources {
//            excludes += "/META-INF/{AL2.0,LGPL2.1}"
//        }
//    }
}

dependencies {
    implementation(Libs.androidx_core)
    implementation(platform(Libs.kotlin_bom))
    implementation(Libs.lifecycle_runtime)
    implementation(Libs.compose_activity)
    implementation(platform(Libs.compose_bom))
    implementation(Libs.compose_ui)
    implementation(Libs.compose_ui_graphics)
    implementation(Libs.compose_ui_tooling_preview)
    implementation(Libs.compose_material3)

    testImplementation(TestLibs.junit)

    androidTestImplementation(AndroidTestLibs.test_junit)
    androidTestImplementation(AndroidTestLibs.espresso)
    androidTestImplementation(AndroidTestLibs.compose_junit)

    debugImplementation(DebugLibs.compose_tooling)
    debugImplementation(DebugLibs.compose_test_manifest)

    implementation(Libs.hilt_android)
    kapt(Libs.hilt_compiler)
    implementation(Libs.hilt_navigation_compose)
}