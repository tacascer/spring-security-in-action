package com.github.tacascer.springsecurityinaction.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.invoke
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.password.NoOpPasswordEncoder
import org.springframework.security.provisioning.InMemoryUserDetailsManager
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter

@Configuration
@EnableWebSecurity
class SecurityConfig {
    @Bean
    fun userDetailsService(): UserDetailsService {
        val manager = InMemoryUserDetailsManager()
        val user1 = User.withUsername("john")
            .password("12345")
            .roles("ADMIN")
            .build()

        val user2 = User.withUsername("jane")
            .password("12345")
            .roles("MANAGER")
            .build()

        manager.createUser(user1)
        manager.createUser(user2)

        return manager
    }

    @Bean
    fun passwordEncoder() = NoOpPasswordEncoder.getInstance()!!

    @Bean
    fun httpSecurity(http: HttpSecurity, filter: StaticKeyAuthenticationFilter): SecurityFilterChain {
        http {
            addFilterAt<BasicAuthenticationFilter>(filter)
            authorizeRequests {
                authorize(anyRequest, permitAll)
            }
        }
        return http.build()
    }
}