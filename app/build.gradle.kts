plugins {
    alias(libs.plugins.android.application)
    // Adicione o plugin Kotlin se o seu projeto usa Kotlin
    id("org.jetbrains.kotlin.android") version "1.9.22"
}

android {
    namespace = "com.example.myapplication"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.myapplication"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        // Mantenho o Java 11 como no seu exemplo
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    // Adiciona o target JVM para Kotlin
    kotlinOptions {
        jvmTarget = "11"
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    // =========================================================================
    // 🛑 DEPENDÊNCIA VULNERÁVEL INCLUÍDA PARA TESTE (HIGH Severity)
    // Trivy detectará a CVE-2020-8840 (entre outras) nesta versão.
    // =========================================================================
    implementation("com.google.code.gson:gson:2.8.5")

    // Dependências do seu Version Catalog
    implementation("androidx.core:core-ktx:1.9.0")
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.constraintlayout)
    implementation(libs.navigation.fragment)
    implementation(libs.navigation.ui)

    // Testes
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}