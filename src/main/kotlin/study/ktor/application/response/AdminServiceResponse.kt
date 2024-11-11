package study.ktor.application.response

import kotlinx.serialization.Serializable

@Serializable
class AdminServiceResponse(
    val adminId: String
) {
}
