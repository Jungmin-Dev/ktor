package study.ktor.adapter.persistence.entity

import org.jetbrains.exposed.sql.Table

object AdminEntity : Table("ADMIN") {
    val adminUid = long("ADMIN_UID").autoIncrement() // Long 타입의 컬럼
    val adminId = varchar("ADMIN_ID", 255) // String 타입의 컬럼
    val adminPwd = varchar("ADMIN_PWD", 255) // String 타입의 컬럼

    override val primaryKey = PrimaryKey(adminUid) // adminUid를 기본 키로 지정
}

