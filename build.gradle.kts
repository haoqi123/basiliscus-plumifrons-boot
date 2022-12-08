import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.7.5"
    id("io.spring.dependency-management") version "1.0.15.RELEASE"
    kotlin("jvm") version "1.7.20"
    kotlin("plugin.spring") version "1.7.20"
    `java-library`
    `maven-publish`
}


java {
    //withJavadocJar()
    withSourcesJar()
}


publishing {
    publications {
        create<MavenPublication>("haoQi") {
            groupId = "github.haoqi123"
            artifactId = "basiliscus-plumifronts-boot"
            version = "0.0.1.beta"
            from(components["java"])
        }
    }
}

tasks.jar{
    archiveClassifier.set("")
}



group = "github.haoqi123"
version = "0.0.1-beta"
java.sourceCompatibility = JavaVersion.VERSION_17

//configurations {
//    compileOnly {
//        extendsFrom(configurations.annotationProcessor.get())
//    }
//}

repositories {
    mavenLocal()
    maven(url = "https://maven.aliyun.com/repository/public")
    mavenCentral()
}

dependencies {

    testImplementation("org.flywaydb:flyway-core:9.6.0")
    testImplementation("com.h2database:h2:2.1.214")
    testImplementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    testImplementation("org.springframework.boot:spring-boot-starter-test")

    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("com.baomidou:mybatis-plus-boot-starter:3.5.2")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
