import org.gradle.api.artifacts.dsl.DependencyHandler

object AppDependencies {

    const val REMOTE =  ":remote"
    const val LOCAL =  ":local"
    const val DATA =  ":data"
    const val DOMAIN =  ":domain"
    const val CORE =  ":core"
    const val UTIL =  ":util"
    const val PRESENTATION =  ":presentation"
    const val MOVIEDETAILS =  ":moviedetails"


    //android ui
    private const val APPCOMPAT = "androidx.appcompat:appcompat:${Versions.APPCOMPAT}"
    private const val CORE_KTX = "androidx.core:core-ktx:${Versions.CORE_KTX}"
    private const val MATERIAL = "com.google.android.material:material:${Versions.MATERIAL}"
    private const val CONSTRAINT_LAYOUT = "androidx.constraintlayout:constraintlayout:${Versions.CONSTRAINT_LAYOUT}"

    //test libs
    private const val JUNIT = "junit:junit:${Versions.JUNIT}"
    private const val EXT_JUNIT = "androidx.test.ext:junit:${Versions.EXT_JUNIT}"
    private const val ESPRESSO_CORE = "androidx.test.espresso:espresso-core:${Versions.ESPRESSO}"

    //classpath
    const val GRADLE = "com.android.tools.build:gradle:${Versions.GRADLE}"
    const val KOTLIN = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.KOTLIN}"

    //MVVM
    const val VIEWMODEL ="androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.LIFECYCLE}"
    const val LIVEDATA ="androidx.lifecycle:lifecycle-livedata-ktx:${Versions.LIFECYCLE}"

    //Picasso
    const val PICASSO ="com.squareup.picasso:picasso:${Versions.PICASSO}"

    //room
    const val ROOM ="androidx.room:room-runtime:${Versions.ROOM}"
    const val ROOM_KTX ="androidx.room:room-ktx:${Versions.ROOM}"
    const val ROOM_COMPILER ="androidx.room:room-compiler:${Versions.ROOM}"

    //retrofit
    const val RETROFIT ="com.squareup.retrofit2:retrofit:${Versions.RETROFIT}"
    const val RETROFIT_GSON ="com.squareup.retrofit2:converter-gson:${Versions.RETROFIT}"

    //coroutines
    const val COROUTINE ="org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.COROUTINE}"

    //safe-args
    const val SAFE_ARGS ="androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.SAFE_ARGS}"

    //navigation
    const val NAVIGATION ="androidx.navigation:navigation-fragment-ktx:${Versions.NAVIGATION}"
    const val NAVIGATION_UI ="androidx.navigation:navigation-ui-ktx:${Versions.NAVIGATION}"


    //ktx
    const val ACTIVITY_KTX ="androidx.activity:activity-ktx:${Versions.KTX}"
    const val FRAGMENT_KTX ="androidx.fragment:fragment-ktx:${Versions.KTX}"

    //dagger hilt
    const val DAGGER_HILT_GRADLE_PLUGIN ="com.google.dagger:hilt-android-gradle-plugin:${Versions.DAGGER_HILT}"
    const val DAGGER_HILT  ="com.google.dagger:hilt-android:${Versions.DAGGER_HILT}"
    const val DAGGER_HILT_COMPILER  ="com.google.dagger:hilt-android-compiler:${Versions.DAGGER_HILT}"

    //CircleImageView
    const val CIRCLE_IMAGE_VIEW  ="de.hdodenhof:circleimageview:${Versions.CIRCLE_IMAGE_VIEW}"

    //inject
    const val INJECT  ="javax.inject:javax.inject:${Versions.JAVAX_INJECT}"

    //paging
    const val PAGING  ="androidx.paging:paging-runtime:${Versions.PAGING}"

    //bannerslider
    const val BANNERSLIDER  ="com.ss.bannerslider:bannerslider:${Versions.BANNERSLIDER}"



    val presentation = arrayListOf<String>().apply {
        add(VIEWMODEL)
        add(LIVEDATA)
        add(COROUTINE)
    }
    val retrofit = arrayListOf<String>().apply {
        add(RETROFIT)
        add(RETROFIT_GSON)
    }
    val ktx = arrayListOf<String>().apply {
        add(CORE_KTX)
        add(ACTIVITY_KTX)
        add(FRAGMENT_KTX)
    }

    val appAndroidLibraries = arrayListOf<String>().apply {
        add(MATERIAL)
        add(APPCOMPAT)
        add(CONSTRAINT_LAYOUT)
        add(PICASSO)
        add(CIRCLE_IMAGE_VIEW)
        add(NAVIGATION)
        add(NAVIGATION_UI)
        add(PAGING)
        add(BANNERSLIDER)
    }

    val remoteLibraries = arrayListOf<String>().apply {
        add(COROUTINE)
        add(RETROFIT)
        add(RETROFIT_GSON)
        add(PAGING)
    }

    val domainLibraries = arrayListOf<String>().apply {
        add(PAGING)
    }


    val androidLibraries = arrayListOf<String>().apply {
        add(COROUTINE)
    }


    val androidTestLibraries = arrayListOf<String>().apply {
        add(EXT_JUNIT)
        add(ESPRESSO_CORE)
    }

    val testLibraries = arrayListOf<String>().apply {
        add(JUNIT)
    }

    val classpath = arrayListOf<String>().apply {
        add(GRADLE)
        add(KOTLIN)
    }

}

fun DependencyHandler.room() {
    kapt(AppDependencies.ROOM_COMPILER)
    implementation(AppDependencies.ROOM)
    implementation(AppDependencies.ROOM_KTX)
}
fun DependencyHandler.daggerHilt() {
    kapt(AppDependencies.DAGGER_HILT_COMPILER)
    implementation(AppDependencies.DAGGER_HILT)
}



//util functions for adding the different type dependencies from build.gradle file
fun DependencyHandler.kapt(list: List<String>) {
    list.forEach { dependency ->
        add("kapt", dependency)
    }
}

fun DependencyHandler.implementation(list: List<String>) {
    list.forEach { dependency ->
        add("implementation", dependency)
    }
}

fun DependencyHandler.androidTestImplementation(list: List<String>) {
    list.forEach { dependency ->
        add("androidTestImplementation", dependency)
    }
}

fun DependencyHandler.testImplementation(list: List<String>) {
    list.forEach { dependency ->
        add("testImplementation", dependency)
    }
}

fun DependencyHandler.api(list: List<String>){
    list.forEach { dependency ->
        add("api", dependency)
    }
}


private fun DependencyHandler.implementation(depName: String) {
    add("implementation", depName)
}
private fun DependencyHandler.kapt(depName: String) {
    add("kapt", depName)
}
private fun DependencyHandler.compileOnly(depName: String) {
    add("compileOnly", depName)
}
private fun DependencyHandler.api(depName: String) {
    add("api", depName)
}