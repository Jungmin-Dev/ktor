package study.ktor.application.mapper

import org.mapstruct.Mapper
import study.ktor.adapter.persistence.model.AdminModel
import study.ktor.application.response.AdminServiceResponse

@Mapper
interface AdminServiceMapper {
    fun adminServiceToResponse(adminModel: AdminModel): AdminServiceResponse
}
