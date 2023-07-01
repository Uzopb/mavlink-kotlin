plugins {
    kotlin("jvm")
    `java-gradle-plugin`
    idea
    id("maven-publish")
    id("com.gradle.plugin-publish") version "1.0.0"
}

version = Config.Plugin.developmentVersion

kotlin {
    explicitApi()
}

tasks.test {
    useJUnitPlatform()
}

idea {
    module {
        testSourceDirs.plusAssign(file("build/generated/sources"))
        generatedSourceDirs.plusAssign(file("build/generated/sources"))
    }
}

pluginBundle {
    website = "https://github.com/divyanshupundir/mavlink-kotlin"
    vcsUrl = "https://github.com/divyanshupundir/mavlink-kotlin"
    tags = listOf("mavlink", "kotlin", "jvm", "generator")
}

gradlePlugin {
    plugins {
        create("mavlinkGenerator") {
            id = "${Config.group}.generator"
            displayName = "MAVLink Kotlin Generator"
            description = "Plugin for generating Kotlin implementation of MAVLink dialects."
            implementationClass = "com.divpundir.mavlink.generator.plugin.MavlinkGeneratorPlugin"
        }
    }
}

dependencies {
    implementation(gradleApi())

    implementation(project(":api"))
    implementation(project(":serialization"))

    implementation(Deps.Jackson.dataFormatXml)
    implementation(Deps.Jackson.moduleKotlin)
    implementation(Deps.kotlinPoet)

    testImplementation(TestDeps.Jupiter.api)
    testRuntimeOnly(TestDeps.Jupiter.engine)
}
