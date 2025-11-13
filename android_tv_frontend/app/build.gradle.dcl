androidApplication {
    namespace = "org.example.app"

    dependencies {
        // Compose BOM to align versions
        implementation(platform("androidx.compose:compose-bom:2024.10.01"))
        // Core Compose libraries
        implementation("androidx.compose.material3:material3")
        implementation("androidx.compose.ui:ui")
        implementation("androidx.compose.ui:ui-tooling-preview")
        // Navigation for Compose
        implementation("androidx.navigation:navigation-compose:2.8.3")
        // Android TV specific Compose libraries
        implementation("androidx.tv:tv-foundation:1.0.0-alpha12")
        implementation("androidx.tv:tv-material:1.0.0-alpha12")

        // Activity Compose integration
        implementation("androidx.activity:activity-compose:1.9.3")

        // Keep existing dependencies and modules
        implementation("org.apache.commons:commons-text:1.11.0")
        implementation(project(":utilities"))
    }
}
