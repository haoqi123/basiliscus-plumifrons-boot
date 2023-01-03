import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.7.5"
    id("io.spring.dependency-management") version "1.0.15.RELEASE"
    kotlin("jvm") version "1.7.20"
    kotlin("plugin.spring") version "1.7.20"
    `maven-publish`
}

group = "github.haoqi123"
version = "0.0.1-beta"
java.sourceCompatibility = JavaVersion.VERSION_1_8

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
    testImplementation("com.baomidou:mybatis-plus-boot-starter:3.5.2")

    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    compileOnly("com.baomidou:mybatis-plus-boot-starter:3.5.2")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "1.8"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

java {
    //withJavadocJar()
    withSourcesJar()
}

publishing {
    publications {
        create<MavenPublication>("haoQi") {
            groupId = "${project.group}"
            artifactId = project.name
            version = "${project.version}"
            from(components["java"])
        }
    }
}

tasks.jar {
    archiveClassifier.set("")
}


//sourceSets {
//    main {
////        java {
////             忽略所有的 src/main/java/test目录
////            exclude("com/baomidou/**")
////        }
//        resources {
//            // 打包忽略目录: src/main/resources/img
//            exclude("com/baomidou/**")
//            // 打包忽略文件: src/main/resources/icons/scanner.vsdx
////            exclude 'icons/scanner.vsdx'
//        }
//    }
//}