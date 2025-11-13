androidApplication {
    namespace = "org.example.app"

    // Enable Jetpack Compose using the declarative DSL for the prototype
    // Declarative Gradle preview currently supports enabling Compose via this simple flag.
    // The Compose Compiler version is derived from AGP/compose BOM and not configured here.
    compose {
        enabled = true
    }

    // Ensure JUnit Jupiter deps available if discovery runs
    testing {
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
        // Android TV specific Compose libraries (use stable artifact coordinates available on Google Maven)
        implementation("androidx.tv:tv-foundation:1.0.0-alpha10")
        implementation("androidx.tv:tv-material:1.0.0-alpha10")

        // Activity Compose integration
        implementation("androidx.activity:activity-compose:1.9.3")

        // Keep existing dependencies and modules
        implementation("org.apache.commons:commons-text:1.11.0")
        implementation(project(":utilities"))
    }
}
