plugins {
    id(Plugins.AGP.library)
    kotlin(Plugins.Kotlin.android)
    kotlin(Plugins.Kotlin.kapt)
}

android {
    namespace = "com.fara.navigation"
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
}
dependencies {
    implementation(Libraries.Dagger.dagger)
    kapt(Libraries.Dagger.compiler)
    implementation(Libraries.Fragment.fragment)
    implementation(Libraries.Voyager.navigator)
}