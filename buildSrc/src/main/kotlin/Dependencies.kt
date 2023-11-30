object Versions {

    const val AGP = "8.1.4"
    const val kotlin = "1.9.20"
    const val coroutines = "1.7.3"
    const val core = "1.12.0"
    const val material = "1.10.0"
    const val lifecycle = "2.6.2"
    const val voyager = "1.0.0-rc10"
    const val koin = "3.5.0"
    const val retrofit = "2.9.0"
    const val okHttp = "4.11.0"
    const val moshi = "1.15.0"
    const val room = "2.6.1"
    const val compose = "1.5.4"
    const val composeActivity = "1.8.1"
    const val jUnit = "5.10.1"
    const val mockito = "5.7.0"
    const val jUnitTesting = "2.2.0"
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

    object Lifecycle {
        const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
        const val runtime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"
    }

    object Voyager {
        const val navigator = "cafe.adriel.voyager:voyager-navigator:${Versions.voyager}"
        const val transitions = "cafe.adriel.voyager:voyager-transitions:${Versions.voyager}"
        const val viewModel = "cafe.adriel.voyager:voyager-androidx:${Versions.voyager}"
    }

    object Koin {
        const val koin = "io.insert-koin:koin-androidx-compose:${Versions.koin}"
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