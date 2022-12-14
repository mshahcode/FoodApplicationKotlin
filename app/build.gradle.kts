plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.dagger.hilt.android)
    alias(libs.plugins.androidx.navigation.safeargs)
}

android {
    namespace = "com.example.foodsapp"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.foodsapp"
        minSdk = 21
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
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
        viewBinding = true
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.android.material)
    implementation(libs.androidx.constraintlayout)

    implementation(libs.bundles.androidx.lifecycle)
    implementation(libs.bundles.androidx.navigation)
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.bundles.retrofit)

    implementation(libs.glide)

    implementation(libs.dagger.hilt.android)
    kapt(libs.dagger.hilt.compiler)
    implementation(libs.androidx.hilt.navigation.fragment)

    testImplementation(libs.junit)
    testImplementation(libs.mockk)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.androidx.test.espresso.core)
    androidTestImplementation(libs.androidx.navigation.testing)
}
