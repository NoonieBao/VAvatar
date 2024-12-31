plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.xconst.vavatar"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.xconst.vavatar"
        minSdk = 26
        targetSdk = 34
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {

    implementation ("org.apache.commons:commons-lang3:3.12.0")
    compileOnly("de.robv.android.xposed:api:82") // 这里的版本号可能会有变化
//    implementation("androidx.appcompat:appcompat:1.6.1")
//    implementation("com.google.android.material:material:1.11.0")

//    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
//    implementation ("com.google.code.gson:gson:2.8.8")

    testImplementation("junit:junit:4.13.2")

    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}