plugins {
    id(Plugins.AGP.library)
    kotlin(Plugins.Kotlin.android)
    kotlin(Plugins.Kotlin.kapt)
}

android {
    namespace = "com.fara.feature_home"
    compileSdk = AndroidConfig.compileSdk

    defaultConfig {
        minSdk = AndroidConfig.minSdk
        targetSdk = AndroidConfig.targetSdk
    }

    buildTypes {
        getByName(AndroidConfig.release) {
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }

        getByName(AndroidConfig.debug) {
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Versions.composeCompiler
    }
}
dependencies {
    implementation(project(Modules.COMMON_DI))
    implementation(project(Modules.COMMON_UTILS))
    implementation(project(Modules.CORE))
    implementation(project(Modules.NAVIGATION))
    implementation(project(Modules.UI_COMPONENTS))

    implementation(project(Modules.FEATURE_HOME_DOMAIN))

    implementation(Libraries.Dagger.dagger)
    kapt(Libraries.Dagger.compiler)
    implementation(Libraries.Lifecycle.viewModel)
    implementation(Libraries.Voyager.viewModel)
    implementation(Libraries.Voyager.navigator)
    implementation(Libraries.Compose.ui)
    implementation(Libraries.Compose.material)
}