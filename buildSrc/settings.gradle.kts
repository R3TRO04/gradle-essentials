enableFeaturePreview("GROOVY_COMPILATION_AVOIDANCE")

pluginManagement {
    repositories {
        mavenLocal()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositories {
        mavenLocal()
        mavenCentral()
    }

    versionCatalogs {
        create("libs") {
            from(files("../gradle/versions.toml"))
        }
    }
}

