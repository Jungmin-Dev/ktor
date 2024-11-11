package study.ktor.application.service


import org.mapstruct.factory.Mappers
import study.ktor.adapter.persistence.repository.AdminRepository
import study.ktor.application.dto.AdminLoginServiceDto
import study.ktor.application.exception.ErrorException
import study.ktor.application.mapper.AdminServiceMapper
import study.ktor.application.response.AdminServiceResponse

class AdminServiceImpl(
    val adminRepository: AdminRepository
) : AdminLoginService {
    override suspend fun login(adminLoginServiceDto: AdminLoginServiceDto): AdminServiceResponse? {

        val adminServiceMapper: AdminServiceMapper =
            Mappers.getMapper(AdminServiceMapper::class.java)

        /** 여기서 Model로 반환 **/
        val model = adminRepository.adminLogin(adminLoginServiceDto) ?: throw ErrorException(
            "createSiteAdmin-findById",
            "등록된 관리자 정보를 찾을 수 없습니다."
        )

        val response = adminServiceMapper.adminServiceToResponse(model)
        return response;
    }
}
