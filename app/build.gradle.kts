plugins {
    id(Plugins.AGP.application)
    kotlin(Plugins.Kotlin.android)
}

android {
    compileSdk = AndroidConfig.compileSdk

    defaultConfig {
        applicationId = "com.fara.numbersfact"
        minSdk = AndroidConfig.minSdk
        targetSdk = AndroidConfig.targetSdk
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        getByName(AndroidConfig.release) {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }

        getByName(AndroidConfig.debug) {
            applicationIdSuffix = ".debug"
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
            isDebuggable = true
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Versions.compose
    }
    namespace = "com.fara.numbersfact"

    dependencies {
        implementation(project(Modules.CORE))
        implementation(project(Modules.NAVIGATION))
        implementation(project(Modules.UI_COMPONENTS))

        implementation(project(Modules.FEATURE_HOME))

        implementation(Libraries.Koin.koin)
        implementation(Libraries.Core.core)
        implementation(Libraries.Coroutines.core)
        implementation(Libraries.Material.material)
        implementation(Libraries.Compose.activity)
        implementation(Libraries.Compose.ui)
        implementation(Libraries.Compose.material)
        implementation(Libraries.Voyager.viewModel)
        implementation(Libraries.Voyager.navigator)
    }
}