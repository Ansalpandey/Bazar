plugins {
  id("com.android.application")
  id("org.jetbrains.kotlin.android")
  id("com.google.gms.google-services")
  id("com.google.firebase.firebase-perf")
}

android {
  namespace = "com.organisation.bazar"
  compileSdk = 34

  defaultConfig {
    applicationId = "com.organisation.bazar"
    minSdk = 31
    targetSdk = 34
    versionCode = 1
    versionName = "1.0"

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    vectorDrawables { useSupportLibrary = true }
  }

  buildTypes {
    release {
      isMinifyEnabled = false
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
    }
  }
  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
  }
  kotlinOptions { jvmTarget = "1.8" }
  buildFeatures { compose = true }
  composeOptions { kotlinCompilerExtensionVersion = "1.5.1" }
  packaging { resources { excludes += "/META-INF/{AL2.0,LGPL2.1}" } }
}

dependencies {
  implementation("androidx.core:core-ktx:1.12.0")
  implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
  implementation("androidx.activity:activity-compose:1.8.2")
  implementation(platform("androidx.compose:compose-bom:2023.08.00"))
  implementation("androidx.compose.ui:ui")
  implementation("androidx.compose.ui:ui-graphics")
  implementation("androidx.compose.ui:ui-tooling-preview")
  implementation("androidx.compose.material3:material3")
  testImplementation("junit:junit:4.13.2")
  androidTestImplementation("androidx.test.ext:junit:1.1.5")
  androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
  androidTestImplementation(platform("androidx.compose:compose-bom:2023.08.00"))
  androidTestImplementation("androidx.compose.ui:ui-test-junit4")
  debugImplementation("androidx.compose.ui:ui-tooling")
  debugImplementation("androidx.compose.ui:ui-test-manifest")
  implementation("com.google.accompanist:accompanist-pager:0.23.1")

  // Splash Screen API
  implementation("androidx.core:core-splashscreen:1.0.1")
  // Navigation API
  implementation("androidx.navigation:navigation-compose:2.7.6")

  // pager lib
  implementation("com.google.accompanist:accompanist-pager:0.23.1")
  // pager indicator
  implementation("com.google.accompanist:accompanist-pager-indicators:0.23.1")

  // coil
  implementation("io.coil-kt:coil-compose:2.5.0")
  implementation("androidx.compose.material:material-icons-extended:1.5.4")

  // Firebase
  implementation(platform("com.google.firebase:firebase-bom:32.7.0"))
  implementation("com.google.firebase:firebase-analytics-ktx:21.5.0")
  implementation("com.google.firebase:firebase-auth-ktx:22.3.0")
  implementation("com.google.firebase:firebase-storage-ktx:20.3.0")
  implementation("com.google.firebase:firebase-database-ktx:20.3.0")
  implementation("com.google.firebase:firebase-firestore-ktx:24.10.0")

  implementation("androidx.compose.runtime:runtime-livedata:1.5.4")
  implementation("com.google.firebase:firebase-perf:20.5.1")

  implementation ("com.squareup.retrofit2:retrofit:2.9.0")
  implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
  implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
  implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")

  // ViewModel
  implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")
  // ViewModel utilities for Compose
  implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.7.0")
  // LiveData
  implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.7.0")
  // Lifecycles only (without ViewModel or LiveData)
  implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
  // Lifecycle utilities for Compose
  implementation("androidx.lifecycle:lifecycle-runtime-compose:2.7.0")
}
