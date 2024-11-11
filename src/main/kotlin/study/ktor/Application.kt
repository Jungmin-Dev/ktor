package study.ktor

import io.ktor.server.application.*
import study.ktor.adapter.http.route.adminLoginRoute
import study.ktor.infrastructure.config.*

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    configureSerialization()
    adminLoginRoute()
    configureDatabase()
    configureKoin()
    exceptionConfig()
    logginConfig()
}
