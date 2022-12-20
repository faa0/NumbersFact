plugins {
    id(Plugins.AGP.application)
    kotlin(Plugins.Kotlin.android)
    kotlin(Plugins.Kotlin.kapt)
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

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Versions.composeCompiler
    }

    dependencies {
        implementation(project(Modules.COMMON_DI))
        implementation(project(Modules.CORE))
        implementation(project(Modules.NAVIGATION))
        implementation(project(Modules.UI_COMPONENTS))

        implementation(project(Modules.FEATURE_HOME))

        implementation(Libraries.Dagger.dagger)
        kapt(Libraries.Dagger.compiler)
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