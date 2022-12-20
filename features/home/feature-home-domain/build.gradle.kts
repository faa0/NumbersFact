plugins {
    id(Plugins.AGP.library)
    kotlin(Plugins.Kotlin.android)
    kotlin(Plugins.Kotlin.kapt)
}

android {
    namespace = "com.fara.feature_home_domain"
    compileSdk = AndroidConfig.compileSdk

    defaultConfig {
        minSdk = AndroidConfig.minSdk
        targetSdk = AndroidConfig.targetSdk
    }

    buildTypes {
        getByName(AndroidConfig.release) {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
            buildConfigField("String", "BASE_URL", "\"http://numbersapi.com/\"")
        }
        getByName(AndroidConfig.debug) {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
            buildConfigField("String", "BASE_URL", "\"http://numbersapi.com/\"")
        }
    }
}
dependencies {
    implementation(project(Modules.COMMON_DI))
    implementation(project(Modules.COMMON_NETWORK))
    implementation(project(Modules.COMMON_UTILS))

    implementation(Libraries.Dagger.dagger)
    kapt(Libraries.Dagger.compiler)
    implementation(Libraries.Retrofit.retrofit)
    implementation(Libraries.Retrofit.moshiConverter)
    implementation(Libraries.Room.room)
    implementation(Libraries.Room.runtime)
    kapt(Libraries.Room.compiler)
}