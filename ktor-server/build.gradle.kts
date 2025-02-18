plugins {
    kotlin("jvm")
}

group = "cl.sangut.projects"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.ktor:ktor-server-core:2.3.2")
    implementation("io.ktor:ktor-server-websockets:2.3.2")
    implementation("io.ktor:ktor-server-netty:2.3.2")

    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}