pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
    }
}

plugins {
    id("org.gradle.experimental.android-ecosystem").version("0.1.43")
}

rootProject.name = "example-android-app"

include("app")
include("list")
include("utilities")

// Declarative Gradle prototype: keep settings.gradle.dcl limited to plugin management,
// root project naming and module includes. Module- and type-specific configuration
// (androidApplication/androidLibrary, testing, dependencies, etc.) must live in
// each module's build.gradle.dcl to avoid DSL resolution errors.
