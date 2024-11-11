package study.ktor.application.service

import study.ktor.application.dto.AdminLoginServiceDto
import study.ktor.application.response.AdminServiceResponse

interface AdminLoginService {
    suspend fun login(adminLoginServiceDto: AdminLoginServiceDto): AdminServiceResponse?
}
