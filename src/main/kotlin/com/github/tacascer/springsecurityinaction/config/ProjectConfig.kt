package com.github.tacascer.springsecurityinaction.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.password.NoOpPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.provisioning.JdbcUserDetailsManager
import javax.sql.DataSource

@Configuration
@EnableWebSecurity
class ProjectConfig {

    @Bean
    fun userDetailsService(datasource: DataSource): UserDetailsService {
        val usersByUsernameQuery = "select username, password, enabled from spring.users where username = ?"
        val authsByUserQuery = "select username, authority from spring.authorities where username = ?"
        val jdbcUserDetailsManager = JdbcUserDetailsManager(datasource)
        jdbcUserDetailsManager.usersByUsernameQuery = usersByUsernameQuery
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(authsByUserQuery)
        return jdbcUserDetailsManager
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return NoOpPasswordEncoder.getInstance()
    }
}