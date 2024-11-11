package study.ktor.adapter.http.route

import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject
import org.mapstruct.factory.Mappers
import study.ktor.adapter.http.request.AdminLoginRequest
import study.ktor.adapter.http.response.SuccessResponse
import study.ktor.adapter.mapper.AdminLoginMapper
import study.ktor.application.service.AdminLoginService

fun Application.adminLoginRoute(
) {
    val adminLoginService: AdminLoginService by inject()

    routing {


        get("/") {
            call.respondText("Hello World!")
        }

        post("/") {
            val request = call.receive<AdminLoginRequest>()
            val adminLoginMapper: AdminLoginMapper =
                Mappers.getMapper(AdminLoginMapper::class.java)

            val serviceDto = adminLoginMapper.adminLoginRequestToServiceDto(request)

            val response = adminLoginService.login(serviceDto)

            call.respond(SuccessResponse(code = "200", message = "test", status = 200, body = response))

        }

    }
}
