enableFeaturePreview("GROOVY_COMPILATION_AVOIDANCE")

rootProject.name = "gradle-essentials"

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
    repositoriesMode = RepositoriesMode.FAIL_ON_PROJECT_REPOS

    versionCatalogs {
        create("libs") {
            from(files("./gradle/versions.toml"))
        }
    }
}

buildCache {
    local {
        directory = File(rootDir, "build-cache")
    }
}

rootDir.listFiles()
    .filter {
        it.isDirectory &&
        (File(it, "build.gradle.kts").exists()) &&
        it.name != "buildSrc"
    }.forEach {
        include(":${it.name}")
    }

