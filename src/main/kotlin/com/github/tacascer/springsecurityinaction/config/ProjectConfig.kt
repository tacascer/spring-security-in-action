package com.github.tacascer.springsecurityinaction.config

import com.github.tacascer.springsecurityinaction.security.AuthenticationProviderService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.ProviderManager
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.invoke
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder
import org.springframework.security.web.SecurityFilterChain


@Configuration
@EnableWebSecurity
class ProjectConfig {
    @Bean
    fun bCryptPasswordEncoder() = BCryptPasswordEncoder()

    @Bean
    fun sCryptPasswordEncoder() = SCryptPasswordEncoder.defaultsForSpringSecurity_v5_8()!!

    @Bean
    fun authenticationManager(authenticationProviderService: AuthenticationProviderService) =
        ProviderManager(authenticationProviderService)

    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http {
            formLogin {
                defaultSuccessUrl("/main", alwaysUse = true)
            }
            authorizeRequests {
                authorize(anyRequest, authenticated)
            }
        }
        return http.build()
    }
}