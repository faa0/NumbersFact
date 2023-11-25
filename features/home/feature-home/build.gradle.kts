plugins {
    id(Plugins.AGP.library)
    kotlin(Plugins.Kotlin.android)
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

    tasks.withType<Test> {
        useJUnitPlatform()
    }
}

dependencies {
    implementation(project(Modules.CORE))
    implementation(project(Modules.NAVIGATION))
    implementation(project(Modules.UI_COMPONENTS))

    implementation(project(Modules.FEATURE_HOME_DOMAIN))

    implementation(Libraries.Koin.koin)
    implementation(Libraries.Lifecycle.viewModel)
    implementation(Libraries.Voyager.viewModel)
    implementation(Libraries.Voyager.navigator)
    implementation(Libraries.Compose.ui)
    implementation(Libraries.Compose.material)

    testImplementation(Libraries.JUnit.jUnit)
    testRuntimeOnly(Libraries.JUnit.jUnitEngine)
    testImplementation(Libraries.JUnit.testing)
    testImplementation(Libraries.Mockito.mockito)
    testImplementation(Libraries.Coroutines.test)
}