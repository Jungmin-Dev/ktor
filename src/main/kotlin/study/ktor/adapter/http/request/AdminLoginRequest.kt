package study.ktor.adapter.http.request

import kotlinx.serialization.Serializable

@Serializable
data class AdminLoginRequest(
    val adminId: String,
    val adminPwd: String
) {
}
