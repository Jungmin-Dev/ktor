package study.ktor.adapter.persistence.repository

import study.ktor.adapter.persistence.entity.AdminDetailEntity
import study.ktor.adapter.persistence.entity.AdminEntity
import study.ktor.adapter.persistence.model.AdminModel
import study.ktor.application.dto.AdminLoginServiceDto
import study.ktor.infrastructure.config.DatabaseConfigUtil.dbQuery
import study.ktor.infrastructure.config.logger

class AdminRepositoryImpl : AdminRepository {
    private val logger = logger()
    override suspend fun adminLogin(adminLoginServiceDto: AdminLoginServiceDto): AdminModel? {

        val query = dbQuery {
            (AdminEntity innerJoin AdminDetailEntity)
                .select(
                    listOf(
                        AdminEntity.adminUid,
                        AdminEntity.adminId,
                        AdminDetailEntity.adminName
                    )
                ).orderBy(AdminEntity.adminUid)
                .map {
                    AdminModel(
                        adminUid = it[AdminEntity.adminUid],
                        adminId = it[AdminEntity.adminId],
                        adminName = it[AdminDetailEntity.adminName]
                    )
                }
        }
        logger.info("query ${query}")

        return AdminModel()
    }
}
