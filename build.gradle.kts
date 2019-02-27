import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.21"
}

group = "io.github.shekibobo"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    compile(kotlin("stdlib-jdk8"))
    implementation("org.apache.hadoop:hadoop-mapreduce:3.2.0")
    implementation("org.apache.hadoop:hadoop-common:3.2.0")
    implementation("org.apache.hadoop:hadoop-yarn:3.2.0")
    compileOnly("org.apache.hadoop:hadoop-client:2.7.1")
    // hadoop common for map/reduce task
    compileOnly("org.apache.hadoop:hadoop-common:2.7.1")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}