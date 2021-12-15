import org.jetbrains.kotlin.storage.CacheResetOnProcessCanceled.enabled
plugins {
    id(Plugins.LIBRARY)
    kotlin(Plugins.KOTLIN_ANDROID)
    id(Plugins.DAGGER_HILT_PLUGIN)
    kotlin(Plugins.KOTLIN_KAPT)
}

android {
    compileSdk = AppConfig.compileSdk
    buildToolsVersion = AppConfig.buildToolsVersion

    defaultConfig {
        minSdk =  AppConfig.minSdk
        targetSdk = AppConfig.targetSdk
        testInstrumentationRunner = AppConfig.androidTestInstrumentation
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }


    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = Versions.JVM_TARGET
    }

    buildFeatures {
        dataBinding = true
    }

}

dependencies {

    testImplementation(AppDependencies.testLibraries)
    androidTestImplementation(AppDependencies.androidTestLibraries)
    api(AppDependencies.remoteLibraries)
    daggerHilt()
    implementation(project(mapOf("path" to AppDependencies.DATA)))
}