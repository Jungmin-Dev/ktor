package study.ktor.infrastructure.config

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.response.*
import study.ktor.adapter.http.response.ErrorResponse

fun Application.exceptionConfig() {
    install(StatusPages) {
        exception<RuntimeException> { call, cause ->
            call.respond(
                HttpStatusCode.InternalServerError,
                ErrorResponse(
                    HttpStatusCode.InternalServerError.value,
                    "internal_server_error",
                    cause.message ?: "Internal Server Error"
                )
            )
        }
    }
}
