plugins {
    id(Plugins.APPLICATION)
    kotlin(Plugins.KOTLIN_ANDROID)

    id(Plugins.DAGGER_HILT_PLUGIN)
    id(Plugins.SAFEARGS)
    kotlin(Plugins.KOTLIN_KAPT)
}

android {
    compileSdk = AppConfig.compileSdk
    buildToolsVersion = AppConfig.buildToolsVersion

    defaultConfig {
        applicationId = AppConfig.applicationId
        minSdk =  AppConfig.minSdk
        targetSdk = AppConfig.targetSdk
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName

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
    kapt {
        correctErrorTypes = true
    }

    buildFeatures {
        dataBinding = true
    }
}

dependencies {
    testImplementation(AppDependencies.testLibraries)
    androidTestImplementation(AppDependencies.androidTestLibraries)

    api(AppDependencies.appAndroidLibraries)
    daggerHilt()
    kapts()
    api(project(mapOf("path" to AppDependencies.UTIL)))
    //api(project(mapOf("path" to AppDependencies.PRESENTATION)))
}