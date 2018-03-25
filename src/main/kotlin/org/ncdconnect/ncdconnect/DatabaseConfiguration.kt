package org.ncdconnect.ncdconnect

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.jdbc.datasource.DriverManagerDataSource
import java.net.URI


@Configuration
class DatabaseConfiguration(
    @Value("\${spring.datasource.driver-class-name:org.postgresql.Driver}")
    private val driverClassName: String,

    @Value("\${database.url}")
    private val databaseUrl: String,

    @Value("\${database.require-ssl:true}")
    private val requireSSL: Boolean
) {

    @Bean
    fun dataSource(): DriverManagerDataSource {
        val dbUri = URI(databaseUrl)

        val userParts = dbUri.userInfo.split(":")
        val username = userParts[0]
        val password = userParts[1]
        val dbUrl = "jdbc:postgresql://${dbUri.host}${dbUri.path}${getSSLMode()}"

        return DriverManagerDataSource()
            .apply {
                setDriverClassName(driverClassName)
                url = dbUrl
                this.username = username
                this.password = password
            }
    }

    private fun getSSLMode(): String {
        return if (requireSSL) {
            "?sslmode=require"
        } else {
            ""
        }
    }
}