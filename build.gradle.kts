// Top-level build file where you can add configuration options common to all sub-projects/modules.

plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    id("com.google.gms.google-services") version "4.3.15" apply false // ✅ Correct version
}

buildscript {
    repositories {
        google()  // Firebase requires this
        mavenCentral()
    }
    dependencies {
        // Android Gradle Plugin
        classpath("com.android.tools.build:gradle:8.9.2")  // Make sure this is compatible with your Android Studio version

        // Google Services plugin for Firebase
        classpath("com.google.gms:google-services:4.4.0")  // This enables Firebase in your app
    }
}

allprojects {
    repositories {
        google()  // Firebase requires this
        mavenCentral()
    }
}
