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

    implementation("org.apache.hadoop:hadoop-mapreduce-client-core:3.2.0")
    implementation("org.apache.hadoop:hadoop-common:3.2.0")
    implementation("org.apache.hadoop:hadoop-hdfs-client:3.2.0")
    implementation("org.apache.hadoop:hadoop-yarn:3.2.0")
    implementation("org.apache.hadoop:hadoop-yarn-client:3.2.0")
    implementation("org.apache.hadoop:hadoop-yarn-api:3.2.0")
    implementation("org.apache.hadoop:hadoop-mapreduce-client-jobclient:3.2.0")
    implementation("org.apache.hadoop:hadoop-client:3.2.0")
    // hadoop common for map/reduce task
    implementation("org.apache.hadoop:hadoop-common:3.2.0")

    testImplementation("junit:junit:4.12")
    testImplementation("com.nhaarman.mockitokotlin2:mockito-kotlin:2.1.0")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}