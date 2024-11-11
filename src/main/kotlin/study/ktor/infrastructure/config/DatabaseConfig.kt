package study.ktor.infrastructure.config

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import io.ktor.server.application.*
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.transactions.transaction
import study.ktor.infrastructure.config.DatabaseConfigUtil.connectDatabase

fun Application.configureDatabase() {
    val driverName = "com.mysql.cj.jdbc.Driver"
    val databaseUrl = "jdbc:mysql://localhost:3306/ktor?useSSL=false&characterEncoding=UTF-8&serverTimezone=Asia/Seoul"
    val databaseUser = "root"
    val databasePassword = "root"

    connectDatabase(driverName, databaseUrl, databaseUser, databasePassword)
}

object DatabaseConfigUtil {

    fun connectDatabase(driver: String, dbUrl: String, dbUser: String, dbPassword: String) {
        try {
            val hikari = HikariDataSource(

                HikariConfig().apply {
                    driverClassName = driver
                    jdbcUrl = dbUrl
                    username = dbUser
                    password = dbPassword
                    maximumPoolSize = 10
                    isAutoCommit = false
                    transactionIsolation = "TRANSACTION_REPEATABLE_READ"
                }
            )

            Database.connect(hikari)

        } catch (e: Exception) {
            throw RuntimeException("Failed to connect to the database. Shutting down the server.")
        }

    }

    fun <T> dbQuery(
        block: () -> T
    ): T = transaction {
        block()
    }
}
