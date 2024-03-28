package com.github.tacascer.springsecurityinaction.config

import jakarta.servlet.Filter
import jakarta.servlet.FilterChain
import jakarta.servlet.ServletRequest
import jakarta.servlet.ServletResponse
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class StaticKeyAuthenticationFilter(
    @Value("\${authorization.key}")
    private val authorizationKey: String
) : Filter {
    override fun doFilter(request: ServletRequest, response: ServletResponse, filterChain: FilterChain) {
        val httpRequest = request as HttpServletRequest
        val httpResponse = response as HttpServletResponse

        val authorization = httpRequest.getHeader("Authorization")

        if (authorizationKey == authorization) {
            filterChain.doFilter(request, response)
        } else {
            httpResponse.status = HttpServletResponse.SC_UNAUTHORIZED
        }
    }
}