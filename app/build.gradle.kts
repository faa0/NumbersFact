plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.android.kotlin)
}

android {
    namespace = "com.fara.numbersfact"
    compileSdk = libs.versions.compileSdk.orNull?.toInt()

    defaultConfig {
        applicationId = "com.fara.numbersfact"
        minSdk = libs.versions.minSdk.orNull?.toInt()
        targetSdk = libs.versions.targetSdk.orNull?.toInt()
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }

        getByName("debug") {
            applicationIdSuffix = ".debug"
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
            isDebuggable = true
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
        compose = true
        buildConfig = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.orNull?.toString()
    }

    dependencies {
        implementation(project(":core"))
        implementation(project(":navigation"))
        implementation(project(":ui-components"))

        implementation(project(":features:home:feature-home"))

        implementation(libs.koin)
        implementation(libs.core)
        implementation(libs.coroutines.core)
        implementation(libs.material)
        implementation(libs.compose.activity)
        implementation(libs.compose.ui)
        implementation(libs.compose.material)
        implementation(libs.voyager.androidx)
        implementation(libs.voyager.navigator)
    }
}