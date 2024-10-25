plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
}

android {
    namespace = "com.example.youtobe"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.youtobe"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        buildConfigField(
            "String",
            "BASE_URL",
            "\"https://www.googleapis.com/youtube/v3/\""
        )
        buildConfigField(
            "String",
            "API_KEY",
            "\"AIzaSyA8GHVmocaecxakuhpH3fyBGsqiQAk2TFY\""
        )

    }

    buildTypes {
        release {
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
        jvmTarget = "1.8"
    }
    buildFeatures{
        viewBinding = true
        buildConfig = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)// ViewModel
    val lifecycleVersion = "2.7.0"
    implementation(libs.androidx.lifecycle.viewmodel.ktx)

    // LiveData
    implementation ("androidx.fragment:fragment-ktx:1.8.4")
    implementation(libs.androidx.lifecycle.livedata.ktx)

    //Retrofit
    implementation ("com.squareup.retrofit2:retrofit:2.11.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.11.0")

    //OkHttpClient
    val okHttpClientVersion = "4.12.0"
    implementation(libs.okhttp)
    implementation(libs.logging.interceptor)

    //Glide
    implementation (libs.glide)

    // Koin for Android
    implementation (libs.koin.android)

    //Coroutines
    implementation(libs.kotlinx.coroutines.android)
}