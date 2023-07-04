import com.vanniktech.maven.publish.KotlinJvm

plugins {
    kotlin("jvm")
    id("com.vanniktech.maven.publish.base")
}

version = Config.Lib.developmentVersion

kotlin {
    explicitApi()
}

tasks.test {
    useJUnitPlatform()
}

dependencies {
    api(Deps.Kotlin.coroutines)
    implementation(project(":connections:connection-core"))

    testImplementation(project(":definitions"))
    testImplementation(project(":connections:connection-tcp"))

    testImplementation(TestDeps.Jupiter.api)
    testRuntimeOnly(TestDeps.Jupiter.engine)
}

@Suppress("UnstableApiUsage")
mavenPublishing {
    configure(KotlinJvm())
}
