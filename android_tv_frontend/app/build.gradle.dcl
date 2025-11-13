androidApplication {
    // Core Android app configuration required by the declarative DSL
    jdkVersion = 17
    compileSdk = 34
    minSdk = 30

    // App identity and versioning
    applicationId = "org.gradle.experimental.android.app"
    versionCode = 1
    versionName = "0.1"

    namespace = "org.example.app"

    // Enable Jetpack Compose using the declarative DSL for the prototype
    compose {
        enabled = true
    }

    // Keep test dependencies and test behavior scoped under the app module
    testing {
        // Do not fail the unit test task when no tests are discovered in CI environments
        // This maps to Gradle Test.failOnNoDiscoveredTests=false
        failOnNoDiscoveredTests = false

        dependencies {
            implementation("org.junit.jupiter:junit-jupiter:5.10.2")
            runtimeOnly("org.junit.platform:junit-platform-launcher")
        }
    }

    dependencies {
        // Compose BOM to align versions
        implementation(platform("androidx.compose:compose-bom:2024.06.00"))
        // Core Compose libraries
        implementation("androidx.compose.material3:material3")
        implementation("androidx.compose.ui:ui")
        implementation("androidx.compose.ui:ui-tooling-preview")

        // Material Components for XML theme compatibility
        implementation("com.google.android.material:material:1.12.0")
        // Navigation for Compose
        implementation("androidx.navigation:navigation-compose:2.8.3")
        // Android TV specific Compose libraries
        implementation("androidx.tv:tv-foundation:1.0.0-alpha10")
        implementation("androidx.tv:tv-material:1.0.0-alpha10")

        // Activity Compose integration
        implementation("androidx.activity:activity-compose:1.9.3")

        // Keep existing dependencies and modules
        implementation("org.apache.commons:commons-text:1.11.0")
        implementation(project(":utilities"))
    }
}
