plugins {
    id(Plugins.AGP.library)
    kotlin(Plugins.Kotlin.android)
    kotlin(Plugins.Kotlin.kapt)
}

android {
    namespace = "com.fara.common_network"
    compileSdk = AndroidConfig.compileSdk

    defaultConfig {
        minSdk = AndroidConfig.minSdk
        targetSdk = AndroidConfig.targetSdk
    }

    buildTypes {
        getByName(AndroidConfig.release) {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
            buildConfigField("String", "BASE_URL", "\"http://numbersapi.com/\"")
        }

        getByName(AndroidConfig.debug) {
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
            buildConfigField("String", "BASE_URL", "\"http://numbersapi.com/\"")
        }
    }
}

dependencies {
    implementation(project(Modules.COMMON_DI))
    implementation(project(Modules.COMMON_UTILS))

    implementation(Libraries.Dagger.dagger)
    kapt(Libraries.Dagger.compiler)
    implementation(Libraries.Retrofit.retrofit)
    implementation(Libraries.Retrofit.moshiConverter)
    implementation(Libraries.OkHttp.loggingInterceptor)
    implementation(Libraries.Moshi.moshi)
    implementation(Libraries.Moshi.adapter)
}