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
        versionCode = 2
        versionName = "1.0"
        buildConfigField("String", "mmVersion", "\"2580_8048\"")
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }


    flavorDimensions("version")
    productFlavors {

        create("2540_8046") {
            dimension = "version"
            buildConfigField("String", "mmVersion", "\"2540_8046\"")
        }
        create("2560_8047") {
            dimension = "version"
            buildConfigField("String", "mmVersion", "\"2560_8047\"")
        }
        create("2580_8048") {
            dimension = "version"
            buildConfigField("String", "mmVersion", "\"2580_8048\"")
        }
        create("2600_8049") {
            dimension = "version"
            buildConfigField("String", "mmVersion", "\"2600_8049\"")
        }
        create("2720_8051") {
            dimension = "version"
            buildConfigField("String", "mmVersion", "\"2720_8051\"")
        }
        create("2740_8053") {
            dimension = "version"
            buildConfigField("String", "mmVersion", "\"2740_8053\"")
        }
        create("2760_8054") {
            dimension = "version"
            buildConfigField("String", "mmVersion", "\"2760_8054\"")
        }
        create("2780_8055") {
            dimension = "version"
            buildConfigField("String", "mmVersion", "\"2780_8055\"")
        }
        create("2800_8056") {
            dimension = "version"
            buildConfigField("String", "mmVersion", "\"2800_8056\"")
        }
        create("2820_8057") {
            dimension = "version"
            buildConfigField("String", "mmVersion", "\"2820_8057\"")
        }
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
    buildFeatures {
        buildConfig = true
    }
}

dependencies {

    implementation("org.apache.commons:commons-lang3:3.12.0")
    compileOnly("de.robv.android.xposed:api:82") // 这里的版本号可能会有变化
//    implementation("androidx.appcompat:appcompat:1.6.1")
//    implementation("com.google.android.material:material:1.11.0")

//    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
//    implementation ("com.google.code.gson:gson:2.8.8")

    testImplementation("junit:junit:4.13.2")

    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}