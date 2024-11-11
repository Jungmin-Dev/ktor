package study.ktor.adapter.persistence.repository

import study.ktor.adapter.persistence.model.AdminModel
import study.ktor.application.dto.AdminLoginServiceDto

interface AdminRepository {
    suspend fun adminLogin(adminLoginServiceDto: AdminLoginServiceDto): AdminModel?
}
