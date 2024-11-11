package study.ktor.adapter.http.response

import kotlinx.serialization.Serializable

@Serializable
class SuccessResponse<T>(
    val code: String,
    val message: String,
    val status: Int,
    val body: T
) {
}
