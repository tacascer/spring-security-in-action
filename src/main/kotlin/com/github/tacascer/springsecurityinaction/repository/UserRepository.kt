package com.github.tacascer.springsecurityinaction.repository

import com.github.tacascer.springsecurityinaction.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long> {
    fun findByUsername(username: String): User?
}
