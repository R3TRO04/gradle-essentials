plugins {
    idea
    jacoco
    `java-gradle-plugin`
}

idea {
    project {
        module {
            isDownloadJavadoc = true
            isDownloadSources = true
        }
    }
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}

jacoco {
    toolVersion = "0.8.13"
}

group = "io.r3tro04.gradle.essentials"
configurations {
    all {
        resolutionStrategy {
            preferProjectModules()
            isTransitive = false
        }
    }
    dependencyLocking {
        lockMode = LockMode.LENIENT
        lockAllConfigurations()
    }
}

tasks {
    withType<JacocoReport>() {
        reports {
            xml.required = true
            csv.required = true
        }
    }

    named<Test>("test") {
        group = "verification"
        description = "Executes all tests."
        useJUnitPlatform {
            systemProperty("junit.jupiter.extensions.autodetection.enabled", true)
        }
        finalizedBy("jacocoTestReport")
    }
}
