package study.ktor.infrastructure.config

import io.ktor.server.application.*
import io.ktor.server.plugins.calllogging.*
import io.ktor.server.request.*
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.slf4j.event.Level

inline fun <reified T> T.logger(): Logger = LoggerFactory.getLogger(T::class.java)

fun Application.logginConfig() {
    install(CallLogging) {
        level = Level.INFO
        filter { call -> call.request.path().startsWith("/") }
    }
}
