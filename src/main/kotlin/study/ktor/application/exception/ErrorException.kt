package study.ktor.application.exception

class ErrorException(
    val status: String = "", message: String
) : RuntimeException(message)
