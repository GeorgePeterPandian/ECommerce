plugins {
    `george-base-android-library-plugin`
    id("dagger.hilt.android.plugin")
    kotlin("plugin.serialization")
    kotlin("kapt")
}

android {
    namespace = "com.george.products.data"
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }

    buildFeatures{
        buildConfig = true
    }
}

kapt {
    correctErrorTypes = true
}

dependencies {

    implementation(project(":core"))
    implementation(project(":network"))
    implementation(project(":products-domain"))

    //Hilt
    kapt(libs.hilt.compiler)
    implementation(libs.hilt.android)

    implementation(libs.retrofit)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.kotlinx.serialization.core)
    implementation(libs.retrofit2.kotlinx.serialization.converter)


    //Test
    testImplementation(libs.junit)
    testImplementation(libs.mockk)
    testImplementation(libs.kotlinx.coroutines.test)
    testImplementation(libs.mockito.core)
}