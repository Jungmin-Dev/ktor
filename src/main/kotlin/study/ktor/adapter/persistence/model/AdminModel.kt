package study.ktor.adapter.persistence.model

import kotlinx.serialization.Serializable

@Serializable
data class AdminModel(
    val adminUid: Long = 0,
    val adminId: String = "",
    val adminName: String = "",
    val adminPwd: String = "",
) {

}
