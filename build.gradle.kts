plugins {
    id("java-library")
    id("io.qameta.allure") version "2.11.2"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.2")
    testImplementation("com.github.javafaker:javafaker:1.0.2")
    testImplementation("com.codeborne:selenide:6.11.2")
    testImplementation("io.qameta.allure:allure-junit5:2.13.6")
    testImplementation("io.qameta.allure:allure-commandline:2.13.6")
    testImplementation("io.qameta.allure:allure-assertj:2.13.6")
    testImplementation("io.qameta.allure:allure-rest-assured:2.13.6")
    testImplementation("io.qameta.allure:allure-java-commons:2.17.2")
    testImplementation("org.aspectj:aspectjweaver:1.9.9.1")
    testImplementation("org.aeonbits.owner:owner:1.0.12")
    testImplementation("org.assertj:assertj-core:3.23.1")
    testImplementation("io.qameta.allure:allure-selenide:2.20.1")
    testImplementation("io.rest-assured:rest-assured:5.3.0")
    testImplementation("io.rest-assured:json-path:5.3.0")
    testImplementation("io.rest-assured:xml-path:5.3.0")
    testImplementation("io.rest-assured:json-schema-validator:5.3.0")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}
tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}