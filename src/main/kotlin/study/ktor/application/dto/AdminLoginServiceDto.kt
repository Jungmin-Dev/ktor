package study.ktor.application.dto

import kotlinx.serialization.Serializable

@Serializable
class AdminLoginServiceDto(
    val adminId: String,
    val adminPwd: String
)
