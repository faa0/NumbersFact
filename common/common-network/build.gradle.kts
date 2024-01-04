plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.android.kotlin)
}

android {
    namespace = "com.fara.common_network"
    compileSdk = libs.versions.compileSdk.orNull?.toInt()

    defaultConfig {
        minSdk = libs.versions.minSdk.orNull?.toInt()
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
            buildConfigField("String", "BASE_URL", "\"http://numbersapi.com/\"")
        }

        getByName("debug") {
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
            buildConfigField("String", "BASE_URL", "\"http://numbersapi.com/\"")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }

    buildFeatures {
        buildConfig = true
    }
}

dependencies {
    api(libs.koin)
    api(libs.retrofit)
    api(libs.okhttp.interceptor)
    api(libs.moshi.adapters)
    api(libs.retrofit.converter)
    implementation(libs.moshi.kotlin)
}