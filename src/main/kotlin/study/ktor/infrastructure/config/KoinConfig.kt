package study.ktor.infrastructure.config

import io.ktor.server.application.*
import org.koin.dsl.module
import org.koin.ktor.plugin.Koin
import org.koin.logger.slf4jLogger
import study.ktor.adapter.persistence.repository.AdminRepository
import study.ktor.adapter.persistence.repository.AdminRepositoryImpl
import study.ktor.application.service.AdminLoginService
import study.ktor.application.service.AdminServiceImpl


fun Application.configureKoin() {
    install(Koin) {
        slf4jLogger()
        modules(appModule)
    }

}

val appModule = module {
    single<AdminRepository> { AdminRepositoryImpl() }
    single<AdminLoginService> { AdminServiceImpl(get()) }
}
