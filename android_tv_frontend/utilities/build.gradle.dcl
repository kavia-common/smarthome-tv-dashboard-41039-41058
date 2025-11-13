androidLibrary {
    jdkVersion = 17
    compileSdk = 34
    minSdk = 30

    namespace = "org.gradle.experimental.android.utilities"

    dependencies {
        api(project(":list"))
    }
}
