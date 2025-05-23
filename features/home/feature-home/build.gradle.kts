plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.android.kotlin)
    alias(libs.plugins.compose.compiler)
}

android {
    namespace = "com.fara.feature_home"
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
        compose = true
        buildConfig = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.orNull
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }
}

dependencies {
    api(project(":core"))
    api(project(":navigation"))
    api(project(":ui-components"))

    implementation(project(":features:home:feature-home-domain"))

    testImplementation(libs.junit.jupiter.api)
    testRuntimeOnly(libs.junit.jupiter.engine)
    testImplementation(libs.junit.jupiter.testing)
    testImplementation(libs.mockito.core)
    testImplementation(libs.coroutines.test)
}