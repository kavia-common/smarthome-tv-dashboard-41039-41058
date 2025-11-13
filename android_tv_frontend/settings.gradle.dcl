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

defaults {
    androidApplication {
        jdkVersion = 17
        compileSdk = 34
        minSdk = 30

        // Moved Compose configuration into the module build files to avoid DSL resolution errors.

        versionCode = 1
        versionName = "0.1"
        applicationId = "org.gradle.experimental.android.app"

        testing {
            // Apply JUnit dependencies and do not fail when no tests are discovered in certain environments
            dependencies {
                implementation("org.junit.jupiter:junit-jupiter:5.10.2")
                runtimeOnly("org.junit.platform:junit-platform-launcher")
            }
            // Declarative Prototype: configure behavior flags at defaults level

        }
    }

    androidLibrary {
        jdkVersion = 17
        compileSdk = 34
        minSdk = 30

        // Moved Compose configuration into module files if/when needed.

        testing {
            dependencies {
                implementation("org.junit.jupiter:junit-jupiter:5.10.2")
                runtimeOnly("org.junit.platform:junit-platform-launcher")
            }
            // Removed failOnNoDiscoveredTests as it is not supported in this Declarative DSL version.
        }
    }
}
