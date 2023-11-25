object Versions {

    const val AGP = "7.3.1"
    const val kotlin = "1.7.10"
    const val coroutines = "1.6.4"
    const val core = "1.8.0"
    const val material = "1.7.0"
    const val fragment = "1.5.1"
    const val lifecycle = "2.5.1"
    const val voyager = "1.0.0-rc03"
    const val dagger = "2.44.2"
    const val retrofit = "2.9.0"
    const val okHttp = "4.10.0"
    const val moshi = "1.14.0"
    const val room = "2.4.2"
    const val compose = "1.3.1"
    const val composeCompiler = "1.3.1"
    const val composeActivity = "1.6.1"
    const val jUnit = "5.10.0"
    const val mockito = "5.6.0"
    const val jUnitTesting = "2.1.0"
}

object Libraries {

    object Coroutines {
        const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
        const val test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutines}"
    }

    object Core {
        const val core = "androidx.core:core-ktx:${Versions.core}"
    }

    object Material {
        const val material = "com.google.android.material:material:${Versions.material}"
    }

    object Fragment {
        const val fragment = "androidx.fragment:fragment-ktx:${Versions.fragment}"
    }

    object Lifecycle {
        const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
        const val runtime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"
    }

    object Voyager {
        const val navigator = "cafe.adriel.voyager:voyager-navigator:${Versions.voyager}"
        const val transitions = "cafe.adriel.voyager:voyager-transitions:${Versions.voyager}"
        const val viewModel = "cafe.adriel.voyager:voyager-androidx:${Versions.voyager}"
    }

    object Dagger {
        const val dagger = "com.google.dagger:dagger:${Versions.dagger}"
        const val compiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"
    }

    object Retrofit {
        const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
        const val moshiConverter = "com.squareup.retrofit2:converter-moshi:${Versions.retrofit}"
    }

    object OkHttp {
        const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp}"
    }

    object Moshi {
        const val moshi = "com.squareup.moshi:moshi-kotlin:${Versions.moshi}"
        const val adapter = "com.squareup.moshi:moshi-adapters:${Versions.moshi}"
    }

    object Room {
        const val room = "androidx.room:room-ktx:${Versions.room}"
        const val runtime = "androidx.room:room-runtime:${Versions.room}"
        const val compiler = "androidx.room:room-compiler:${Versions.room}"
    }

    object Compose {
        const val ui = "androidx.compose.ui:ui:${Versions.compose}"
        const val material = "androidx.compose.material:material:${Versions.compose}"
        const val activity = "androidx.activity:activity-compose:${Versions.composeActivity}"
    }

    object JUnit {
        const val jUnit = "org.junit.jupiter:junit-jupiter-api:${Versions.jUnit}"
        const val jUnitEngine = "org.junit.jupiter:junit-jupiter-engine:${Versions.jUnit}"
        const val testing = "androidx.arch.core:core-testing:${Versions.jUnitTesting}"
    }

    object Mockito {
        const val mockito = "org.mockito:mockito-core:${Versions.mockito}"
    }
}

object Plugins {

    object AGP {
        const val application = "com.android.application"
        const val library = "com.android.library"
    }

    object Kotlin {
        const val android = "android"
        const val jvm = "jvm"
        const val kapt = "kapt"
    }
}