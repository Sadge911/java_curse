plugins {
    id("java")
}

group = "ru.easet"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // Основная библиотека Jackson
    implementation("com.fasterxml.jackson.core:jackson-databind:2.15.2")
    // Модуль для java.time
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.15.2")

    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}