import org.jetbrains.kotlin.storage.CacheResetOnProcessCanceled.enabled
plugins {
    id(Plugins.LIBRARY)
    kotlin(Plugins.KOTLIN_ANDROID)
    id(Plugins.DAGGER_HILT_PLUGIN)
    kotlin(Plugins.KOTLIN_KAPT)
    id("kotlin-android")
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

    implementation("androidx.appcompat:appcompat:1.4.0")
    implementation("com.google.android.material:material:1.4.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.2")
    testImplementation(AppDependencies.testLibraries)
    androidTestImplementation(AppDependencies.androidTestLibraries)

    daggerHilt()
    api(AppDependencies.domainLibraries)
    implementation(project(mapOf("path" to AppDependencies.UTIL)))
}