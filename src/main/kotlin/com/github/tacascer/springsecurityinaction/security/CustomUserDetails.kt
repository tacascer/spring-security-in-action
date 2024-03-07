package com.github.tacascer.springsecurityinaction.security

import com.github.tacascer.springsecurityinaction.entity.User
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class CustomUserDetails(val user: User) : UserDetails {
    override fun getAuthorities(): MutableCollection<out GrantedAuthority> =
        user.authorities.map { SimpleGrantedAuthority(it.name) }.toMutableList()

    override fun getPassword() = user.password

    override fun getUsername() = user.username

    override fun isAccountNonExpired() = true

    override fun isAccountNonLocked() = true

    override fun isCredentialsNonExpired() = true

    override fun isEnabled() = true

}