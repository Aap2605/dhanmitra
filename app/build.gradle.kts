plugins {
    id("com.android.application")
    id("kotlin-android")
}

android {
    namespace = "com.dhanmitra"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.dhanmitra"
        minSdk = 21
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    // Basic Android dependencies
    implementation("androidx.core:core-ktx:1.6.0")
    implementation("androidx.appcompat:appcompat:1.3.1")
    implementation("com.google.android.material:material:1.6.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.0")

    // Networking for MySQL APIs
    implementation("com.squareup.retrofit2:retrofit:2.9.0")       // Retrofit for network requests
    implementation("com.squareup.retrofit2:converter-gson:2.9.0") // Gson converter for JSON parsing

    // OkHttp Logging Interceptor for logging network requests/responses
    implementation("com.squareup.okhttp3:logging-interceptor:4.9.3")

    // ✅ Add this line for unit testing
    testImplementation("junit:junit:4.13.2")
}