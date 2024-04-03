package com.github.tacascer.springsecurityinaction.repository

import com.github.tacascer.springsecurityinaction.entities.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, String>{
    fun findUserByUsername(username: String): User?
}