package com.github.tacascer.springsecurityinaction.security

import com.github.tacascer.springsecurityinaction.entity.EncryptionAlgorithm.BCRYPT
import com.github.tacascer.springsecurityinaction.entity.EncryptionAlgorithm.SCRYPT
import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder
import org.springframework.stereotype.Service

@Service
class AuthenticationProviderService(
    private val userDetailsService: JpaUserDetailsService,
    private val bCryptPasswordEncoder: BCryptPasswordEncoder,
    private val sCryptPasswordEncoder: SCryptPasswordEncoder
) : AuthenticationProvider {
    override fun authenticate(authentication: Authentication): Authentication {
        val username = authentication.name
        val password = authentication.credentials.toString()
        val user = userDetailsService.loadUserByUsername(username)
        return when (user.user.algorithm) {
            BCRYPT -> checkPassword(password, user, bCryptPasswordEncoder)
            SCRYPT -> checkPassword(password, user, sCryptPasswordEncoder)
        }
    }

    override fun supports(authentication: Class<*>): Boolean {
        return UsernamePasswordAuthenticationToken::class.java.isAssignableFrom(authentication)
    }

    private fun checkPassword(
        password: String, user: CustomUserDetails, passwordEncoder: PasswordEncoder
    ): UsernamePasswordAuthenticationToken {
        if (passwordEncoder.matches(password, user.password))
            return UsernamePasswordAuthenticationToken(user, password, user.authorities)
        throw BadCredentialsException("Bad credentials")
    }
}