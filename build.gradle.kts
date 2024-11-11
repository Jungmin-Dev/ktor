val kotlin_version: String by project
val logback_version: String by project

plugins {
    kotlin("jvm") version "2.0.21"
    kotlin("plugin.serialization") version "2.0.21" // 추가: Kotlinx Serialization 플러그인
    kotlin("kapt") version "2.0.21" // kapt 플러그인 추가

    id("io.ktor.plugin") version "3.0.1"
}

group = "study.ktor"
version = "0.0.1"

application {
    mainClass.set("io.ktor.server.netty.EngineMain")

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

repositories {
    mavenCentral()
}

dependencies {
    /** DI 라이브러리 Koin **/
    implementation("io.insert-koin:koin-ktor:4.0.0")
    implementation("io.insert-koin:koin-logger-slf4j:4.0.0")

    /** Mapper **/
    kapt("org.mapstruct:mapstruct-processor:1.6.2")
    implementation("org.mapstruct:mapstruct:1.6.2")

    /** 데이터베이스 exposed **/
    implementation("org.jetbrains.exposed:exposed-core:0.56.0")
    implementation("org.jetbrains.exposed:exposed-dao:0.56.0")
    implementation("org.jetbrains.exposed:exposed-jdbc:0.56.0")


    /** JSON 변환기 의존성 추가 **/
    implementation("io.ktor:ktor-serialization-kotlinx-json:3.0.1")
    implementation("io.ktor:ktor-server-content-negotiation:3.0.1")

    /** mysql 데이터베이스 **/
    implementation("com.mysql:mysql-connector-j:9.1.0")
    implementation("com.zaxxer:HikariCP:6.0.0")

    /** Status-pages Exception 관리 **/
    implementation("io.ktor:ktor-server-status-pages:3.0.1")

    /** 로그 **/
    implementation("io.ktor:ktor-server-call-logging-jvm:3.0.1")

    
    implementation("ch.qos.logback:logback-classic:$logback_version")


    implementation("io.ktor:ktor-server-core-jvm:3.0.1")
    implementation("io.ktor:ktor-server-netty-jvm:3.0.1")
    implementation("io.ktor:ktor-server-config-yaml")
    testImplementation("io.ktor:ktor-server-test-host-jvm")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")
}
