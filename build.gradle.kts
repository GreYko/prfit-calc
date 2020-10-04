import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val junitVersion = "5.7.0"

plugins {
    base
    kotlin("jvm") version "1.4.10"
}

group = "org.proofit"
version = "1.0-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11


repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    testImplementation("org.junit.jupiter:junit-jupiter:$junitVersion")
}

tasks.withType<Test> {
    useJUnitPlatform()
    testLogging {
        events("passed", "skipped", "failed")
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        // https://kotlinlang.org/docs/reference/using-gradle.html#compiler-options
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}
