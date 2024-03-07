package com.github.tacascer.springsecurityinaction.security

import com.github.tacascer.springsecurityinaction.repository.UserRepository
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class JpaUserDetailsService(private val userRepository: UserRepository) : UserDetailsService {
    override fun loadUserByUsername(username: String): CustomUserDetails {
        userRepository.findByUsername(username)?.let {
            return CustomUserDetails(it)
        } ?: throw UsernameNotFoundException("User $username not found")
    }
}