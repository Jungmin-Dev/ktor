package study.ktor.adapter.persistence.entity

import org.jetbrains.exposed.sql.Table

object AdminDetailEntity : Table("ADMIN_DETAIL") {
    val adminUid = long("ADMIN_UID").references(AdminEntity.adminUid) // 외래 키 설정
    val adminName = varchar("ADMIN_NAME", 255)
    override val primaryKey = PrimaryKey(adminUid, name = "PK_ADMIN_DETAIL_UID")
}
