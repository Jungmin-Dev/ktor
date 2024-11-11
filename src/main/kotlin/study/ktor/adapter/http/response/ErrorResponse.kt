package study.ktor.adapter.http.response

import kotlinx.serialization.Serializable

@Serializable
data class ErrorResponse<T>(
    val code: Int,
    val status: String,
    val message: T
) {
}
