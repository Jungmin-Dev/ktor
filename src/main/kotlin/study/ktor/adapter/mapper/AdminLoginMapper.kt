package study.ktor.adapter.mapper

import org.mapstruct.Mapper
import study.ktor.adapter.http.request.AdminLoginRequest
import study.ktor.application.dto.AdminLoginServiceDto

@Mapper
interface AdminLoginMapper {
    fun adminLoginRequestToServiceDto(dto: AdminLoginRequest): AdminLoginServiceDto
}
