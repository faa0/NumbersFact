plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.android.kotlin)
}

android {
    namespace = "com.fara.navigation"
    compileSdk = libs.versions.compileSdk.orNull?.toInt()

    defaultConfig {
        minSdk = libs.versions.minSdk.orNull?.toInt()
    }

    buildTypes {
        getByName("release") {
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }

        getByName("debug") {
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
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
    api(libs.voyager.navigator)
}