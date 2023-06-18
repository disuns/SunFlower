@file:Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.application)
    alias(libs.plugins.jetbrain.android)
    id("kotlin-kapt")
    alias(libs.plugins.hilt)
}

android {
    namespace = "com.practice.sunflower"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.practice.sunflower"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0.0"

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
        kotlinCompilerExtensionVersion = "1.3.2"
    }

    packagingOptions.resources.excludes.add("/META-INF/{AL2.0,LGPL2.1}")
//    packagingOptions {
//        resources {
//            excludes += "/META-INF/{AL2.0,LGPL2.1}"
//        }
//    }
}

dependencies {
    implementation(libs.androidx.core)
    implementation(platform(libs.kotlin.bom))
    implementation(libs.lifecycle.runtime)
    implementation(libs.compose.activity)
    implementation(platform(libs.compose.bom))
    implementation(libs.bundles.androidx.compose)
//    implementation(libs.compose.ui)
//    implementation(libs.compose.ui.graphics)
//    implementation(libs.compose.ui.tooling.preview)
//    implementation(libs.compose.material3)
    implementation(libs.material)
    implementation(libs.accompanist.themeadapter.material)
    implementation(libs.bundles.androidx.room)
    implementation(libs.work.runtime.ktx)
    implementation(libs.gson)

    testImplementation(libs.junit)

    androidTestImplementation(libs.test.junit)
    androidTestImplementation(libs.espresso)
    androidTestImplementation(libs.compose.junit)
    androidTestImplementation(libs.work.testing)

    debugImplementation(libs.bundles.androidx.compose.debug.test)
//    debugImplementation(libs.compose.tooling)
//    debugImplementation(libs.compose.test.manifest)

    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)
    implementation(libs.hilt.navigation.compose)
}